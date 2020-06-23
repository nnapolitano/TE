
DROP table owner;

BEGIN TRANSACTION;

CREATE TABLE owner
(
ownerID serial,
name varchar(64) not null,
street varchar(64) not null,
address varchar(100) not null,
phone varchar(11) null

primary key(ownerID),
);





CREATE TABLE pet
(
petID serial,
name varchar(64) not null,
age varchar(2) not null,
type varchar (12) not null,
ownerID int not null,

primary key(petID)

);


CREATE TABLE visit
(purchaseID serial, 
date varchar(11) not null,
procedureID int not null,

primary key(purchaseID)
);

CREATE TABLE procedure
(
procedureID int,
procedure_name varchar (200) not null,
price double null;

primary key (procedureID)
)


ALTER TABLE pet
ADD FOREIGN KEY (ownerID) references owner (ownerID),

ALTER TABLE visit
ADD foreign key (procedureID) references procedure(pprocedureID),


)
COMMIT;




