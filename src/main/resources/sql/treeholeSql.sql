-- 用户表
create table `User`(
    `id` int(11) not null primary key auto_increment,
    `user_name` varchar(50) not null,
    `phone` char(11) not null unique,
    `password` char(32) not null,
    `face_url` varchar(250) not null
);

-- 测试
insert into `User` values(0,'Amazing','15137422222','abcdefg','aaa.jpg');
insert into `User` values(0,'Great','15137423333','hijklmn','bbb.jpg');

select * from User;

-- 树洞表
create table `Message`(
    `id` int(11) not null auto_increment primary key,
    `user_id` int(11) not null,
    `user_name` varchar(50) not null,
    `face_url` varchar(50) not null,
    `content` varchar(500) not null,
    `total_likes` int(11) not null Default 0,
    `send_timestamp` int(11) not null,
    constraint `fk_id_uid` foreign key (`user_id`) references `User`(`id`)
);

-- 测试
insert into `Message` values(0,3,'Amazing','bbbba.jpg','我今天很开心1231231',0,1234567891);

select * from `Message`;

select * from `Message`;

delete from `Message` where user_id=3;