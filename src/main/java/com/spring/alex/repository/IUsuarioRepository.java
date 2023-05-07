package com.spring.alex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.alex.model.Usuario;



public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

}
