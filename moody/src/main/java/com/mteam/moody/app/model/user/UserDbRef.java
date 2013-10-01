package com.mteam.moody.app.model.user;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mteam.moody.app.model.follow.Follower;
import com.mteam.moody.app.model.follow.Following;
 
@Document(collection = "usersDbRef")
public class UserDbRef implements UserDetails, Serializable {
    
	private static final long serialVersionUID = -5352190150622244640L;

	@Id
    private String id;
	
	@Indexed(unique=true)
	private String username;
	
	private String password;
	
	@Indexed(unique = true)
	private String email;
	
	@DBRef
	private Follower follower;
	
	@DBRef
	private Following following;
	
	private boolean accountNonExpired;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	private boolean enabled;
	
	private List<GrantedAuthority> authorities;
	
	public UserDbRef() {
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
	}
	
	public UserDbRef(String username, String password, String email, List<GrantedAuthority> authorities) {
		this();
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Follower getFollower() {
		return follower;
	}

	public void setFollower(Follower follower) {
		this.follower = follower;
	}

	public Following getFollowing() {
		return following;
	}

	public void setFollowing(Following following) {
		this.following = following;
	}
}
