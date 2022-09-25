CREATE TABLE products(
	productId int,
	productName varchar(30),
	productCategory varchar(20),
	productPrice DOUBLE PRECISION,
	productQuantity int,
	orderQuantity int
);

INSERT INTO products (productId, productName, productCategory, productPrice, productQuantity, orderQuantity)VALUES (1234, 'Desktop', 'Hardware', 25000, 2000, 600);
INSERT INTO products (productId, productName, productCategory, productPrice, productQuantity, orderQuantity)VALUES (2345, 'Mouse', 'Hardware', 280.00, 500,100);
INSERT INTO products (productId, productName, productCategory, productPrice, productQuantity, orderQuantity)VALUES (3456, 'Keyboard', 'Hardware', 1000.50, 3000,2890);
INSERT INTO products (productId, productName, productCategory, productPrice, productQuantity, orderQuantity)VALUES (4567, 'Headphones', 'Hardware', 500, 1000, 550);
INSERT INTO products (productId, productName, productCategory, productPrice, productQuantity, orderQuantity)VALUES (5678, 'Laptop', 'Hardware', 30000, 900, 200);
alter table products alter column productId not null; 
alter table products add primary key (productId);