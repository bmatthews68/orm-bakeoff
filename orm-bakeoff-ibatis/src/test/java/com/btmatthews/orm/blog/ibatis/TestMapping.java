package com.btmatthews.orm.blog.ibatis;

import java.io.Reader;
import java.util.List;

import com.btmatthews.orm.blog.ibatis.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestMapping {

	private SqlMapClient sqlmapClient;
	
	@Before
	public void setup() throws Exception {
		final Reader reader = Resources.getResourceAsReader("sqlmaps-config.xml");
		sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
	}


	@SuppressWarnings("unchecked")
	@Test
	public void test() throws Exception {
		final List<Post> results = (List<Post>)sqlmapClient.queryForList("Post.getAll");
		Assert.assertNotNull(results);
		for (final Post result : results) {
			System.out.println(result.getTitle());
			for (final String value : result.getTags()) {
				System.out.println("\t" + value);
			}
		}
	}
}
