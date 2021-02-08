package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class Emails {

	@Autowired
	private Mailer mailer;
	
	public void novaPergunta(@NotNull @Valid Pergunta pergunta) {
		//new RestTemplate().postForEntity("http://api.mandril.app.com", mandrilMessage, String.class)
		mailer.send("<html>....</html>", "Nova Pergunta para o produto",
				pergunta.getPerguntador().getEmail(),
				"novaPergunta@mercadoLivre.com", 
				pergunta.getDonoProduto());
	}

}
