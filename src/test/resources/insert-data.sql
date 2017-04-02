-- User Creation
insert into USER_ACCOUNT (last_update, JOIN_DATE, NAME, SURNNAME, EMAIL, PASSWORD, DESCRIPTION, PROFILE_PHOTO, address_id) values (sysdate, sysdate, 'John', 'Doe', 'john.doe01@email.com', 'johndoe01', 'I am an automated user', 'this is my photo', 1 );
-- Address Creation
insert into ADDRESS (STREET, STREET_NUMBER, zipcode, city, last_update) values ('Foo Road', 1, '20091', 'Foo City 1', sysdate);

-- User Creation
insert into USER_ACCOUNT (last_update, JOIN_DATE, NAME, SURNNAME, EMAIL, PASSWORD, description, PROFILE_PHOTO, address_id) values (sysdate, sysdate, 'John', 'Doe', 'john.doe02@email.com', 'johndoe02', 'I am an automated user', 'this is my photo', 2 );
-- Address Creation
insert into ADDRESS (STREET, STREET_NUMBER, zipcode, city, last_update) values ('Foo Road', 2, '20092', 'Foo City 2', sysdate);

-- User Creation
insert into USER_ACCOUNT (last_update, JOIN_DATE, NAME, SURNNAME, EMAIL, PASSWORD, description, PROFILE_PHOTO, address_id) values (sysdate, sysdate, 'John', 'Doe', 'john.doe03@email.com', 'johndoe03', 'I am an automated user', 'this is my photo', 3 );
-- Address Creation
insert into ADDRESS (STREET, STREET_NUMBER, zipcode, city, last_update) values ('Foo Road', 3, '20093', 'Foo City 3', sysdate);

-- User Creation
insert into USER_ACCOUNT (last_update, JOIN_DATE, NAME, SURNNAME, EMAIL, PASSWORD, description, PROFILE_PHOTO, address_id) values (sysdate, sysdate, 'John', 'Doe', 'john.doe04@email.com', 'johndoe04', 'I am an automated user', 'this is my photo', 4 );
-- Address Creation
insert into ADDRESS (STREET, STREET_NUMBER, zipcode, city, last_update) values ('Foo Road', 4, '20094', 'Foo City 4', sysdate);

-- User Creation
insert into USER_ACCOUNT (last_update, JOIN_DATE, NAME, SURNNAME, EMAIL, PASSWORD, description, PROFILE_PHOTO, address_id) values (sysdate, sysdate, 'John', 'Doe', 'john.doe05@email.com', 'johndoe05', 'I am an automated user', 'this is my photo', 5 );
-- Address Creation
insert into ADDRESS (STREET, STREET_NUMBER, zipcode, city, last_update) values ('Foo Road', 5, '20095', 'Foo City 5', sysdate);