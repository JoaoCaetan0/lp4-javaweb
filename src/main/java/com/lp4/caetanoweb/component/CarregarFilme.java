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
		Filme filme1 = new Filme("Vingadores: Guerra Infinita",
				"3h", data, "7.2", "https://upload.wikimedia.org/wikipedia/pt/thumb/9/90/Avengers_Infinity_War.jpg/250px-Avengers_Infinity_War.jpg");
	filmeRepositorio.save(filme1);
		
		data = sdf.parse("20/05/2014");
		Filme filme2 = new Filme("Venom",
				"1.5h", data, "3.5", "https://2.bp.blogspot.com/-BdW8UtzD58I/W6wn-T3D65I/AAAAAAABj0g/Qd3kLAzlAR0OhOT-iqATRsuAogVCTpeRQCLcBGAs/s1600/CDVenom.jpeg");
	filmeRepositorio.save(filme2);
	
	data = sdf.parse("14/07/2011");
	Filme filme3 = new Filme("Minha Mãe é uma Peça",
			"2h", data, "10", "https://upload.wikimedia.org/wikipedia/pt/d/da/Minha_M%C3%A3e_%C3%A9_uma_Pe%C3%A7a.jpg");
filmeRepositorio.save(filme3);

	data = sdf.parse("28/01/2017");
	Filme filme4 = new Filme("Minha Mãe é uma Peça",
			"10h", data, "0", "https://br.web.img3.acsta.net/c_310_420/pictures/19/07/11/20/16/2463436.jpg");
	filmeRepositorio.save(filme4);
	
	
}
	}
	
