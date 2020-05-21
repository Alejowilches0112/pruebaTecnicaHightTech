package com.prueba.Hightech.models.Services;

import java.util.List;

import com.prueba.Hightech.models.Entity.Usuario;



public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
	public List<Usuario> GetUsuarios();
	
	public Usuario Update(Usuario usr);
	
	public Usuario Save(Usuario usr);
	
	public Usuario findById(Long id);
	
	public long countByToken(String token);
}
