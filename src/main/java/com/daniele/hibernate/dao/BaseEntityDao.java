package com.daniele.hibernate.dao;

public interface BaseEntityDao<T> {
	T findById(long id);
}
