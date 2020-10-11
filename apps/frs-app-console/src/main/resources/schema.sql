drop table if exists person;
drop table if exists role;

CREATE TABLE person
(
    id int(8) NOT NULL AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role
(
    id int(8) NOT NULL AUTO_INCREMENT,
    key varchar(10) NOT NULL,
    title varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

insert into role (key, title) values ('ADMIN', 'ADMIN');