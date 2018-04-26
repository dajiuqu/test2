package com.wl.model;

import java.util.List;

public class ResourceDao implements ResourceMapper {

	public void insert(Resource item) {
		// TODO Auto-generated method stub
		CommonDao<Resource, String> dao = new CommonDao<Resource, String>(ResourceMapper.class);
		dao.insert(item);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		CommonDao<Resource, String> dao = new CommonDao<Resource, String>(ResourceMapper.class);
		dao.delete(id);
	}

	public void update(Resource item) {
		// TODO Auto-generated method stub
		CommonDao<Resource, String> dao = new CommonDao<Resource, String>(ResourceMapper.class);
		dao.update(item);
	}

	public Resource find(String id) {
		// TODO Auto-generated method stub
		CommonDao<Resource, String> dao = new CommonDao<Resource, String>(ResourceMapper.class);
		return dao.find(id);
	}

	public List<Resource> findAll() {
		// TODO Auto-generated method stub
		CommonDao<Resource, String> dao = new CommonDao<Resource, String>(ResourceMapper.class);
		return dao.findAll();
	}

}
