package com.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Member {
	@Id
	@GeneratedValue
	int id;
	String email;
	String password;
}
