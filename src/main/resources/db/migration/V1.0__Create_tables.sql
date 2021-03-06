create table ads
(
    id                int8 generated by default as identity,
    deleted           boolean      not null,
    car_name          varchar(255) not null,
    description       varchar(255) not null,
    price             int4         not null,
    year              varchar(255) not null,
    classification_id int8,
    primary key (id)
);

create table classifications
(
    id          int8 generated by default as identity,
    deleted     boolean      not null,
    appointment varchar(255) not null,
    primary key (id)
);

alter table if exists ads
    add constraint FK8h7jlaxnvroutoyjfp9eid9u4 foreign key (classification_id) references classifications;