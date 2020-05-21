package com.prueba.Hightech.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.Hightech.models.Entity.Usuario;
import com.prueba.Hightech.models.Services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder encrypt;
	
	@GetMapping("/usuario")
	public ResponseEntity<?> findAll(){
		Map<String, Object> response = new HashMap<>();
		List<Usuario> usuarios;
		try {
			usuarios = usuarioService.GetUsuarios();
			response.put("usuarios", usuarios);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<?> save(@RequestBody Usuario u){
		Map<String, Object> response = new HashMap<>();
		try {
			u.setPassword((encrypt.encode(u.getPassword())));
			System.err.println(u.isActivo());
			u.setActivo(true);
			u = usuarioService.Save(u);
			response.put("usuario", u);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar el usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Usuario u){
		Map<String, Object> response = new HashMap<>();
		Usuario usuAct = new Usuario();
		try {
			usuAct = usuarioService.findById(id);
			usuAct.setNombre(u.getNombre());
			usuAct.setApellido(u.getApellido());
			usuAct.setEmail(u.getEmail());
			usuAct.setUsername(u.getUsername());
			usuAct.setPassword(encrypt.encode(u.getPassword()));
			usuAct.setActivo(u.isActivo());
			usuAct.setRoles(u.getRoles());
			u = usuarioService.Save(usuAct);
			response.put("usuario", u);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al editar el usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
