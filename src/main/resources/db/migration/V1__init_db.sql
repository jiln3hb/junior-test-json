create table customer (
    id bigint not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    primary key (id));

create table product (
    id bigint not null,
    product_name varchar(255) not null,
    price money not null,
    primary key (id));

create table purchase (
    id bigint not null,
    purchase_date date not null,
    customer_id bigint not null,
    primary key (id));

create table purchase_products (
    purchase_id bigint not null not null,
    product_id bigint not null not null,
    primary key (purchase_id, product_id));

create sequence customer_id_seq start with 1 increment by 1;
create sequence product_id_seq start with 1 increment by 1;
create sequence purchase_id_seq start with 1 increment by 1;

alter table if exists purchase add constraint customer_purchases foreign key (customer_id) references customer;
alter table if exists purchase_products add constraint products_purchases foreign key (product_id) references product;
alter table if exists purchase_products add constraint purchases_products foreign key (purchase_id) references purchase;