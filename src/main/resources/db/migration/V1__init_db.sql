create table CUSTOMER (
    ID bigserial not null,
    FIRST_NAME varchar(24) not null,
    LAST_NAME varchar(24) not null,
    primary key (ID)
);

create table PRODUCT (
    ID bigserial not null,
    NAME varchar(255) not null,
    PRICE money not null,
    primary key (ID)
);

create table PURCHASE (
    ID bigserial not null,
    CUSTOMER bigint not null,
    PURCHASE date not null,
    primary key (ID),
    foreign key (CUSTOMER) references CUSTOMER (ID)
);

create table PURCHASE_PRODUCTS (
    PRODUCT_ID bigint not null,
    PURCHASE_ID bigint not null,
    primary key(PRODUCT_ID, PURCHASE_ID),
    foreign key (PRODUCT_ID) references PRODUCT (ID),
    foreign key (PURCHASE_ID) references PURCHASE (ID)
);