package com.spring.alex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.alex.dto.UsuarioDTO;
import com.spring.alex.model.Usuario;
import com.spring.alex.service.MyModelMapper;
import com.spring.alex.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class ProcessUsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MyModelMapper map;

	@PostMapping("/save")
	public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDTO) {
		return new ResponseEntity<>(usuarioService.save(usuarioDTO), HttpStatus.CREATED);
	}

	@PostMapping("/listar")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<UsuarioDTO> searchUsuario(@PathVariable Integer id){
		return new ResponseEntity<UsuarioDTO>(usuarioService.findById(id), HttpStatus.OK);
		
	}
	
	

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
		UsuarioDTO UsuarioDTOEditado = usuarioService.findById(id);
		UsuarioDTO usuarioDTONuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		if(UsuarioDTOEditado == null) {
			response.put("memsaje", "No se encuentra al usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		try {
			UsuarioDTOEditado.setNombre(usuarioDTO.getNombre());
			UsuarioDTOEditado.setEmail(usuarioDTO.getEmail());
			usuarioDTONuevo = usuarioService.save(UsuarioDTOEditado);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar al usuario ");
			response.put("error", e.getMessage().concat(" ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		response.put("mensaje", "Usuario actualizado con éxito");
		response.put("usuarioDTONuevo", usuarioDTONuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<UsuarioDTO> deleteById(@PathVariable Integer id) {
		try {
			usuarioService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
