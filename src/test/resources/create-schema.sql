create table USER_DETAILS (id int8 not null, description text, joinDate date, USER_NAME varchar(255), primary key (id));
create table ADDRESS (id int8 not null, city varchar(255), STREET_NAME varchar(255), zipcode varchar(255), primary key (id));
