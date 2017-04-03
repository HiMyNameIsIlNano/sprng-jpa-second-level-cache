package com.daniele.dao;

public interface BaseEntityDao<T> {
	T findById(long id);
}
