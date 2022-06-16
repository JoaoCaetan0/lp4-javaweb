package com.lp4.caetanoweb.component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lp4.caetanoweb.orm.Usuario;
import com.lp4.caetanoweb.orm.Filme;
import com.lp4.caetanoweb.orm.Papel;
import com.lp4.caetanoweb.repositorio.UsuarioRepository;

/*@Component
public class CarregarUsuario implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse("24/09/1995");
		Papel papel = new Papel();
		papel.setPapel("ADMIN");
		ArrayList<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		Usuario usuario1 = new Usuario("admin", "admin", "81733721100", "admin@gmail.com", data, "admin", true, papeis);
		Usuario[] usuarios = {usuario1};

		for (Usuario usuarioV : usuarios) {
			Usuario usuario = usuarioRepository.findByLogin(usuarioV.getLogin());
			if (usuario == null) {
				usuario = new Usuario(usuarioV);
				usuarioRepository.save(usuario);
			}

		}
		
	}
}
*/