package com.itandapps.trackitweb.auth.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itandapps.trackitweb.auth.app.security.entity.Usuario;
import com.itandapps.trackitweb.auth.app.security.entity.UsuarioPrincipal;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByNombreUsuario(username).get();
		return UsuarioPrincipal.build(usuario);
	}

}
