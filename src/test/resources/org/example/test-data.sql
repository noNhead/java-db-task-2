INSERT INTO INTERNET_SHOP.ADDRESS (COUNTRY, CITY, STREET, HOUSE, APARTMENT) VALUES (country, city, street, house, apartment);
INSERT INTO INTERNET_SHOP.BOUQUET (NAME, DESCRIPTION) VALUES (name, description);
INSERT INTO INTERNET_SHOP.COURIER (NAME, PHONE) VALUES (name, phone);
INSERT INTO INTERNET_SHOP.FLOWER (NAME, NUMBER) VALUES (name, 10);
INSERT INTO INTERNET_SHOP.SUPPLIER (NAME, PHONE, EMAIL, ADDRESS_ID) VALUES (name, phone, email, 1);
INSERT INTO INTERNET_SHOP.FLOWER_HAS_BOUQUET (FLOWER_ID, BOUQUET_ID, NUMBER) VALUES (1, 1, 10);
INSERT INTO INTERNET_SHOP.FLOWER_HAS_SUPPLIER (FLOWER_ID, SUPPLIER_ID, NUMBER, DELIVERY_DATE) VALUES (1, 1, 10, CURRENT_TIMESTAMP);
INSERT INTO INTERNET_SHOP.PROMOTIONAL_CODE (CODE, DESCRIPTION, ACTIVE) VALUES (code, description, true);
INSERT INTO INTERNET_SHOP.USERS (USERNAME, EMAIL, CREATE_TIME, ACTIVE, ROLE, PHONE) VALUES (username, email, CURRENT_TIMESTAMP, true, role, phone);
INSERT INTO INTERNET_SHOP.ORDER (USERNAME_ID, DATE, COURIER_ID, PROMOTIONAL_CODES, BOUQUET_ID, ADDRESS_ID) VALUES (1, CURRENT_TIMESTAMP, 1, 1, 1, 1);