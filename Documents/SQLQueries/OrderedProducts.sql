CREATE TABLE ORDEREDPRODUCTS(
PRODUCTID int REFERENCES products(productid),
ORDERID int REFERENCES orders(orderid),
QUANTITY int
);

INSERT into ORDEREDPRODUCTS(PRODUCTID, ORDERID, QUANTITY) VALUES(1234,3,500);
INSERT into ORDEREDPRODUCTS(PRODUCTID, ORDERID, QUANTITY) VALUES(3456,1,50);
INSERT into ORDEREDPRODUCTS(PRODUCTID, ORDERID, QUANTITY) VALUES(4567,4,254);