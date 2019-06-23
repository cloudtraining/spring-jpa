create database customer;
use customer;
connect;


drop table customer_phones;
drop table phone;     
drop table customer;
    
    create table customer (
       cust_id bigint not null auto_increment,
        first_name varchar(255),
        last_name varchar(255),
        primary key (cust_id)
    );

    create table customer_phones (
       customer_cust_id bigint not null,
        phones_id bigint not null
    );

    create table phone (
       id bigint not null  auto_increment,
        number varchar(255),
        type varchar(255),
        primary key (id)
    );

    alter table customer_phones add constraint UK_3r6duym1m3fdvco19easo9kl7 unique (phones_id);

    alter table customer_phones 
       add constraint FK11y1wyv2l4m9unl5i46oayspb 
       foreign key (phones_id) 
       references phone(id);

    alter table customer_phones 
       add constraint FKnjauy8jlhukyoeg5uih6gu97i 
       foreign key (customer_cust_id) 
       references customer(cust_id);
       
show columns from customer;
show columns from customer_phones;
show columns from phone;

create user 'brad'@'localhost' identified by 'password';
create user 'brad' identified by 'password';

grant all on *.* to 'brad'@'localhost' with grant option;
grant all on *.* to 'brad' with grant option;


select user,host from mysql.user;

