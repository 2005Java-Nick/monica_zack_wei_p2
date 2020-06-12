CREATE TABLE user_account
(
	id serial PRIMARY KEY,
	username TEXT NOT NULL,
	user_password TEXT NOT NULL,
	session_token TEXT,
	phone_number TEXT NOT NULL,
	email TEXT NOT NULL,
	address TEXT NOT NULL,
	state TEXT NOT NULL,
	city TEXT NOT NULL,
	zip TEXT NOT NULL,
	firstname TEXT NOT NULL,
	lastname TEXT NOT NULL
);

CREATE TABLE user_type
(
	user_account_id int,
	account_type_id int,
	PRIMARY KEY (user_account_id, account_type_id)
);

CREATE TABLE account_type
(
	id int PRIMARY KEY,
	acc_type TEXT
);

CREATE TABLE delivery_driver_status
(
	user_account_id int PRIMARY KEY,
	on_shift BOOLEAN
);

CREATE TABLE orders_invoice
(
	id serial PRIMARY KEY,
	shipping_date TEXT,
	purchase_date TEXT,
	sub_total NUMERIC,
	tax NUMERIC,
	discount_code TEXT,
	delivery_charge NUMERIC,
	final_price NUMERIC,
	status TEXT,
	customer_comments TEXT,
	delivery_comments TEXT,
	payment_method TEXT,
	card_number TEXT,
	driver_id int,
	customer_id int
);

CREATE TABLE order_queue
(
	id serial PRIMARY KEY,
	orders_invoice_id int
);

CREATE TABLE item_list
(
	order_id int,
	product_id int,
	quantity int,
	PRIMARY KEY (order_id, product_id)
);

CREATE TABLE products
(
	id serial PRIMARY KEY,
	product_name TEXT,
	description TEXT,
	price NUMERIC,
	inventory_quantity int,
	picture_data bytea
);

CREATE TABLE coupon_specialized
(
	product_id int,
	discount_code_id int,
	PRIMARY KEY (product_id, discount_code_id)
);

CREATE TABLE discount_code
(
	id serial PRIMARY KEY,
	discount_type TEXT,
	amount NUMERIC,
	code text
);



ALTER TABLE user_type
ADD CONSTRAINT fk_user_account_id FOREIGN KEY (user_account_id)
REFERENCES user_account(id) ON DELETE CASCADE;

ALTER TABLE user_type
ADD CONSTRAINT fk_account_type_id FOREIGN KEY (account_type_id)
REFERENCES account_type(id) ON DELETE CASCADE;

ALTER TABLE delivery_driver_status
ADD CONSTRAINT fk_user_account_id FOREIGN KEY (user_account_id)
REFERENCES user_account(id) ON DELETE CASCADE;

ALTER TABLE orders_invoice 
ADD CONSTRAINT fk_driver_id FOREIGN KEY (driver_id)
REFERENCES user_account(id) ON DELETE CASCADE;
	
ALTER TABLE orders_invoice 
ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id)
REFERENCES user_account(id) ON DELETE CASCADE;

ALTER TABLE order_queue
ADD CONSTRAINT fk_orders_invoice_id FOREIGN KEY (orders_invoice_id)
REFERENCES orders_invoice(id) ON DELETE CASCADE;

ALTER TABLE item_list
ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id)
REFERENCES orders_invoice(id) ON DELETE CASCADE;

ALTER TABLE item_list
ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id)
REFERENCES products(id) ON DELETE CASCADE;

ALTER TABLE coupon_specialized
ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id)
REFERENCES products(id) ON DELETE CASCADE;
	
ALTER TABLE coupon_specialized
ADD CONSTRAINT fk_discount_code_id FOREIGN KEY (discount_code_id)
REFERENCES discount_code(id) ON DELETE CASCADE;
	
	
	
insert into user_account (username, user_password, phone_number, email, address, state, city, zip, firstname, lastname)
values ('Wei', 'WeisPassword', '999-999-9999', 'email@email.com', '123 Address Ave', 'NY', 'NYC', '12345', 'Wei', 'Wu' );	

insert into account_type (id, acc_type)
values (1, 'customer');	

insert into user_type (user_account_id, account_type_id)
values (1, 1);	
	
	