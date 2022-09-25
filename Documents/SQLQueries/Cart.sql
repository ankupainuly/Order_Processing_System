CREATE TABLE Cart (
    orderId int,
	productId int,
	quantity int,
	name VARCHAR(30),
	category VARCHAR(20)
);

INSERT INTO Cart (orderId, productId, quantity, name, category)VALUES (4, 1234, 100, 'Desktop', 'Hardware');
INSERT INTO Cart (orderId, productId, quantity, name, category)VALUES (2, 2345, 200, 'Mouse', 'Hardware');
INSERT INTO Cart (orderId, productId, quantity, name, category)VALUES (1, 3456, 150, 'Keyboard', 'Hardware');
INSERT INTO Cart (orderId, productId, quantity, name, category)VALUES (6, 4567, 90, 'Headphones', 'Hardware');
INSERT INTO Cart (orderId, productId, quantity, name, category)VALUES (5, 5678, 300, 'Laptop', 'Hardware');
