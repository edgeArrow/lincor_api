drop table if exists item;

create table item (
    id uuid not null primary key,
    name varchar(50)
);

insert into item(id, name) values ('b47f7901-48ab-4822-91ec-74acb6ad788d',  'Item 1' ),
                                  (RANDOM_UUID(),  'Item 2' ),
                                  (RANDOM_UUID(),  'Item 3' );