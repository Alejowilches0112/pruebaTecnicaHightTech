package com.prueba.Hightech.models.Services;

import java.util.List;

import com.prueba.Hightech.models.Entity.Cliente;

public interface IClienteServices {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente c);
	
	public Cliente update(Cliente c);
	
}
