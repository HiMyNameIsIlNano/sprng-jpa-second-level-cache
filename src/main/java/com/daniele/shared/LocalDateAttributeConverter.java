package com.daniele.shared;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Note: 
 * 
 * Java 8 was released after JPA 2.1, and the persistence standard does not support the new APIs. 
 * One can, use LocalDate or other classes of the Date and Time API as entity attributes, but they cannot 
 * be annotated with @Temporal as Hibernate will store them as blobs in the database.
 *
 * This solution is not Hibernate specific and it applies to all the LocalDate fields automatically.
 **/
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
	@Override
    // It converts from the type of the entity attribute (LocalDate) to the database column type (Date)
    public Date convertToDatabaseColumn(LocalDate locDate) {
    	return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    // It converts from the type of the database column type (Date) to the entity attribute (LocalDate) 
    public LocalDate convertToEntityAttribute(Date sqlDate) {
    	return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}