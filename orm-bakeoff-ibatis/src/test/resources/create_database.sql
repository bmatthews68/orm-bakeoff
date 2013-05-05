create table posts (
	post_id char(36) not null,
	post_title varchar(50) not null,
	post_body varchar(4096) not null,
	primary key (post_id)
);

create table post_tags (
	post_id char(36) not null,
	tag_value varchar(50) not null,
	primary key (post_id, tag_value)
);