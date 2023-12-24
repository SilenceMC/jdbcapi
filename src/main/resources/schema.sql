create table if not exists CUSTOMERS
(
    id           serial PRIMARY KEY,
    name         varchar,
    surname      varchar,
    age          integer,
    phone_number varchar
);

create table if not exists ORDERS
(
    id           serial PRIMARY KEY,
    date         date,
    customer_id  integer REFERENCES CUSTOMERS,
    product_name varchar,
    amount       integer
);