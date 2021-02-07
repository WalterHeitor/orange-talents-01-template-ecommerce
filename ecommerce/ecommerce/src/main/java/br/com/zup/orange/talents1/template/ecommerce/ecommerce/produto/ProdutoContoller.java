package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.UsuarioRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoContoller {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository ususarioRepository;
	@Autowired
	private Uploader uploaderFake;
	
	@InitBinder(value = "produtoRequest")
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
	@PostMapping("/{id}/imagens")
	@Transactional
	public String adicionaImagens(@PathVariable Long id, @Valid NovasImagensRequest request) {
		
		Usuario usuarioLogado = ususarioRepository.findByLogin("walter@email.com").get();
		Produto produto = manager.find(Produto.class, id);

		Set<String> links = uploaderFake.envia(request.getImages());
		
		if(!produto.pertenceAoUsuario(usuarioLogado)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
		produto.associaImagens(links);
		
		manager.merge(produto);
		
		return produto.toString();
	}
}
