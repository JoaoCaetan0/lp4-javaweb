package com.lp4.caetanoweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp4.caetanoweb.orm.Filme;
import com.lp4.caetanoweb.orm.Papel;
import com.lp4.caetanoweb.orm.Usuario;

public interface FilmeRepositorio extends JpaRepository<Filme, Long>  {
	Filme findByLinkImg(String link);

}
