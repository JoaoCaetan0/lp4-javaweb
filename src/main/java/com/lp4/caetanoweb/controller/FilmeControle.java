package com.lp4.caetanoweb.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lp4.caetanoweb.orm.Filme;
import com.lp4.caetanoweb.repositorio.FilmeRepositorio;

@Controller
@RequestMapping("/filme")
public class FilmeControle {
	
	@Autowired
	private FilmeRepositorio filmeRepository;
	
	@GetMapping("/novo")
	public String adicionarFilme(Model model) {
		model.addAttribute("filme", new Filme());
		return "/publica-criar-filme";
	}
	
	@PostMapping("/salvar")
	public String salvarFilme(@Valid Filme filme, BindingResult result, 
				RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-filme";
		}	
		filmeRepository.save(filme);
		attributes.addFlashAttribute("mensagem", "Filme salvo com sucesso!");
		return "redirect:/filme/novo";
	}
	
	@RequestMapping("/admin/listar")
	public String listarFilme(Model model) {
		model.addAttribute("filmes", filmeRepository.findAll());		
		return "/auth/admin/admin-listar-filme";		
	}
	

	@GetMapping("/admin/apagar/{id}")
	public String deleteFilme(@PathVariable("id") long id, Model model) {
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		filmeRepository.delete(filme);
	    return "redirect:/filme/admin/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editarFilme(@PathVariable("id") long id, Model model) {
		Optional<Filme> filmeVelho = filmeRepository.findById(id);
		if (!filmeVelho.isPresent()) {
            throw new IllegalArgumentException("Filme inválido:" + id);
        } 
		Filme filme = filmeVelho.get();
	    model.addAttribute("filme", filme);
	    return "/auth/user/user-alterar-filme";
	}
	
	@PostMapping("/editar/{id}")
	public String editarFilme(@PathVariable("id") long id, 
			@Valid Filme filme, BindingResult result) {
		if (result.hasErrors()) {
	    	filme.setId(id);
	        return "/auth/user/user-alterar-filme";
	    }
	    filmeRepository.save(filme);
	    return "redirect:/filme/admin/listar";
	}
	
}
