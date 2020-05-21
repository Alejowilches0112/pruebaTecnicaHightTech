package com.prueba.Hightech.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.Hightech.models.Entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
}
