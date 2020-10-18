CREATE TABLE users (
  id int unsigned NOT NULL ,
  email varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  merchant_type varchar(45) NOT NULL,
  merchant_name varchar(45) NOT NULL,
  owner_name varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  phone varchar(45) NOT NULL,
  UNIQUE KEY username_UNIQUE (email)
) 

CREATE TABLE discounts (
  id int unsigned NOT NULL ,
  percentage int NOT NULL,
  end_date date DEFAULT NULL,
  start_date date DEFAULT NULL
) 

CREATE TABLE payment_options (
  id int NOT NULL,
  payment_type varchar(255) NOT NULL,
  payment_duration int NOT NULL,
  interest_rate int NOT NULL,
) 

CREATE TABLE product (
  product_id int unsigned NOT NULL,
  name varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  category varchar(255) DEFAULT NULL,
  price varchar(255) DEFAULT NULL,
  inventory int DEFAULT NULL,
  listed_by int unsigned DEFAULT NULL
  id_discount int unsigned NOT NULLid_discount)
  id_payment int NOT NULLid_payment),);



ALTER TABLE users MODIFY id int unsigned NOT NULL AUTO_INCREMENT;
ALTER TABLE users ADD PRIMARY KEY (id);
ALTER TABLE users ADD UNIQUE KEY users_id_UNIQUE (id);
ALTER TABLE users MODIFY UNIQUE KEY username_UNIQUE (email)
) 

CREATE TABLE discounts (
  id int unsigned NOT NULL AUTO_INCREMENT;
ALTER TABLE users ADD PRIMARY KEY (id);
ALTER TABLE users ADD UNIQUE KEY users_id_UNIQUE (id)
) 

CREATE TABLE payment_options (
  id int NOT NULL;
ALTER TABLE users ADD PRIMARY KEY (id)
) 

CREATE TABLE product (
  product_id int unsigned NOT NULL;
ALTER TABLE users ADD PRIMARY KEY (product_id);
ALTER TABLE users ADD FOREIGN KEY (listed_by) REFERENCES users (id)
) 

CREATE TABLE product_discounts (
  id_product int unsigned NOT NULL;
ALTER TABLE users ADD PRIMARY KEY (id_product;
ALTER TABLE users ADD FOREIGN KEY (id_discount) REFERENCES discounts (id);
ALTER TABLE users ADD FOREIGN KEY (id_product) REFERENCES product (product_id)
) 
CREATE TABLE product_payments (
  id_product int unsigned NOT NULL;
ALTER TABLE users ADD PRIMARY KEY (id_product;
ALTER TABLE users ADD FOREIGN KEY (id_payment) REFERENCES payment_options (id);
ALTER TABLE users ADD FOREIGN KEY (id_product) REFERENCES product (product_id);