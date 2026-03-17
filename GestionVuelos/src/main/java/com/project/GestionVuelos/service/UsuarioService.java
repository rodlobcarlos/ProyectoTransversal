package com.project.GestionVuelos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.GestionVuelos.model.Usuario;

public interface UsuarioService {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	public boolean existsByNombre(String nombre);

	public void saveUsuario(Usuario u);
}
