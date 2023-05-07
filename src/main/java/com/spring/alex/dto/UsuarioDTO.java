package com.spring.alex.dto;

import com.spring.alex.model.Usuario;

public class UsuarioDTO {
	
	private Integer id;
	private String nombre;
	private String email;
	private String btneditar;
	private String btneliminar;
	
	public UsuarioDTO() {
		
	}



	public UsuarioDTO(Usuario usuario) {
	
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.email = usuario.getEmail();
	}



	public Integer getId() {
		return id;
	}



	public void setUsuarioId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
	


	public String getBtneditar() {
		return "<button type=\"button\" method=\"get\" class=\"btn btn-primary\" id=\"btneditar\" >Editar</button>";
	}



	public void setBtneditar(String btneditar) {
		this.btneditar = btneditar;
	}

	


	public String getBtneliminar() {
		return  "<button type=\"button\" method=\"delete\" class=\"btn btn-danger\" id=\"btneliminar\" >Eliminar</button>" ;
	}



	public void setBtneliminar(String btneliminar) {
		this.btneliminar = btneliminar;
	}



	@Override
	public String toString() {
		return "UsuarioDTO [usuarioId=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	


	
	
}
 