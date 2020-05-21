package com.prueba.Hightech.models.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.Hightech.models.Dao.ITarjetasDao;
import com.prueba.Hightech.models.Entity.TarjetaCredito;

@Service
public class TarjetaServiceImpl implements ITarjetaService{
	
	@Autowired
	private ITarjetasDao tarjetaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TarjetaCredito> findAll() {
		// TODO Auto-generated method stub
		return (List<TarjetaCredito>) tarjetaDao.findAll();
	}
	
	
}
