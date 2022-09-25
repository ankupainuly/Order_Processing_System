create table Orders(
   orderId int primary key, 
   date varchar(10),
   customerId int REFERENCES Customer(customerId) ,
   totalValue DOUBLE PRECISION,
   status varchar(20),
   shippingAgaency varchar(20),
   shippingCost DOUBLE PRECISION);
	 
	 insert into Orders values(1,'21-09-22',1,2321.1,'Completed','E-Kart');
	 insert into Orders values(2,'20-09-22',1,10222.1,'Processing','Fedex',110.2);
	 insert into Orders values(3,'22-09-22',2,744.1,'NotCompleted','BlueDart',170.2);
     insert into Orders values(4,'23-09-22',5,2323.1,'Processing','Fedex',110.2);
	 insert into Orders values(5,'24-09-22',4,12233.1,'Pending','BlueDart',170.2);
