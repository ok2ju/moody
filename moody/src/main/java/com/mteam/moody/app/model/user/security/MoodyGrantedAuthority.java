package com.mteam.moody.app.model.user.security;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class MoodyGrantedAuthority implements GrantedAuthority {
	
	private String authority;
	
	public MoodyGrantedAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}
}
