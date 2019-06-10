drop table customer if exists
drop table customer_phones if exists
drop table phone if exists
drop sequence if exists hibernate_sequence    
    
    
    create sequence hibernate_sequence start with 1 increment by 1

    create table customer (
       cust_id bigint not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (cust_id)
    )

    create table customer_phones (
       customer_cust_id bigint not null,
        phones_id bigint not null
    )

    create table phone (
       id bigint not null,
        number varchar(255),
        type varchar(255),
        primary key (id)
    )

    alter table customer_phones 
       add constraint UK_3r6duym1m3fdvco19easo9kl7 unique (phones_id)

    alter table customer_phones 
       add constraint FK11y1wyv2l4m9unl5i46oayspb 
       foreign key (phones_id) 
       references phone

    alter table customer_phones 
       add constraint FKnjauy8jlhukyoeg5uih6gu97i 
       foreign key (customer_cust_id) 
       references customer
