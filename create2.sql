create table es_accessories (id_accessories integer generated by default as identity, name_accessories varchar(255), id_product integer, primary key (id_accessories))
create table es_product (id_product integer generated by default as identity, name_product varchar(255), primary key (id_product))
alter table es_accessories add constraint FKhonvsci4haxpa46rhuoljxm0h foreign key (id_product) references es_product
