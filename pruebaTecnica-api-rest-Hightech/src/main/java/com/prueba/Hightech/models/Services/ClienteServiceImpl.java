package com.prueba.Hightech.models.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.Hightech.models.Dao.IClienteDao;
import com.prueba.Hightech.models.Entity.Cliente;
@Service
public class ClienteServiceImpl implements IClienteServices{
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente c) {
		return clienteDao.save(c);
	}

	@Override
	@Transactional
	public Cliente update(Cliente c) {
		return clienteDao.save(c);
	}
}
