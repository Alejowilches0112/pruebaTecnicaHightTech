package com.prueba.Hightech.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.Hightech.models.Entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
