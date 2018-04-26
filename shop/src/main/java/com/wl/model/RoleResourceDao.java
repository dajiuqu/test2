package com.wl.model;

import org.apache.ibatis.session.SqlSession;

import com.wl.common.SqlHelper;

public class RoleResourceDao implements RoleResourceMapper {

	public void insert(RoleResource item) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			RoleResourceMapper mapper = session.getMapper(RoleResourceMapper.class);
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

	public void delete(RoleResource item) {
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			RoleResourceMapper mapper = session.getMapper(RoleResourceMapper.class);
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

	public void deleteAllByRoleId(String roleId) {
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			RoleResourceMapper mapper = session.getMapper(RoleResourceMapper.class);
			mapper.deleteAllByRoleId(roleId);

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
