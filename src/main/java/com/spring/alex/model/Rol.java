package com.spring.alex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.alex.dto.RolDTO;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolId;
	private String admin;
	private String user;
	
	
	public Rol() {
	}
	
	
	public Rol(RolDTO rolDto) {
		this.rolId = rolDto.getRolId();
		this.admin = rolDto.getAdmin();
		this.user = rolDto.getUser();
	}



	public Rol(Integer rolId, String admin, String user) {
		super();
		this.rolId = rolId;
		this.admin = admin;
		this.user = user;
	}


	public Integer getRolId() {
		return rolId;
	}


	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}


	public String getAdmin() {
		return admin;
	}


	public void setAdmin(String admin) {
		this.admin = admin;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Rol [rolId=" + rolId + ", admin=" + admin + ", user=" + user + "]";
	}
	
	
	
	

}
