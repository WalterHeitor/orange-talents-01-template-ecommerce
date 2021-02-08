package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;

@Component
@Primary
public class FakeMailer implements Mailer{

	@Override
	public void send(String body, String subject, String nameFrom, String from, Usuario to) {
		System.out.println(body);
		System.out.println(subject);
		System.out.println(nameFrom);
		System.out.println(from);
		System.out.println(to);
		
	}

}
