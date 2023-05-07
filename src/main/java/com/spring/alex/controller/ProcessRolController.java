package com.spring.alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.alex.dto.RolDTO;
import com.spring.alex.dto.UsuarioDTO;
import com.spring.alex.service.MyModelMapper;
import com.spring.alex.service.RolService;

@RestController
@RequestMapping("/rol")
public class ProcessRolController {
	
	@Autowired
	private RolService rolService;
	@Autowired
	private MyModelMapper map;

	@PostMapping("/save")
	public ResponseEntity<RolDTO> save(@RequestBody RolDTO rolDTO) {
		return new ResponseEntity<>(rolService.save(rolDTO), HttpStatus.CREATED);
	}

	@PostMapping("/listar")
	public ResponseEntity<List<RolDTO>> findAll() {
		return new ResponseEntity<>(rolService.findAll(), HttpStatus.OK);

	}

	@PostMapping("/listar/{id}")
	public ResponseEntity<RolDTO> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(rolService.findById(id), HttpStatus.OK);

	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<RolDTO> deleteById(@PathVariable Integer id) {
		try {
			rolService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}


