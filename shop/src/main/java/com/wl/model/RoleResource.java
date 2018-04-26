package com.wl.model;

public class RoleResource {

	private String roleId;
	private String resourceId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return "Role_Resource [roleId=" + roleId + ", resourceId=" + resourceId + "]";
	}

}
