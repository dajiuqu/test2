package com.wl.common;

public class PathTest {

	public String getClassesPath()
	{
		return this.getClass().getResource("/").getPath().substring(1);
	}
}
