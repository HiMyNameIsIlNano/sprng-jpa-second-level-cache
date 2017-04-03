package com.daniele.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.daniele.rest.serializer.LocalDateDeserializer;
import com.daniele.rest.serializer.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@MappedSuperclass
// This enables Jackson annotations at field level only
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public abstract class BaseEntity implements Serializable {
    @Transient
	private static final long serialVersionUID = 684452728857089137L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;

    @Column(name = "last_update")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate lastUpdate = LocalDate.now();

    public Long getId() {
        return this.id;
    }
 
    @SuppressWarnings("unused")
    private void setId(final Long id) {
        this.id = id;
    }
  
    public LocalDate getLastUpdate() {
        return this.lastUpdate;
    }
 
    protected void copy(final BaseEntity source) {
        this.id = source.id;
        this.lastUpdate = source.lastUpdate;
    }
 
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof BaseEntity))
        {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        if (this.id != null && other.id != null)
        {
            if (this.id != other.id)
            {
                return false;
            }
        }
        return true;
    }
 
    protected static boolean getBooleanValue(final Boolean value) {
        return Boolean.valueOf(String.valueOf(value));
    }
}