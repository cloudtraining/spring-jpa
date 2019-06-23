delete from phone;
delete from customer_phones;
delete from customer;

insert into customer (first_name, last_name) values ('Jack', 'Bauer');
   insert into phone (type, number) values ('home', '309.123.1234');
   insert into phone (type, number) values ('cell', '309.321.4321');
     insert into customer_phones (customer_cust_id, phones_id) values (1, 1);
     insert into customer_phones (customer_cust_id, phones_id) values (1, 2);

insert into customer (first_name, last_name) values ('Chloe', "O'Brian");
   insert into phone (type, number) values ('home', '409.123.1234');
   insert into phone (type, number) values ('cell', '409.321.4321');
     insert into customer_phones (customer_cust_id, phones_id) values (2, 3);
     insert into customer_phones (customer_cust_id, phones_id) values (2, 4);
     
insert into customer (first_name, last_name) values ('Kim', 'Bauer');
   insert into phone (type, number) values ('home', '509.123.1234');
   insert into phone (type, number) values ('cell', '509.321.4321');
     insert into customer_phones (customer_cust_id, phones_id) values (3, 5);
     insert into customer_phones (customer_cust_id, phones_id) values (3, 6);

insert into customer (first_name, last_name) values ('David', 'Palmer');
   insert into phone (type, number) values ('home', '609.123.1234');
   insert into phone (type, number) values ('cell', '609.321.4321');
     insert into customer_phones (customer_cust_id, phones_id) values (4, 7);
     insert into customer_phones (customer_cust_id, phones_id) values (4, 8);
     
insert into customer (first_name, last_name) values ('Michelle', 'Dessler');
   insert into phone (type, number) values ('home', '709.123.1234');
   insert into phone (type, number) values ('cell', '709.321.4321');
     insert into customer_phones (customer_cust_id, phones_id) values (5, 9);
     insert into customer_phones (customer_cust_id, phones_id) values (5, 10);


select * from customer;
select * from phone;
select * from customer_phones;

/* 		repository.save(Customer.builder().firstName("Jack").lastName("Bauer").build().addPhone("home", "309.123.1234").addPhone("cell","309.321.4321"));
		repository.save(Customer.builder().firstName("Chloe").lastName("O'Brian").build().addPhone("home", "409.123.1234").addPhone("cell","409.321.4321"));
		repository.save(Customer.builder().firstName("Kim").lastName("Bauer").build().addPhone("home", "509.123.1234").addPhone("cell","509.321.4321"));
		repository.save(Customer.builder().firstName("David").lastName("Palmer").build().addPhone("home", "609.123.1234").addPhone("cell","609.321.4321"));
		repository.save(Customer.builder().firstName("Michelle").lastName("Dessler").build().addPhone("home", "709.123.1234").addPhone("cell","709.321.4321"));

*/
