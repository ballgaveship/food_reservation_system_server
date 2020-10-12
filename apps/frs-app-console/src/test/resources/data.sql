insert into person (name, email) values ('tester', 'tester@email.com');
insert into person (name, email) values ('hkdong', 'hkdong@email.com');
insert into person (name, email) values ('jbkong', 'jbkong@email.com');

insert into role (key, title) values ('ADMIN', 'ADMIN');
insert into role (key, title) values ('USER', 'USER');

insert into person_role (person_id, role_id) values (1, 1);
insert into person_role (person_id, role_id) values (2, 2);
insert into person_role (person_id, role_id) values (3, 2);