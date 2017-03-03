package com.daniele.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Transient
	private static final long serialVersionUID = 684452728857089137L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    public Long getId()
    {
        return this.id;
    }
 
    @SuppressWarnings("unused")
    private void setId(final Long id)
    {
        this.id = id;
    }
  
    public Date getLastUpdate()
    {
        return this.lastUpdate;
    }
 
    public void setLastUpdate(final Date lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }
    
    protected void copy(final BaseEntity source)
    {
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
 
    protected static boolean getBooleanValue(final Boolean value)
    {
        return Boolean.valueOf(String.valueOf(value));
    }
}