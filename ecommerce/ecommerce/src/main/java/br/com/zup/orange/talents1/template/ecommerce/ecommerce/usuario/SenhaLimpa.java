package br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

/**
 * Representa uma senha limpa no sistema
 * @author Walter.Oliveira
 *
 */
public class SenhaLimpa {
	@NotBlank
	@Size(min = 6, message = "A senha deve ter no minimo {min} "
			+ "caracteres. Voçe digitou: ${validateValue} . ")
	String senha;

	public SenhaLimpa(
			@NotBlank @Size(min = 6, message = "A senha deve ter no minimo"
					+ " {min} caracteres. Voçe digitou: ${validateValue} . ") String senha) {
		Assert.hasLength(senha, "A senha não pode ser em branco");
		Assert.isTrue(senha.length() >= 6, "A senha tem no minimo de 6 caracteres.");
		this.senha = senha;
	}

	public String hash() {
		return new BCryptPasswordEncoder().encode(senha);
	}
	
	

}
