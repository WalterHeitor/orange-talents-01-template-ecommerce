package br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
@Entity
public class Perfil implements GrantedAuthority{

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	   private String nome;

	public Perfil(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return nome;
	}
	   
	   
}
