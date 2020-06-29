insert into user (id,address,email,firstname,lastname,password,username) values(1,'Ilica 27','admin@email.com','admin','admin','$2a$10$tbPePOo.rqP5QEpA.lUqyOAT9rb5uVfXvCK6.qIOf.DpgtUuiMQT6','admin');
insert into user (id,address,email,firstname,lastname,password,username) values(2,'Vrbik 8','pperic@email.com','Pero','Peric','$2a$10$tbPePOo.rqP5QEpA.lUqyOAT9rb5uVfXvCK6.qIOf.DpgtUuiMQT6','pperic');

insert into authority (id, name) values (1, 'ROLE_ADMIN');
insert into authority (id, name) values (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id) values (1, 1);
/*insert into user_authority (user_id, authority_id) values (1, 2);*/
insert into user_authority (user_id, authority_id) values (2, 2);

insert into schedule (id,address,day,type) values(1,'Ilica',5,'Plastic');
insert into schedule (id,address,day,type) values(2,'Ilica',3,'Paper');
insert into schedule (id,address,day,type) values(3,'Ilica',2,'Glass');
insert into schedule (id,address,day,type) values(4,'Ilica',1,'Metal');

insert into schedule (id,address,day,type) values(5,'Vrbik',1,'Glass');
insert into schedule (id,address,day,type) values(6,'Vrbik',2,'Metal');
insert into schedule (id,address,day,type) values(7,'Vrbik',3,'Plastic');
insert into schedule (id,address,day,type) values(8,'Vrbik',4,'Paper');

/*
insert into type values(1,'Plastic');
insert into type values(2,'Paper');
insert into type values(3,'Glass');
insert into type values(4,'Metal');
*/
insert into recycle (id, amount, year_month, type) values (1, 3, 202001,'Glass');
insert into recycle (id, amount, year_month, type) values (2, 2, 202001,'Metal');
insert into recycle (id, amount, year_month, type) values (3, 4, 202001,'Plastic');
insert into recycle (id, amount, year_month, type) values (4, 3, 202001,'Paper');

insert into recycle (id, amount, year_month, type) values (5, 3, 202002,'Glass');
insert into recycle (id, amount, year_month, type) values (6, 1, 202002,'Metal');
insert into recycle (id, amount, year_month, type) values (7, 2, 202002,'Plastic');
insert into recycle (id, amount, year_month, type) values (8, 6, 202002,'Paper');

insert into recycle (id, amount, year_month, type) values (9, 3, 202003,'Glass');
insert into recycle (id, amount, year_month, type) values (10, 3, 202003,'Metal');
insert into recycle (id, amount, year_month, type) values (11, 5, 202003,'Plastic');
insert into recycle (id, amount, year_month, type) values (12, 1, 202003,'Paper');

insert into recycle (id, amount, year_month, type) values (13, 3, 202004,'Glass');
insert into recycle (id, amount, year_month, type) values (14, 3, 202004,'Metal');
insert into recycle (id, amount, year_month, type) values (15, 3, 202004,'Plastic');
insert into recycle (id, amount, year_month, type) values (16, 3, 202004,'Paper');

insert into recycle (id, amount, year_month, type) values (17, 1, 202005,'Glass');
insert into recycle (id, amount, year_month, type) values (18, 1, 202005,'Metal');
insert into recycle (id, amount, year_month, type) values (19, 0, 202005,'Plastic');
insert into recycle (id, amount, year_month, type) values (20, 2, 202005,'Paper');

insert into recycle (id, amount, year_month, type) values (21, 0, 202006,'Glass');
insert into recycle (id, amount, year_month, type) values (22, 2, 202006,'Metal');
insert into recycle (id, amount, year_month, type) values (23, 2, 202006,'Plastic');
insert into recycle (id, amount, year_month, type) values (24, 1, 202006,'Paper');

insert into recycle (id, amount, year_month, type) values (25, 4, 202001,'Glass');
insert into recycle (id, amount, year_month, type) values (26, 8, 202001,'Metal');
insert into recycle (id, amount, year_month, type) values (27, 2, 202001,'Plastic');
insert into recycle (id, amount, year_month, type) values (28, 1, 202001,'Paper');

insert into recycle (id, amount, year_month, type) values (29, 1, 202002,'Glass');
insert into recycle (id, amount, year_month, type) values (30, 1, 202002,'Metal');
insert into recycle (id, amount, year_month, type) values (31, 4, 202002,'Plastic');
insert into recycle (id, amount, year_month, type) values (32, 2, 202002,'Paper');

insert into recycle (id, amount, year_month, type) values (33, 3, 202003,'Glass');
insert into recycle (id, amount, year_month, type) values (34, 3, 202003,'Metal');
insert into recycle (id, amount, year_month, type) values (35, 0, 202003,'Plastic');
insert into recycle (id, amount, year_month, type) values (36, 0, 202003,'Paper');

insert into recycle (id, amount, year_month, type) values (37, 1, 202004,'Glass');
insert into recycle (id, amount, year_month, type) values (38, 0, 202004,'Metal');
insert into recycle (id, amount, year_month, type) values (39, 1, 202004,'Plastic');
insert into recycle (id, amount, year_month, type) values (40, 1, 202004,'Paper');

