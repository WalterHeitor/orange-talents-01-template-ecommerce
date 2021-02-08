package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.UsuarioRepository;
@RestController
@RequestMapping("/produtos")
public class AdcionaPerguntaController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository ususarioRepository;
	@Autowired
	private Emails emails;
	
	@PostMapping("/{id}/perguntas")
	@Transactional
	public String salvar(@RequestBody @Valid PerguntaRequest request,
			@PathVariable("id") Long id) {
		Produto produto = manager.find(Produto.class, id);
		
		Usuario interessada = ususarioRepository.findByLogin("walter@email.com").get();
		Pergunta novaPergunta = request.toModel(interessada, produto);
		manager.persist(novaPergunta);
		
		emails.novaPergunta(novaPergunta);
				
		return novaPergunta.toString();
	}
}
