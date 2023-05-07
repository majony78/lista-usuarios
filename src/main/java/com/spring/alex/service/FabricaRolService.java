package com.spring.alex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.alex.dto.RolDTO;
import com.spring.alex.model.Rol;

@Service
public class FabricaRolService {

	
	public Rol crearRol(RolDTO rolDTO) {
		return new Rol(rolDTO);
	}
	
	public RolDTO crearRolDTO(Rol rol) {
		return new RolDTO(rol);
	}
	
   public List<RolDTO> crearRolesDTO(List<Rol> roles){
	   List<RolDTO> rolesDTO = new ArrayList<>();
		  roles.stream().forEach(
			rol -> {
				rolesDTO.add(new RolDTO(rol));
			}
				  
	 );
		  return rolesDTO;	  
	   
   }
	
	
}
