/*DROP TABLE IF EXISTS user ;
DROP TABLE IF EXISTS authority ;
DROP TABLE IF EXISTS user_authority ;
DROP TABLE IF EXISTS user_recycle ;
DROP TABLE IF EXISTS recycle ;
DROP TABLE IF EXISTS schedule ;
DROP TABLE IF EXISTS vehicle ;
*/

create table if not exists user
(
id int AUTO_INCREMENT primary key,
username varchar(100) not null,
password varchar(250) not null,
firstname varchar(250) not null,
lastname varchar(250) not null,
address varchar(250) not null,
email varchar(250) not null
);

create table if not exists authority
(
id int primary key,
name varchar(100) not null
);

create table if not exists user_authority
(
user_id int not null,
authority_id int not null,
PRIMARY KEY (`user_id`,`authority_id`),
CONSTRAINT `fk_userid`
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
CONSTRAINT `fk_authorityid`
FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`)
);

create table if not exists recycle
(
id int AUTO_INCREMENT primary key ,
amount int not null,
year_month mediumint not null,
type varchar(50) not null
);


create table if not exists user_recycle
(
user_id int not null,
recycle_id int not null,
PRIMARY KEY (`user_id`,`recycle_id`),
CONSTRAINT `fk_1`
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
CONSTRAINT `fk_2`
FOREIGN KEY (`recycle_id`) REFERENCES `recycle` (`id`)
);

create table if not exists schedule
(
 id int AUTO_INCREMENT primary key,
 day int not null,
 address varchar(250) not null,
 type varchar(50) not null
);

create table if not exists vehicle
(
 id int AUTO_INCREMENT primary key,
 brand varchar(50) not null,
 first_registration_year int(4) not null,
 location varchar(250) not null
);
