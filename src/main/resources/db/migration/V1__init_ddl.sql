CREATE TABLE BOOKDB.USER(
    ID NUMBER(20,0) NOT NULL,
    ROLE VARCHAR(64) NOT NULL,
    USER_NAME VARCHAR(64) NOT NULL,
    PASSWORD VARCHAR(128) NOT NULL,
    ENABLED NUMBER(1,0) NOT NULL,
    PRIMARY KEY (ID)
);