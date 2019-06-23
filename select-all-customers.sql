select customer_cust_id, customer.first_name, customer.last_name, phone.type, phone.number 
from customer.customer as customer, customer.phone as phone, customer_phones as b
where customer.cust_id = b.customer_cust_id and b.phones_id = phone.id;
