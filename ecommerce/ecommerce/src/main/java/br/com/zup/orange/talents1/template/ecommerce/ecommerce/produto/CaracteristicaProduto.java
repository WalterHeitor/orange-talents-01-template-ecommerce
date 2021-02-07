package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class CaracteristicaProduto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank String descricao;
	@ManyToOne
	private @NotNull @Valid Produto produto;
	
	@Deprecated
	public CaracteristicaProduto() {
		
	}

	public CaracteristicaProduto(@NotBlank String nome, @NotBlank String descricao, @NotNull @Valid Produto produto) {
		this.nome = nome;
		this.descricao = descricao;
		this.produto = produto;
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto getProduto() {
		return produto;
	}

	@Override
	public String toString() {
		return "CaracteristicaProduto [nome=" + nome + ", descricao=" + descricao + "]";
	}

	
}
