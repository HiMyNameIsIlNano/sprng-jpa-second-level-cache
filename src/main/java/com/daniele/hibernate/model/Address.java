package com.daniele.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {
	@Column(name = "STREET_NAME")
	private String street;

	@Column(name = "STREET_NUMBER")
	private short streetNumber;

	private String zipcode;

	private String city;

/*	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private User user;*/

	protected Address() {
		// for JPA
	}
	
	private Address(AddressBuilder addressBuilder) {
		this.street = addressBuilder.street;
		this.zipcode = addressBuilder.zipcode;
		this.city = addressBuilder.city;
		this.streetNumber = addressBuilder.streetNumber;
		//this.user = addressBuilder.user;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	/*public User getUserDetails() {
		return user;
	}*/

	public String toString() {
		return "Street: " + street + " zipcode: " + zipcode + " city: " + city;
	}

	public static class AddressBuilder {
		private String street;
		private String zipcode;
		private String city;
		private short streetNumber;
		//private User user;

		public AddressBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressBuilder withZipCode(String zipCode) {
			this.zipcode = zipCode;
			return this;
		}

		public AddressBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder withStreetNumber(short streetNumber) {
			this.streetNumber = streetNumber;
			return this;
		}

		/*public AddressBuilder withUserDetails(User userDetails) {
			this.user = userDetails;
			return this;
		}*/

		public Address build() {
			return new Address(this);
		}
	}
}