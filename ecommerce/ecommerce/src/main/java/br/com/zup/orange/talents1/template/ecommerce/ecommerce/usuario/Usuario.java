package br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Usuario {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	@Column(nullable = false, unique = true )
	private String login;
	@NotBlank
	@Size(min = 6, message = "A senha deve ter no minimo {min} "
			+ "caracteres. Voçe digitou: ${validateValue} . ")
	@Column(nullable = false)
	private String senha;
	@NotNull
	@Past(message = "A data deve estar no passado")
	@Column(nullable = false)
	private LocalDate dateCadastro;
	
	private String role ;
	
	public Usuario(@NotBlank @Email String login,
			@Valid @NotNull SenhaLimpa senhaLimpa,
			@Past(message = "A data deve estar no passado") LocalDate dateCadastro,String role) {
		super();
		this.login = login;
		this.senha = senhaLimpa.hash();
		this.dateCadastro = dateCadastro;
		this.role = "USER";
	}
	public Long getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public LocalDate getDateCadastro() {
		return dateCadastro;
	}
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", dateCadastro=" + dateCadastro
				+ ", role=" + role + "]";
	}
	

	
}
