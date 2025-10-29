package com.maventech.elocrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maventech.elocrm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsuario(String usuario);

}

