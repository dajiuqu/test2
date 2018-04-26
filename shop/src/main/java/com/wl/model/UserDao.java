package com.wl.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wl.common.SqlHelper;

public class UserDao implements UserMapper {

	public void insert(User item) {
		// TODO Auto-generated method stub

		CommonDao<User, String> dao = new CommonDao<User, String>(UserMapper.class);
		dao.insert(item);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		CommonDao<User, String> dao = new CommonDao<User, String>(UserMapper.class);
		dao.delete(id);
	}

	public void update(User item) {
		// TODO Auto-generated method stub
		CommonDao<User, String> dao = new CommonDao<User, String>(UserMapper.class);
		dao.update(item);
	}

	public User find(String id) {
		// TODO Auto-generated method stub
		CommonDao<User, String> dao = new CommonDao<User, String>(UserMapper.class);
		return dao.find(id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		CommonDao<User, String> dao = new CommonDao<User, String>(UserMapper.class);
		return dao.findAll();
	}

	public User queryUserWithRoleAndResourceByUserId(String userId) {
		// TODO Auto-generated method stub
		User item = null;
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			item = mapper.queryUserWithRoleAndResourceByUserId(userId);

			// session.commit();
		} catch (Exception ex) {
			session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}
		return item;
	}

	public User queryUserWithRoleAndResource(String name, String password) {
		// TODO Auto-generated method stub
		User item = null;
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			item = mapper.queryUserWithRoleAndResource(name, password);

			// session.commit();
		} catch (Exception ex) {
			session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}
		return item;
	}

}
