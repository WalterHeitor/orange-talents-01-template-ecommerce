package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProibeCaracteristicasComNomesIguaisValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProdutoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProdutoRequest produtoRequest = (ProdutoRequest) target;
		Set<String> nomesIguais = produtoRequest.buscarCaracteristicasIguais();
		if(!nomesIguais.isEmpty()) {
			errors.rejectValue("caracteristicas", null, "Voce tem caracteristicas iguais ");			
		}
	}

}
