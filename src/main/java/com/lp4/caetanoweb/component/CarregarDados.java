package com.lp4.caetanoweb.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lp4.caetanoweb.orm.Papel;
import com.lp4.caetanoweb.repositorio.FilmeRepositorio;
import com.lp4.caetanoweb.repositorio.PapelRepository;

@Component
public class CarregarDados implements CommandLineRunner{
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		String[] papeis = {"ADMIN", "USER", "GERENTE"};
		
		for (String papelString: papeis) {
			Papel papel = papelRepository.findByPapel(papelString);
			if(papel == null) {
				papel = new Papel(papelString);
				papelRepository.save(papel);
			}
		
	}
	}

}
