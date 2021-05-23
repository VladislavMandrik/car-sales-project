create table ads
(
    id                bigint generated by default as identity,
    car_name          varchar(255) not null,
    description       varchar(255) not null,
    price             integer      not null,
    year              varchar(255) not null,
    classification_id bigint,
    primary key (id)
);

create table classifications
(
    id         bigint generated by default as identity,
    appoitment varchar(255) not null,
    primary key (id)
);

alter table ads
    add constraint FK8h7jlaxnvroutoyjfp9eid9u4 foreign key (classification_id) references classifications;
