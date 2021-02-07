package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.UsuarioRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoContoller {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository ususarioRepository;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProibeCaracteristicasComNomesIguaisValidator());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> salvar(@RequestBody @Valid ProdutoRequest produtoRequest){
		//simulando usuario logado
		Usuario usuarioLogado = ususarioRepository.findByLogin("walter@email.com").get();
		Produto produto = produtoRequest.toModel(manager, usuarioLogado);
		manager.persist(produto);
		return ResponseEntity.ok(produto.toString());
	}
}
