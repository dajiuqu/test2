package com.wl.model;

import org.apache.ibatis.session.SqlSession;

import com.wl.common.SqlHelper;

public class UserRoleDao implements UserRoleMapper {

	public void insert(UserRole item) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			UserRoleMapper mapper = session.getMapper(UserRoleMapper.class);
			mapper.insert(item);

			session.commit();
		} catch (Exception ex) {
			session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}
	}

	public void delete(UserRole item) {
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			UserRoleMapper mapper = session.getMapper(UserRoleMapper.class);
			mapper.delete(item);

			session.commit();
		} catch (Exception ex) {
			session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}

	}

	public void deleteAllByUserId(String userId) {
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			UserRoleMapper mapper = session.getMapper(UserRoleMapper.class);
			mapper.deleteAllByUserId(userId);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}

	}

}
