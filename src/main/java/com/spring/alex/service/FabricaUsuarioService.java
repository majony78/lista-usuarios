package com.spring.alex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.alex.dto.UsuarioDTO;
import com.spring.alex.model.Usuario;

@Service
public class FabricaUsuarioService {
	
	public Usuario crearUsuario(UsuarioDTO usuarioDto) {
		return new Usuario(usuarioDto);
	}
	
	public UsuarioDTO crearUsuarioDTO(Usuario usuario) {
		return new UsuarioDTO(usuario);
	}
	
	public List<UsuarioDTO> crearUsuariosDTO(List<Usuario> listaUsuarios){
		List<UsuarioDTO> usuariosDTOS = new ArrayList<>();
		listaUsuarios.stream().forEach(
				usuario -> {
				  usuariosDTOS.add(crearUsuarioDTO(usuario));	
				}
				
		);
		return usuariosDTOS;
	}


}
