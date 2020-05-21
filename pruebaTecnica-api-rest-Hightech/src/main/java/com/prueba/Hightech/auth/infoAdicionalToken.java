package com.prueba.Hightech.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.prueba.Hightech.models.Entity.Usuario;
import com.prueba.Hightech.models.Services.UsuarioServiceImpl;

@Component
public class infoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		Usuario usr = usuarioService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("username", authentication.getName());
		info.put("nombre", usr.getNombre());
		info.put("apellido", usr.getApellido());
		info.put("email", usr.getEmail());
		info.put("codigo", usr.getId());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
