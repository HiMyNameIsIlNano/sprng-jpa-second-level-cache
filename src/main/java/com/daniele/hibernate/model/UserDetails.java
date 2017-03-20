package com.daniele.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails extends BaseEntity {
	@Transient
	private static final long serialVersionUID = 2677825940460986009L;

	@Column(name="USER_NAME")	
	String name;
	
	@Temporal(TemporalType.DATE)
	Date joinDate;
	
	@Lob
	String description;
	
	@Transient
	String uselessField;
	
	@OneToOne
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	@JsonBackReference
	private Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUselessField() {
		return uselessField;
	}

	public void setUselessField(String uselessField) {
		this.uselessField = uselessField;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Name: " + name + " Join Date: " + joinDate + " Description: " + description + " " + address.toString();
	}
}
