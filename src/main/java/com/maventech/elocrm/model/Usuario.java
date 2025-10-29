package com.maventech.elocrm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	@NotBlank(message = "Por favor, informe o Nome para cadastro: ")
	private String nome;
 
	@NotBlank(message = "Por favor, informe o Usuário para cadastro: ")
	@Email(message = "Parece que o e-mail informado não é válido. Verifique as informações digitadas e tente novamente.")
	private String usuario;
 
	@NotBlank(message = "Por favor, insira uma Senha: ")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres. Verifique as informações digitadas e tente novamente.")
	private String senha;
 
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres.")
	private String foto;
 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "usuario", allowSetters = true)
	private List<Oportunidade> oportunidade;
 
	public Long getId() {
		return this.id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getNome() {
		return this.nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public String getUsuario() {
		return this.usuario;
	}
 
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
 
	public String getSenha() {
		return this.senha;
	}
 
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
	public String getFoto() {
		return this.foto;
	}
 
	public void setFoto(String foto) {
		this.foto = foto;
	}
 
	public List<Oportunidade> getOportunidade() {
		return this.oportunidade;
	}
 
	public void setOportunidade(List<Oportunidade> oportunidade) {
		this.oportunidade = oportunidade;
	}
 
}