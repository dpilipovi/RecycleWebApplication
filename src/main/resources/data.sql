insert into user (id,address,email,firstname,lastname,password,username) values(1,'Ilica 27','admin@email.com','admin','admin','$2a$10$tbPePOo.rqP5QEpA.lUqyOAT9rb5uVfXvCK6.qIOf.DpgtUuiMQT6','admin');
insert into user (id,address,email,firstname,lastname,password,username) values(2,'Vrbik 8','pperic@email.com','Pero','Peric','$2a$10$tbPePOo.rqP5QEpA.lUqyOAT9rb5uVfXvCK6.qIOf.DpgtUuiMQT6','pperic');

insert into authority (id, name) values (1, 'ROLE_ADMIN');
insert into authority (id, name) values (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id) values (1, 1);
/*insert into user_authority (user_id, authority_id) values (1, 2);*/
insert into user_authority (user_id, authority_id) values (2, 2);

insert into schedule (id,address,day,type) values(1,'Ilica','Friday','Plastic');
insert into schedule (id,address,day,type) values(2,'Ilica','Wednesday','Paper');
insert into schedule (id,address,day,type) values(3,'Ilica','Thursday','Glass');
insert into schedule (id,address,day,type) values(4,'Ilica','Monday','Metal');

insert into schedule (id,address,day,type) values(5,'Vrbik','Monday','Glass');
insert into schedule (id,address,day,type) values(6,'Vrbik','Tuesday','Metal');
insert into schedule (id,address,day,type) values(7,'Vrbik','Wednesday','Plastic');
insert into schedule (id,address,day,type) values(8,'Vrbik','Thursday','Paper');

/*
insert into type values(1,'Plastic');
insert into type values(2,'Paper');
insert into type values(3,'Glass');
insert into type values(4,'Metal');
*/
insert into recycle (id, amount, year_month, type) values (1, 3, 202002,'Glass');
insert into recycle (id, amount, year_month, type) values (2, 1, 202002,'Metal');
insert into recycle (id, amount, year_month, type) values (3, 2, 202002,'Plastic');
insert into recycle (id, amount, year_month, type) values (4, 6, 202002,'Paper');

insert into recycle (id, amount, year_month, type) values (5, 3, 202003,'Glass');
insert into recycle (id, amount, year_month, type) values (6, 3, 202003,'Metal');
insert into recycle (id, amount, year_month, type) values (7, 5, 202003,'Plastic');
insert into recycle (id, amount, year_month, type) values (8, 1, 202003,'Paper');

insert into recycle (id, amount, year_month, type) values (9, 4, 202002,'Glass');
insert into recycle (id, amount, year_month, type) values (10, 10, 202002,'Metal');
insert into recycle (id, amount, year_month, type) values (11, 2, 202002,'Plastic');
insert into recycle (id, amount, year_month, type) values (12, 1, 202002,'Paper');

insert into recycle (id, amount, year_month, type) values (13, 1, 202003,'Glass');
insert into recycle (id, amount, year_month, type) values (14, 1, 202003,'Metal');
insert into recycle (id, amount, year_month, type) values (15, 4, 202003,'Plastic');
insert into recycle (id, amount, year_month, type) values (16, 2, 202003,'Paper');

insert into user_recycle (user_id, recycle_id) values (1, 1);
insert into user_recycle (user_id, recycle_id) values (1, 2);
insert into user_recycle (user_id, recycle_id) values (1, 3);
insert into user_recycle (user_id, recycle_id) values (1, 4);

insert into user_recycle (user_id, recycle_id) values (1, 5);
insert into user_recycle (user_id, recycle_id) values (1, 6);
insert into user_recycle (user_id, recycle_id) values (1, 7);
insert into user_recycle (user_id, recycle_id) values (1, 8);

insert into user_recycle (user_id, recycle_id) values (2, 9);
insert into user_recycle (user_id, recycle_id) values (2, 10);
insert into user_recycle (user_id, recycle_id) values (2, 11);
insert into user_recycle (user_id, recycle_id) values (2, 12);

insert into user_recycle (user_id, recycle_id) values (2, 13);
insert into user_recycle (user_id, recycle_id) values (2, 14);
insert into user_recycle (user_id, recycle_id) values (2, 15);
insert into user_recycle (user_id, recycle_id) values (2, 16);

insert into vehicle (id, brand, first_registration_year, location) values (1, 'Mercedes', 2007, 'Ilica 1');
insert into vehicle (id, brand, first_registration_year, location) values (2, 'Mercedes', 2017, 'Vatikanska ulica 1');
insert into vehicle (id, brand, first_registration_year, location) values (3, 'Mercedes', 2013, 'Trg bana Josipa Jelacica 1');
insert into vehicle (id, brand, first_registration_year, location) values (4, 'MAN', 2014, 'Ulica grada Vukovara 1');
