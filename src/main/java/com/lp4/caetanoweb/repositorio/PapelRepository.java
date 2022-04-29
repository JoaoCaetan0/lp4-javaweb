package com.lp4.caetanoweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp4.caetanoweb.orm.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	Papel findByPapel(String papel);

}
