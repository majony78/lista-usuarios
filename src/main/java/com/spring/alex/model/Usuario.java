package com.spring.alex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.alex.dto.UsuarioDTO;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;

	public Usuario() {

	}
	
	public Usuario(UsuarioDTO usuarioDto) {
		this.id = usuarioDto.getId();
		this.nombre = usuarioDto.getNombre();
		this.email = usuarioDto.getEmail();
	}
	
	

	public Usuario(Integer usuarioId, String nombre, String email) {
		this.id = usuarioId;
		this.nombre = nombre;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
