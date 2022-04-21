package com.lp4.caetanoweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp4.caetanoweb.orm.Filme;

public interface FilmeRepositorio extends JpaRepository<Filme, Long>  {

}
