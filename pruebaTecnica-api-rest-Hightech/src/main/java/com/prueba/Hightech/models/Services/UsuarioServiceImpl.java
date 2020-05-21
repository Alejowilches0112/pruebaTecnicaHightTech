package com.prueba.Hightech.models.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.Hightech.models.Dao.IUsuarioDao;
import com.prueba.Hightech.models.Entity.Usuario;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService {

	private Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = usuarioDao.findByUsername(username);
		if(u == null)
		{
			log.error("Error en el Login: Usuario no existe");
			throw new UsernameNotFoundException("Error en el Login: Usuario/Clave Incorrectos");
		}
		
		List<GrantedAuthority> authorities = u.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre_rol()))
				.peek(auto -> log.info("Rol: "+auto.getAuthority()))
				.collect(Collectors.toList());
		return new User(username, u.getPassword(), u.isActivo(),true, true, true, authorities);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> GetUsuarios() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario Update(Usuario usr) {
		return usuarioDao.save(usr);
	}

	@Override
	@Transactional
	public Usuario Save(Usuario usr) {
		return usuarioDao.save(usr);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(new Usuario());
	}

	@Override
	@Transactional(readOnly = true)
	public long countByToken(String token) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
