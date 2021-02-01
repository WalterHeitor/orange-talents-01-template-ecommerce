package br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.validate.UniqueValue;

public class UsuarioRequest {
	
	@NotBlank
	@Email
	@UniqueValue(domainClass = Usuario.class, 
	fieldName = "login", message = "Já existe este email cadastrado no banco de dados.")
	private String login;
	@NotBlank 
	@Size(min = 6, message = "A senha deve ter no minimo {min} "
			+ "caracteres. Voçe digitou: ${validateValue} . ")
	private String senha;
	@NotNull
	@Past(message = "A data deve estar no passado")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dateCadastro;
	
	
	
	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDate getDateCadastro() {
		return dateCadastro;
	}

	public UsuarioRequest() {	}

	public UsuarioRequest(@NotBlank @Email String login, @NotBlank @Size String senha,
			@Past LocalDate dateCadastro) {
		super();
		this.login = login;
		this.senha = senha;
		this.dateCadastro = dateCadastro;
	}
	
	public void setDateCadastro(LocalDate dateCadastro) {
		this.dateCadastro = dateCadastro;
	}

	@Override
	public String toString() {
		return "UsuarioRequest [login=" + login + ", senha=" + senha + ", dateCadastro=" + dateCadastro + "]";
	}

	public Usuario tranformaParaObjeto() {
		return new Usuario(login, new SenhaLimpa(senha), dateCadastro);
	}
	
	
	

}
