package br.com.projeto.model;
//Aonde ficam as entidades que representam tabelas de bancos de dados e tipos
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuarios {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Nome não pode ser nulo.")
	@NotEmpty(message = "Nome não pode ser vazio.")
	private String nome;

	@NotNull(message="Sobrenome não pode ser nulo.")
	@NotEmpty(message = "Sobrenome não pode ser vazio.")
	private String sobrenome;

	@NotNull(message="Telefone não pode ser nulo.")
	@NotEmpty(message = "Telefone não pode ser vazio.")
	private String telefone;

	public Usuarios() {
		
	}
	public Usuarios(String nome, String sobrenome, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	

}
