package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.categoria.Categoria;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.validate.ExistId;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.validate.UniqueValue;

public class ProdutoRequest {

	@NotBlank
	@UniqueValue(domainClass = Produto.class, fieldName = "nome",
	message = "Não podemos cadastrar produtos com mesmo nome.")
	private String nome;
	@Positive
	@Length(max = 1000)
	private int quantidade;
	@NotBlank
	private String descricao;
	@NotNull
	@Positive
	private BigDecimal valor;
	@ExistId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	@Size(min = 3)
	@Valid
	private List<NovaCaracteristicaReques> caracteristicas = new ArrayList<>();

	public ProdutoRequest(@NotBlank String nome, @Positive @Length(max = 1000) int quantidade,
			@NotBlank String descricao, @Positive BigDecimal valor, Long idCategoria,
			List<NovaCaracteristicaReques> caracteristicas) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.valor = valor;
		this.idCategoria = idCategoria;
		this.caracteristicas.addAll(caracteristicas);

	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public List<NovaCaracteristicaReques> getCaracteristicas() {
		return caracteristicas;
	}

	@Override
	public String toString() {
		return "ProdutoRequest [nome=" + nome + ", quantidade=" + quantidade + ", descricao=" + descricao + ", valor="
				+ valor + ", idCategoria=" + idCategoria + ", caracteristicas=" + caracteristicas + "]";
	}

	public Produto toModel(EntityManager manager, Usuario usuarioLogado) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Produto(nome, quantidade, descricao, valor, categoria, usuarioLogado, caracteristicas);
	}

	public Set<String> buscarCaracteristicasIguais() {
		//hashSet nao suporta elementos iguais.
		HashSet<String>nomesIguais = new HashSet<>();
		HashSet<String>resultados = new HashSet<>();
		for(NovaCaracteristicaReques caracteristica : caracteristicas) {
			String nome = caracteristica.getNome();
			if(!nomesIguais.add(nome)) {
				resultados.add(nome);
			}
		}
		return resultados;
	}
	
//	public boolean temCaracteristicas() {
//	// hashSet nao suporta elementos iguais.
//	HashSet<String> nomesIguais = new HashSet<>();
//	for (NovaCaracteristicaReques caracteristica : caracteristicas) {
//		if (!nomesIguais.add(caracteristica.getNome())) {
//			return true;
//		}
//	}
//	return false;
//}	
}
