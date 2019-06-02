/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE if exists poems cascade;
drop table if exists users cascade;

create table users(
    id smallint PRIMARY KEY ,
    name varchar(25) not null ,
    password text not null
);

create table poems(
    id smallint primary key ,
    user_id smallint not null ,
    title text not null ,
    content text not null ,
    foreign key (user_id) references users(id)
);

insert into users values (1, 'mc zsolax', 'qwer1234');
insert into users values (2, 'Zana Zoltán', 'qwer1234') ;
insert into users values (3, 'Mike Mykanic', 'qwer1234');
insert into users values (4, 'asd', 'qwer1234');


INSERT INTO poems values (4, 1, 'Lenn az utszán', 'Len az utszán nincsen kegyelem Len az utszán nincsen szerelem Len az utszán élnek fiatalok és gyerekek. Len az utszán MC Zsolax reppel nektek Len az utszán ');
INSERT INTO poems VALUES (5, 2, 'Ki a fasza gyerek?', 'Ki a fasza gyerek most ő, ő, vagy én? Hiába erőlködsz mert minden csak az enyém. Én nem vagyok a Hip-Hop nemzet feje csak a fasza, dehát nincs is Hip-Hop nemzet, csak Lory, Zoli, Szasza. 30 vagyok és nem sokat szarozok, de pisis hülyegyerekekkel nem foglalkozom. ');
INSERT INTO poems VALUES (6, 3, 'No good', 'Minek csinálod, ha nem jó neked? Minek? Minek buziskodsz, ha nem jó neked? Hallod?! Hogyha úgy érzed, hogy nem jó neked, csak mondd, hogy ez..nem..Jó Nekem!');

