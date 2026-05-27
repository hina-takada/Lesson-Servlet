create table registration(
        id int auto_increment primary key,
        count int not null,
        payment varchar(4),
        review varchar(200),
        mail varchar(15)
)
