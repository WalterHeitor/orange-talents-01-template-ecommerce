package br.com.zup.orange.talents1.template.ecommerce.ecommerce.detalhesproduto;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.CaracteristicaProduto;

public class DetalheProdutoCaracteristica {

	private String nome;
	private String descricao;

	public DetalheProdutoCaracteristica(CaracteristicaProduto caracteristica) {
		this.nome = caracteristica.getNome();
		this.descricao = caracteristica.getDescricao();
	}

	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
}
