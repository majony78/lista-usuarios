package com.spring.alex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.alex.service.UsuarioService;


@Controller

public class NavigationController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/prueba")
	public String paginaPrueba() {
		return "prueba";
	}
	
	@GetMapping("/")
	public String paginaInicio() {
		return "index";
	}
	
	@GetMapping("/createusuario")
	public String crearUsuario() {
		return "usuario/createusuario";
	}
	@DeleteMapping("/deleteusuario/{id}")
	public void deleteUsuario(@PathVariable Integer id) {
		usuarioService.deleteById(id);
	}
	
	@GetMapping("/listausuario")
	public String listaUsuario() {
		return "usuario/listausuario";
	}
	
	@GetMapping("/updateusuario/{id}")
	public String updateUsuario(@PathVariable Long id) {
		return "usuario/updateusuario";
	}
	@GetMapping("/createroles")
	public String crearRoles() {
		return "rol/createroles";
	}
	
	@GetMapping("/listaroles")
	public String listaRoles() {
		return "rol/listaroles";
	}
	
	@GetMapping("/updateroles")
	public String updateRoles() {
		return "rol/updateroles";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	
	
	@GetMapping("/index4")
	public String index4() {
		return "index4";
	}
	

	@GetMapping("/index5")
	public String index63() {
		return "index5";
	}
	
	
	
	
}
