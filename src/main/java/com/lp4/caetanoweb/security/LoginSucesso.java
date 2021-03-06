package com.lp4.caetanoweb.security;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import com.lp4.caetanoweb.repositorio.UsuarioRepository;

import com.lp4.caetanoweb.orm.Papel;
import com.lp4.caetanoweb.orm.Usuario;

@Component
public class LoginSucesso extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		System.out.println("Passou aqui (Início) !!");
		// pega o login do usuário logado
		String login = authentication.getName(); 
		// busca o usuário no banco pelo login
		Usuario usuario = usuarioRepository.findByLogin(login);	
		
		String redirectURL = "";
		if (temAutorizacao(usuario, "ADMIN")) {
            redirectURL = "/auth/admin/admin-index";
        } else if (temAutorizacao(usuario, "USER")) {
            redirectURL = "/auth/user/user-index";
        } else if (temAutorizacao(usuario, "GERENTE")) {
            redirectURL = "/auth/gerente/gerente-index";
        }
		System.out.println("Passou aqui!!");
        response.sendRedirect(redirectURL);         
    }
	/**
	 * Método que verifica qual papel o usuário tem na aplicação 
	 * */
	private boolean temAutorizacao(Usuario usuario, String papel) {
		for (Papel pp : usuario.getPapeis()) {
			if (pp.getPapel().equals(papel)) {
				return true;
			}
	    }
		return false;
	}
}