insert into recycle (id, amount, year_month, type) values (41, 1, 202005,'Glass');
insert into recycle (id, amount, year_month, type) values (42, 7, 202005,'Metal');
insert into recycle (id, amount, year_month, type) values (43, 0, 202005,'Plastic');
insert into recycle (id, amount, year_month, type) values (44, 0, 202005,'Paper');

insert into recycle (id, amount, year_month, type) values (45, 3, 202006,'Glass');
insert into recycle (id, amount, year_month, type) values (46, 0, 202006,'Metal');
insert into recycle (id, amount, year_month, type) values (47, 2, 202006,'Plastic');
insert into recycle (id, amount, year_month, type) values (48, 2, 202006,'Paper');


insert into user_recycle (user_id, recycle_id) values (1, 1);
insert into user_recycle (user_id, recycle_id) values (1, 2);
insert into user_recycle (user_id, recycle_id) values (1, 3);
insert into user_recycle (user_id, recycle_id) values (1, 4);
insert into user_recycle (user_id, recycle_id) values (1, 5);
insert into user_recycle (user_id, recycle_id) values (1, 6);
insert into user_recycle (user_id, recycle_id) values (1, 7);
insert into user_recycle (user_id, recycle_id) values (1, 8);
insert into user_recycle (user_id, recycle_id) values (1, 9);
insert into user_recycle (user_id, recycle_id) values (1, 10);
insert into user_recycle (user_id, recycle_id) values (1, 11);
insert into user_recycle (user_id, recycle_id) values (1, 12);
insert into user_recycle (user_id, recycle_id) values (1, 13);
insert into user_recycle (user_id, recycle_id) values (1, 14);
insert into user_recycle (user_id, recycle_id) values (1, 15);
insert into user_recycle (user_id, recycle_id) values (1, 16);
insert into user_recycle (user_id, recycle_id) values (1, 17);
insert into user_recycle (user_id, recycle_id) values (1, 18);
insert into user_recycle (user_id, recycle_id) values (1, 19);
insert into user_recycle (user_id, recycle_id) values (1, 20);
insert into user_recycle (user_id, recycle_id) values (1, 21);
insert into user_recycle (user_id, recycle_id) values (1, 22);
insert into user_recycle (user_id, recycle_id) values (1, 23);
insert into user_recycle (user_id, recycle_id) values (1, 24);

insert into user_recycle (user_id, recycle_id) values (2, 25);
insert into user_recycle (user_id, recycle_id) values (2, 26);
insert into user_recycle (user_id, recycle_id) values (2, 27);
insert into user_recycle (user_id, recycle_id) values (2, 28);
insert into user_recycle (user_id, recycle_id) values (2, 29);
insert into user_recycle (user_id, recycle_id) values (2, 30);
insert into user_recycle (user_id, recycle_id) values (2, 31);
insert into user_recycle (user_id, recycle_id) values (2, 32);
insert into user_recycle (user_id, recycle_id) values (2, 33);
insert into user_recycle (user_id, recycle_id) values (2, 34);
insert into user_recycle (user_id, recycle_id) values (2, 35);
insert into user_recycle (user_id, recycle_id) values (2, 36);
insert into user_recycle (user_id, recycle_id) values (2, 37);
insert into user_recycle (user_id, recycle_id) values (2, 38);
insert into user_recycle (user_id, recycle_id) values (2, 39);
insert into user_recycle (user_id, recycle_id) values (2, 40);
insert into user_recycle (user_id, recycle_id) values (2, 41);
insert into user_recycle (user_id, recycle_id) values (2, 42);
insert into user_recycle (user_id, recycle_id) values (2, 43);
insert into user_recycle (user_id, recycle_id) values (2, 44);
insert into user_recycle (user_id, recycle_id) values (2, 45);
insert into user_recycle (user_id, recycle_id) values (2, 46);
insert into user_recycle (user_id, recycle_id) values (2, 47);
insert into user_recycle (user_id, recycle_id) values (2, 48);

insert into vehicle (id, brand, first_registration_year, location) values (1, 'Mercedes', 2007, 'Ilica 1');
insert into vehicle (id, brand, first_registration_year, location) values (2, 'Mercedes', 2017, 'Vatikanska ulica 1');
insert into vehicle (id, brand, first_registration_year, location) values (3, 'Mercedes', 2013, 'Trg bana Josipa Jelacica 1');
insert into vehicle (id, brand, first_registration_year, location) values (4, 'MAN', 2014, 'Ulica grada Vukovara 1');

insert into announcement (id, title, message, created ) values (1, 'Obavijest test', 'Ovo je testiranje rada obavijesti',CURRENT_TIMESTAMP);
insert into announcement (id, title, message, created ) values (2, 'Obavijest o početku odvoza otpada za reciklažu', 'Od idućeg tjedna započinje odvoz plastike, papira, stakla i metala za recikliranje.',CURRENT_TIMESTAMP);
