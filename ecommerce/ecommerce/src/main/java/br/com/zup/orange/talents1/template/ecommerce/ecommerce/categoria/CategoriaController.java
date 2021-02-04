package br.com.zup.orange.talents1.template.ecommerce.ecommerce.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?>salvar(@RequestBody @Valid CategoriaRequest categoriaRequest){
		Categoria categoria = categoriaRequest.transformaParaObjeto(manager);
		manager.persist(categoria);
		return ResponseEntity.ok().body(categoriaRequest);
	}

}
