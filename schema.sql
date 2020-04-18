CREATE SCHEMA online_market ;
use online_market;
CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
surname VARCHAR(45) NOT NULL,
role VARCHAR(45) NOT NULL DEFAULT 'CUSTOMER',
PRIMARY KEY (id)
);
CREATE TABLE contacts (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
telephone VARCHAR(45) NOT NULL,
adress VARCHAR(45) NOT NULL,
other_address VARCHAR(45),
email VARCHAR(45) NOT NULL,
PRIMARY KEY (id) ,
UNIQUE INDEX telephone_UNIQUE (telephone ASC) VISIBLE,
UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE,
UNIQUE INDEX user_id_UNIQUE (user_id ASC) VISIBLE,
CONSTRAINT contact_user
FOREIGN KEY (user_id)
REFERENCES online_market.users(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);
CREATE TABLE personal_info (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
login VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
PRIMARY KEY (id),
UNIQUE INDEX login_UNIQUE (login ASC) VISIBLE,
UNIQUE INDEX user_id_UNIQUE (user_id ASC) VISIBLE,
CONSTRAINT personal_user
FOREIGN KEY (user_id)
REFERENCES online_market.users(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);
CREATE TABLE categories(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
PRIMARY KEY (id),
UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE);
CREATE TABLE subcategories (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
category_id INT NOT NULL,
PRIMARY KEY (id),
UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE,
INDEX category_id_categories_idx (category_id ASC) VISIBLE,
CONSTRAINT category_id_categories
FOREIGN KEY (category_id)
REFERENCES online_market.categories (id)
ON DELETE CASCADE
ON UPDATE CASCADE);
CREATE TABLE products (
id INT NOT NULL AUTO_INCREMENT,
brand VARCHAR(50) NOT NULL,
name VARCHAR(45) NOT NULL,
price DOUBLE NOT NULL,
subcategory_id INT NOT NULL,
seller_id INT NOT NULL,
description VARCHAR(500),
PRIMARY KEY (id),
INDEX sub_cat_id_sub_cats_idx (subcategory_id ASC) VISIBLE,
INDEX seller_id_user_id_idx (seller_id ASC) VISIBLE,
CONSTRAINT sub_cat_id_sub_cats
FOREIGN KEY (subcategory_id)
REFERENCES online_market.subcategories (id)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT seller_id_user_id
FOREIGN KEY (seller_id)
REFERENCES online_market.users (id)
ON DELETE CASCADE
ON UPDATE CASCADE);
CREATE TABLE online_market.orders (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
product_id INT NOT NULL,
time_order DATETIME(6) NOT NULL,
PRIMARY KEY (id),
INDEX user_id_users_idx (user_id ASC) VISIBLE,
CONSTRAINT user_id_users
FOREIGN KEY (user_id)
REFERENCES online_market.users (id)
ON DELETE CASCADE
ON UPDATE CASCADE);
CREATE TABLE online_market.orders_basket (
id INT NOT NULL AUTO_INCREMENT,
product_id INT NOT NULL,
order_id INT NOT NULL,
PRIMARY KEY (id),
INDEX product_id_prds_id_idx (product_id ASC) VISIBLE,
INDEX order_id_orders_id_idx (order_id ASC) VISIBLE,
CONSTRAINT product_id_prds_id
FOREIGN KEY (product_id)
REFERENCES online_market.products (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT order_id_orders_id
FOREIGN KEY (order_id)
REFERENCES online_market.orders (id)
ON DELETE CASCADE
ON UPDATE CASCADE);