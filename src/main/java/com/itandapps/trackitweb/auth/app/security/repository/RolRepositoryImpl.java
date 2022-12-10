package com.itandapps.trackitweb.auth.app.security.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.itandapps.trackitweb.auth.app.security.entity.Rol;
import com.itandapps.trackitweb.auth.app.security.enums.RolNombre;


@Repository
public class RolRepositoryImpl implements RolRepository {

	@Override
	public Optional<Rol> findByRolNombre(RolNombre rolNombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
