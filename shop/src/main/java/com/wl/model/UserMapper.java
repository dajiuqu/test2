package com.wl.model;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends CommonMapper<User, String> {

	User queryUserWithRoleAndResourceByUserId(String userId);
	
	User queryUserWithRoleAndResource(@Param("name") String name,@Param("password") String password);
}
