package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;

public interface Mailer {

	/**
	 * 
	 * @param body corpo do email
	 * @param subject assunto do email
	 * @param nameFrom nome para aparecer no provedor de email
	 * @param name email de origem
	 * @param toemail de destino
	 */
	void send(@NotBlank String body, @NotBlank String subject,
			@NotBlank String nameFrom, @NotBlank @Email String from, 
			@NotBlank @Email Usuario to);

}
