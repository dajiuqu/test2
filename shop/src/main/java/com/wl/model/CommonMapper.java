package com.wl.model;

import java.util.List;

public interface CommonMapper<T,K> {
	void insert(T item);
	void delete(K id);
	void update(T item);
	T find(K id);
	List<T> findAll();

}
