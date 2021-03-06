package com.lp4.caetanoweb.orm;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

//import com.lp4.caetanoweb.orm.Endereco;
import com.lp4.caetanoweb.orm.Papel;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "{validation.nome.min}")
	private String nome;
	
	@CPF(message = "{validation.cpf.valid}")
	private String cpf; 
	
	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@Email(message = "{validation.email.valid}")
	private String email;
		
	@NotEmpty(message = "{validation.password.valid}")
	@Size(min = 3, message = "{validation.password.min}")
	private String password;	
	
	@NotEmpty(message = "{validation.login.valid}")
	@Size(min = 4, message = "{validation.login.min}")
	private String login;
	
	private boolean ativo;	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_papel",
			   joinColumns = @JoinColumn(name = "usuario_id"),
			   inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private List<Papel> papeis;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", 
			  fetch = FetchType.EAGER)
	//@Valid
	//private Endereco endereco;
	

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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}	
	public Usuario(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.dataNascimento = usuario.getDataNascimento();
		this.password = usuario.getPassword();
		this.ativo = usuario.isAtivo();
		this.papeis = usuario.getPapeis();
		
	}
	
	public Usuario(String nome, String login, String cpf, String email, Date nascimento, String password, Boolean ativo, List<Papel> papel) {
		super();
		this.nome = nome;
		this.login = login;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = nascimento;
		this.password = password;
		this.ativo = ativo;

		
	}
	/*public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}*/
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
