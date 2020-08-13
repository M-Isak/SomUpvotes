package com.somupvotes.websecurity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.somupvotes.domain.User;


@Entity
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 6547175121613994306L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String authority;
	@ManyToOne()
	private User user;

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
