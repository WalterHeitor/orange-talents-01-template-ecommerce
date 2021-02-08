package br.com.zup.orange.talents1.template.ecommerce.ecommerce.detalhesproduto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;

@RestController
@RequestMapping("/produtos")
public class DetalheProdutoController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/{id}")
	public DetalheProdutoResponse buscar (@PathVariable("id") Long id) {
		Produto produtoEscolhido = entityManager.find(Produto.class, id);
		
		return new DetalheProdutoResponse(produtoEscolhido);
	}

}
