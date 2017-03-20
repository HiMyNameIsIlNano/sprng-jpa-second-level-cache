create table ADDRESS (id  bigserial not null, last_update timestamp, city varchar(255), STREET_NAME varchar(255), zipcode varchar(255), primary key (id));
create table USER_DETAILS (id  bigserial not null, last_update timestamp, description text, joinDate date, USER_NAME varchar(255), address_id int8, primary key (id));
alter table USER_DETAILS add constraint FK5orbmvijniejeuct1xerav196 foreign key (address_id) references ADDRESS;
