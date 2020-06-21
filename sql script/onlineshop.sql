use online_shop_demo;
create table if not exists user(
username varchar(20) not null,
`password` varchar(20) not null,
email varchar(48) not null,
`name` varchar(10) not null,
cellnum varchar(10),
address varchar(60),
register_time timestamp default current_timestamp,
primary key(username),
unique key(email)
)