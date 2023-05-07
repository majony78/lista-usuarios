package com.spring.alex.dto;

import com.spring.alex.model.Rol;

public class RolDTO {
	
	private Integer rolId;
	private String admin;
	private String user;
	
	
	public RolDTO() {
	}


	public RolDTO(Rol rol) {
		this.rolId = rol.getRolId();
		this.admin = rol.getAdmin();
		this.user = rol.getUser();
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
		return "RolDTO [rolId=" + rolId + ", admin=" + admin + ", user=" + user + "]";
	}
	
	

	
	
}
