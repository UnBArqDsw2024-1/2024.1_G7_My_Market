package com.mymarket.mvp.accounts;

public enum Role {
	ROLE_ADMIN("admin"), ROLE_USER("user");

	private final String value;

	Role(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}