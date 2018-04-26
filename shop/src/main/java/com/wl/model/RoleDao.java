package com.wl.model;

import java.util.List;

public class RoleDao implements RoleMapper {

	public void insert(Role item) {
		// TODO Auto-generated method stub
		CommonDao<Role, String> dao = new CommonDao<Role, String>(RoleMapper.class);
		dao.insert(item);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		CommonDao<Role, String> dao = new CommonDao<Role, String>(RoleMapper.class);
		dao.delete(id);
	}

	public void update(Role item) {
		// TODO Auto-generated method stub
		CommonDao<Role, String> dao = new CommonDao<Role, String>(RoleMapper.class);
		dao.update(item);
	}

	public Role find(String id) {
		// TODO Auto-generated method stub
		CommonDao<Role, String> dao = new CommonDao<Role, String>(RoleMapper.class);
		return dao.find(id);
	}

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		CommonDao<Role, String> dao = new CommonDao<Role, String>(RoleMapper.class);
		return dao.findAll();
	}

}
