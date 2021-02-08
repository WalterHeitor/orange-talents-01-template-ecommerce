package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionaopniaoproduto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.UsuarioRepository;

@RestController
@RequestMapping("/produtos")
public class AdcionaOpniaoController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository ususarioRepository;
	
	@PostMapping("/{id}/opiniao")
	@Transactional
	public String adiciona(@RequestBody @Valid  NovaOpniaoRequest request,
			@PathVariable("id") Long id) {
		Produto produto = manager.find(Produto.class, id);
		Usuario consumidor = ususarioRepository.findByLogin("walter@email.com").get();
		Opniao novaOpniao = request.toModel(produto, consumidor);
		manager.persist(novaOpniao);
		return novaOpniao.toString();
		}
}
