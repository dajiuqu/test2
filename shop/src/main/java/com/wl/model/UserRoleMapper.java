package com.wl.model;

public interface UserRoleMapper {
	void insert(UserRole item);

	void delete(UserRole item);

	void deleteAllByUserId(String userId);
}
