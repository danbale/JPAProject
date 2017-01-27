CREATE TABLE BOOKS (
BOOK_ID INTEGER NOT NULL AUTO_INCREMENT, 
BOOK_NAME VARCHAR(30), 
BOOK_GENRE VARCHAR(30),
BOOK_AUTHOR VARCHAR(30),
BOOK_EDITOR VARCHAR(30),
BOOK_LNG VARCHAR(30),
BOOK_STATUS VARCHAR(20),
BOOK_YEAR INTEGER
);

CREATE TABLE USERS(
USER_ID INTEGER NOT NULL AUTO_INCREMENT,
USER_USERNAME VARCHAR(30),
USER_PASSWORD VARCHAR(30),
USER_NAME VARCHAR(30),
USER_ORDERS INTEGER,
CREATED_DATE DATE,
MODIFIED_DATE DATE
);

CREATE TABLE ORDERS(
ORDER_ID INTEGER NOT NULL,
CREATED_DATE DATE,
MODIFIED_DATE DATE,
PRIMARY KEY (ORDER_ID),
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID) ON UPDATE CASCADE
);


CREATE TABLE PICKBOOK(
PBOOK_ID INTEGER NOT NULL,
CREATED_DATE DATE,
MODIFIED_DATE DATE,
PRIMARY KEY (PBOOK_ID),
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID) ON UPDATE CASCADE,
FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID)ON UPDATE CASCADE
);



