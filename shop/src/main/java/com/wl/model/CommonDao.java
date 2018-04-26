package com.wl.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wl.common.SqlHelper;

public class CommonDao<T, K> implements CommonMapper<T, K> {

	private Class<?> myClass;

	public CommonDao(Class<?> myClass) {
		super();
		this.myClass = myClass;
	}

	public void insert(T item) {
		// TODO Auto-generated method stub

		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			CommonMapper<T, K> mapper = (CommonMapper<T, K>) session.getMapper(this.myClass);
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

	public void delete(K id) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			CommonMapper<T, K> mapper = (CommonMapper<T, K>) session.getMapper(this.myClass);
			mapper.delete(id);

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

	public void update(T item) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			CommonMapper<T, K> mapper = (CommonMapper<T, K>) session.getMapper(this.myClass);
			mapper.update(item);

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

	public T find(K id) {
		// TODO Auto-generated method stub
		T v = null;
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			CommonMapper<T, K> mapper = (CommonMapper<T, K>) session.getMapper(this.myClass);
			v = mapper.find(id);

			// session.commit();
		} catch (Exception ex) {
			// session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}
		return v;
	}

	public List<T> findAll() {
		List<T> items = null;
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			CommonMapper<T, K> mapper = (CommonMapper<T, K>) session.getMapper(this.myClass);
			items = mapper.findAll();

			// session.commit();
		} catch (Exception ex) {
			// session.rollback();
			System.out.println(ex);
		} finally {

			if (session != null) {

				session.close();
			}
		}
		return items;
	}

}
