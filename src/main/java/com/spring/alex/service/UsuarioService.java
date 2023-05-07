 package com.spring.alex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.alex.dto.UsuarioDTO;
import com.spring.alex.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private FabricaUsuarioService fabricaUsuarioService;
	@Autowired
	private IUsuarioRepository usuarioRepository;
	

	public UsuarioDTO save(UsuarioDTO usuarioDTO) {

		return fabricaUsuarioService.crearUsuarioDTO(usuarioRepository.save(fabricaUsuarioService.crearUsuario(usuarioDTO))) ;

	}
	
	

	public List<UsuarioDTO> findAll() {
		return  fabricaUsuarioService.crearUsuariosDTO(usuarioRepository.findAll());
	}

	public UsuarioDTO findById(Integer id) {
		return fabricaUsuarioService.crearUsuarioDTO(usuarioRepository.findById(id).orElse(null));
	}

	public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
	}

}
