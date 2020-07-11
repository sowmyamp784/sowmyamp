create table register(
firstname varchar(50),
lastname varchar(50),
email varchar(50) not null,
telephone varchar(50),
addr1 varchar(50),
addr2 varchar(50),
city varchar(50),
postcode varchar(50),
country varchar(50),
region varchar(50),
password varchar(50),
confirmpassword varchar(50));


insert into register values("Sowmya", "M P", "sowmya10002@gmail.com", "9449590100", "123", "19th Main", "Bangalore", "560045", "India", "Karnataka", "Test1234", "Test1234"); 
insert into register values("Bhavana", "S", "bhavana10002@gmail.com", "9986590100", "784", "13th Main", "Subash Nagar", "570001", "India", "Maharashtra", "Test1234", "Test1234"); 

UPDATE register SET email = 'sowmya1005@gmail.com' WHERE firstname = 'Sowmya';
UPDATE register SET email = 'bhavana1005@gmail.com' WHERE firstname = 'Bhavana';

DELETE FROM register WHERE firstname='Sowmya';
DELETE FROM register WHERE firstname='Bhavana';