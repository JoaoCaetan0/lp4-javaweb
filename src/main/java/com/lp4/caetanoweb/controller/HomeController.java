package com.lp4.caetanoweb.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lp4.caetanoweb.orm.Usuario;
import com.lp4.caetanoweb.repositorio.UsuarioRepository;

@Controller
public class HomeController {
	@Autowired
    private MessageSource message; // internacionalização
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/") 
	public String index(@CurrentSecurityContext(expression="authentication.name")
		String login, Model model, Locale locale) { //locale para internacionalização
		
		Usuario usuarioLogado = usuarioRepository.findByLogin(login);	
		model.addAttribute("usuarioLogado", usuarioLogado);
		
		// internacionalização
		String msn = message.getMessage("index.welcome", null, locale);
		model.addAttribute("msnBemVindo", msn);
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
