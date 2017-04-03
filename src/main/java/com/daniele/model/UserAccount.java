package com.daniele.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.daniele.rest.serializer.LocalDateDeserializer;
import com.daniele.rest.serializer.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount extends BaseEntity {
	@Column(name = "NAME")
	String name;

	@Column(name = "SURNAME")
	String surname;

	String email;

	String password;

	// Automatically converted to Date by the LocalDateAttributeConverter
	@Column(name = "JOIN_DATE")
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	LocalDate joinDate;

	@Lob
	String description;

	@Lob
	@Column(name = "PHOTO")
	@Basic(fetch = FetchType.LAZY)
	String profilePhoto;

	@OneToOne
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Address address;

	// @OneToOne
	// @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	// private AccountSetting accountSetting;

	protected UserAccount() {
		// for JPA
	}
	
	private UserAccount(UserBuilder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.email = builder.email;
		this.password = builder.password;
		this.joinDate = builder.joinDate;
		this.description = builder.description;
		this.profilePhoto = builder.profilePhoto;
		this.address = builder.address;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Name: " + name + " Join Date: " + joinDate + " Description: " + description + " " + address.toString();
	}

	public static class UserBuilder {
		private String name;
		private String surname;
		private String email;
		private String password;
		private LocalDate joinDate;
		private String description;
		private String profilePhoto;
		private Address address;

		public UserBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder withSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public UserBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder withJoinDate(LocalDate joinDate) {
			this.joinDate = joinDate;
			return this;
		}

		public UserBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public UserBuilder withAddress(Address address) {
			this.address = address;
			return this;
		}

		public UserAccount build() {
			return new UserAccount(this);
		}
	}
}
