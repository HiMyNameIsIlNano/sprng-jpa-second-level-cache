package com.daniele.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {
	@Transient
	private static final long serialVersionUID = -8149048401405402179L;

	@Column(name = "STREET_NAME")
	private String street;

	private String zipcode;

	private String city;

	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonManagedReference
	private UserDetails user;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public UserDetails getUserDetails() {
		return user;
	}

	public void setUserDetails(UserDetails user) {
		this.user = user;
	}
	
	public String toString() {
		return "Street: " + street + " zipcode: " + zipcode + " city: " + city;
	}
}