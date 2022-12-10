package com.itandapps.trackitweb.auth.app.security.repository;

import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itandapps.trackitweb.auth.app.security.entity.Usuario;


@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	private JdbcTemplate plantilla;
	
	public UsuarioRepositoryImpl(JdbcTemplate plantilla) {
	    this.plantilla = plantilla;
	 }
	
	@Override
	public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
		String sql="select NOMBRE AS NOMBRE, "
				+ "        USUARIO AS NOMBREUSUARIO, "
				+ "        EMAIL AS EMAIL, "
				+ "        PASSWORD AS PASSWORD "
				+ " from QV_LTMON_USUARIOS "
				+ " WHERE USUARIO = ?";
		Usuario u = (Usuario) plantilla.queryForObject(sql, new Object[] {nombreUsuario}, new BeanPropertyRowMapper(Usuario.class));
		Optional<Usuario>usuarioOptional = Optional.of(u);
		return usuarioOptional;
	}

	@Override
	public boolean existsByNombreUsuario(String nombreUsuario) {
		String sql="select COUNT(*) "
				+ "from QV_LTMON_USUARIOS"
				+ "WHERE USUARIO = ?";
		int cont = plantilla.queryForObject(sql, new Object[] {nombreUsuario}, Integer.class);
		if (cont > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean existsByEmail(String email) {
		String sql="select COUNT(*) "
				+ "from QV_LTMON_USUARIOS"
				+ "WHERE EMAIL = ?";
		int cont = plantilla.queryForObject(sql, new Object[] {email}, Integer.class);
		if (cont > 0) {
			return true;
		}
		return false;
	}

}
