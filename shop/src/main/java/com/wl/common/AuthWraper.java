package com.wl.common;

import java.util.Set;

public class AuthWraper {

	private Set<String> allowUrl;
	private Set<String> forbidUrl;

	public Set<String> getAllowUrl() {
		return allowUrl;
	}

	public void setAllowUrl(Set<String> allowUrl) {
		this.allowUrl = allowUrl;
	}

	public Set<String> getForbidUrl() {
		return forbidUrl;
	}

	public void setForbidUrl(Set<String> forbidUrl) {
		this.forbidUrl = forbidUrl;
	}

	@Override
	public String toString() {
		return "AuthWraper [allowUrl=" + allowUrl + ", forbidUrl=" + forbidUrl + "]";
	}

}
