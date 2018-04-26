package com.wl.model;

public interface RoleResourceMapper {
	void insert(RoleResource item);

	void delete(RoleResource item);

	void deleteAllByRoleId(String roleId);
}
