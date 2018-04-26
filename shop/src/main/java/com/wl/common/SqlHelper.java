package com.wl.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlHelper {

	private static SqlSessionFactory factory;
	static {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("sqlconfig/mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(factory);
	}

	public static SqlSession getSqlSession() {

		return factory.openSession();

	}
}
