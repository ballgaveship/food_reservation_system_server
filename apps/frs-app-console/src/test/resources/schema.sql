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
    title varchar(100) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE person_role
(
    person_id int(8) NOT NULL,
    role_id int(8) NOT NULL,
    foreign key (person_id) references person(id),
    foreign key (role_id) references role(id)
);