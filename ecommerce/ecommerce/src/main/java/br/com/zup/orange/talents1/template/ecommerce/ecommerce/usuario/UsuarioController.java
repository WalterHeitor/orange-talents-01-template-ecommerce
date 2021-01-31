package br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario;

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
@RequestMapping("/usuario")
public class UsuarioController {
	
	@PersistenceContext
	EntityManager manger;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?>salvar(@RequestBody @Valid UsuarioRequest usuarioRequest){
		Usuario usuario = usuarioRequest.tranformaParaObjeto();
		return ResponseEntity.ok(usuarioRequest.toString());
		
	}

}
