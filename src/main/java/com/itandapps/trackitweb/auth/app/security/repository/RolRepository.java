package com.itandapps.trackitweb.auth.app.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itandapps.trackitweb.auth.app.security.entity.Rol;
import com.itandapps.trackitweb.auth.app.security.enums.RolNombre;



public interface RolRepository  {

	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
