package com.daniele.hibernate.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDetails.class)
public abstract class UserDetails_ extends com.daniele.hibernate.model.BaseEntity_ {

	public static volatile SingularAttribute<UserDetails, Date> joinDate;
	public static volatile SingularAttribute<UserDetails, Address> address;
	public static volatile SingularAttribute<UserDetails, String> name;
	public static volatile SingularAttribute<UserDetails, String> description;

}

