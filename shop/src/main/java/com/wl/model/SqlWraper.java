package com.wl.model;

public class SqlWraper {
	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		return "SqlWraper [sql=" + sql + "]";
	}

	public SqlWraper(String sql) {
		super();
		this.sql = sql;
	}

	public SqlWraper() {
		super();
	}

}
