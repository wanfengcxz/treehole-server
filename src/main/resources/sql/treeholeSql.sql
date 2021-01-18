-- 用户表
create table `User`(
    `id` int(11) not null primary key auto_increment,
    `user_name` varchar(50) not null,
    `phone` char(11) not null unique,
    `password` char(32) not null,
    `face_url` varchar(250) not null
);

-- 测试
insert into `User` values(0,'Amazing','15137423965','12345','aaa.jpg');
insert into `User` values(0,'YESOK','15137426755','123456','bbb.jpg');

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
insert into `Message` values(0,1,'Amazing','aaa.jpg','今天天气真不错',0,1234567891);

select * from `Message`;

select * from `Message`;

delete from `Message` where user_id=3;

delete from `Message` where id < 15;

delete from `User` where id < 15;

insert into `User` values(0,'三分饱','12345678911','123456','https://wanfengcxz.cn/treehole/images/icons/avatar01.jpg');
insert into `User` values(0,'狐狸先生和他的朋友','12345678922','123456','https://wanfengcxz.cn/treehole/images/icons/avatar02.jpg');
insert into `User` values(0,'带带我鸭','12345678933','123456','https://wanfengcxz.cn/treehole/images/icons/avatar03.jpg');
insert into `User` values(0,'鬼面人','12345678944','123456','https://wanfengcxz.cn/treehole/images/icons/avatar04.jpg');
insert into `User` values(0,'一个人的旅行','12345678955','123456','https://wanfengcxz.cn/treehole/images/icons/avatar05.jpg');
insert into `User` values(0,'柠檬汽水','12345678966','123456','https://wanfengcxz.cn/treehole/images/icons/avatar06.jpg');
insert into `User` values(0,'带带大师兄','12345678977','123456','https://wanfengcxz.cn/treehole/images/icons/sxc.png');

insert into `Message` values(0,15,'Amazing','aaa.jpg','今天天气真不错',0,1234567891);

