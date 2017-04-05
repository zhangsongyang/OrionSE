CREATE TABLE account (
username VARCHAR (11),
balance float
);

CREATE TABLE book_stock (
isbn VARCHAR (11),
stock int
);

CREATE TABLE book (
isbn VARCHAR(11),
book_name varchar(100),
price float
);


INSERT INTO account VALUES ("AA", 30);
INSERT INTO book_stock VALUES ("1001", 50);
INSERT INTO book VALUES ("1001", "java", 10);