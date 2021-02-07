package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCaracteristicaReques {

	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	public NovaCaracteristicaReques(@NotBlank String nome, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public CaracteristicaProduto toModel(@NotNull @Valid Produto produto) {
		
		return new CaracteristicaProduto(nome, descricao, produto);
	}
	
}
