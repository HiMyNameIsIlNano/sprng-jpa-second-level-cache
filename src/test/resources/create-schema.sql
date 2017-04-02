create table USER_ACCOUNT (
	id  bigserial not null, 
	last_update timestamp, 
	JOIN_DATE date, 
	NAME varchar(255),
	SURNNAME varchar(255),
	EMAIL varchar(255),
	PASSWORD varchar(255),
	description text, 
	PROFILE_PHOTO varchar(255),
	address_id int8, 
	primary key (id)
);

create table ADDRESS (
	id  bigserial not null, 
	STREET varchar(255),
	STREET_NUMBER number(10),
	zipcode varchar(255), 
	city varchar(255), 
	last_update timestamp, 
	primary key (id)
);
