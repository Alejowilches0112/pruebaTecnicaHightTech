package com.prueba.Hightech.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.Hightech.models.Entity.Cliente;
import com.prueba.Hightech.models.Entity.TarjetaCredito;
import com.prueba.Hightech.models.Services.ClienteServiceImpl;
import com.prueba.Hightech.models.Services.TarjetaServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private ClienteServiceImpl clienteService;
	@Autowired
	private TarjetaServiceImpl tarjetaService;
	
	@GetMapping("/clientes")
	public ResponseEntity<?> findAll(){
		Map<String, Object> response = new HashMap<>();
		List<Cliente> cliente;
		try {
			cliente = clienteService.findAll();
			response.put("clientes", cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/tarjetas")
	public ResponseEntity<?> findAllTarjetas(){
		Map<String, Object> response = new HashMap<>();
		List<TarjetaCredito> tarjetas;
		try {
			tarjetas = tarjetaService.findAll();
			response.put("tarjetas", tarjetas);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> save(@RequestBody Cliente cliente){
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.save(cliente);
			response.put("cliente", cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar el cliente");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente cliente){
		Map<String, Object> response = new HashMap<>();
		try {
			Cliente clienteAct = clienteService.findById(id);
			System.err.println(clienteAct.getNombre1()+" : " +cliente.getNombre1());
			clienteAct.setNombre1(cliente.getNombre1());
			clienteAct.setNombre2(cliente.getNombre2());
			clienteAct.setApellido1(cliente.getApellido1());
			clienteAct.setApellido2(cliente.getApellido2());
			clienteAct.setDireccion(cliente.getDireccion());
			clienteAct.setEmail(cliente.getEmail());
			clienteAct.setTarjetas(cliente.getTarjetas());
			cliente = clienteService.save(clienteAct);
			response.put("cliente", cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
