package com.wl.model;

import org.apache.ibatis.session.SqlSession;

import com.wl.common.SqlHelper;

public class SqlDao implements InitSqlData {

	public void DoSql(SqlWraper sql) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = SqlHelper.getSqlSession();
			InitSqlData mapper = session.getMapper(InitSqlData.class);
			mapper.DoSql(sql);
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
