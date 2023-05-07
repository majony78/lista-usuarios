package com.spring.alex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.alex.dto.RolDTO;
import com.spring.alex.repository.IRolRepository;

@Service
public class RolService {
	
	@Autowired
	private IRolRepository rolRepository;
	@Autowired
	private FabricaRolService fabricaRolService;
	
	
	public RolDTO save(RolDTO rolDTO) {
		return fabricaRolService.crearRolDTO(rolRepository.save(fabricaRolService.crearRol(rolDTO)));
	}
	
	public List<RolDTO> findAll(){
		return fabricaRolService.crearRolesDTO(rolRepository.findAll());
	}
	
	public RolDTO findById(Integer id) {
		return fabricaRolService.crearRolDTO(rolRepository.findById(id).get());
		
	}
	
	public void deleteById(Integer id) {
		rolRepository.deleteById(id);
	}

}
