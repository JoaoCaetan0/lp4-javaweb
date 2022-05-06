package com.lp4.caetanoweb.orm;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
	private String nome;
	
	@NotEmpty(message = "A duração deve ser informada")
	private String duracaoFilme;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataLancamento;	
	
	@NotEmpty(message = "A pontuação deve ser informada")
	private String pontuacaoCritica;
	
	@NotEmpty(message = "O link da capa deve ser informado")
	private String linkImg;
	
	public String getLinkImg() {
		return linkImg; 
	}

	public void setLinkImg(String link) {
		this.linkImg = link;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracaoFilme() {
		return duracaoFilme;
	}

	public void setDuracaoFilme(String duracaoFilme) {
		this.duracaoFilme = duracaoFilme;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getPontuacaoCritica() {
		return pontuacaoCritica;
	}

	public void setPontuacaoCritica(String pontuacaoCritica) {
		this.pontuacaoCritica = pontuacaoCritica;
	}

	public Filme(String nome,
			String duracaoFilme, Date dataLancamento, String pontuacaoCritica, String linkImg) {
		super();
		this.nome = nome;
		this.duracaoFilme = duracaoFilme;
		this.dataLancamento = dataLancamento;
		this.pontuacaoCritica = pontuacaoCritica;
		this.linkImg = linkImg;
	}
	public Filme(Filme filme) {
		super();
		this.nome = filme.getNome();
		this.duracaoFilme = filme.getDuracaoFilme();
		this.dataLancamento = filme.getDataLancamento();
		this.pontuacaoCritica = filme.getPontuacaoCritica();
		this.linkImg = filme.getLinkImg();
		
		
	}
	
	public Filme() {
		
	}
	
	/*@Max(value = 5)
	@Min(value = 0) 
	private double pontos;*/
	
	

	
}
