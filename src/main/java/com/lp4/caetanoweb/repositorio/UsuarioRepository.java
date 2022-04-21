package com.lp4.caetanoweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp4.caetanoweb.orm.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
