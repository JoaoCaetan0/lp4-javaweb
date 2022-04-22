package com.lp4.caetanoweb.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lp4.caetanoweb.orm.Filme;
import com.lp4.caetanoweb.repositorio.FilmeRepositorio;

@Component
public class CarregarFilme implements CommandLineRunner{

	@Autowired
	private FilmeRepositorio filmeRepositorio;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse("20/05/2018");
		Filme filme = new Filme("Vingadores: Guerra Infinita",
				"3h", data, "7.2", "https://upload.wikimedia.org/wikipedia/pt/thumb/9/90/Avengers_Infinity_War.jpg/250px-Avengers_Infinity_War.jpg");
	filmeRepositorio.save(filme);
	}
	

}
