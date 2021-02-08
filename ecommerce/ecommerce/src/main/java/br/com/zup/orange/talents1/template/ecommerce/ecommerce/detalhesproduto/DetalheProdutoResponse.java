package br.com.zup.orange.talents1.template.ecommerce.ecommerce.detalhesproduto;

import java.math.BigDecimal;
import java.util.Set;
import java.util.SortedSet;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;

public class DetalheProdutoResponse {

	private String descricao;
	private String nome;
	private BigDecimal valor;
	private Set<DetalheProdutoCaracteristica> caracteristicas;
	private Set<String> linksImagens;
	private SortedSet<String> perguntas;

	public DetalheProdutoResponse(Produto produto) {
		this.descricao = produto.getDescricao();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		
		this.caracteristicas = produto.
				mapeiaCaracteristicas(DetalheProdutoCaracteristica::new);
		this.linksImagens = produto.mapeiaImagens(imagem -> imagem.getLink());
		this.perguntas = produto.mapeiaPerguntas(pergunta -> pergunta.getTitulo());
	}
		
//		this.caracteristicas = produto.mapCaracteristicas(
//				caracteristicas -> new DetalheProdutoCaracteristica(caracteristica));
		
//		this.caracteristicas = produto.getCaracteristicas().stream()
//				.map(caracteristica -> 
//				new DetalheProdutoCaracteristica(caracteristica))
//				.collect(Collectors.toSet());
//	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	
	public Set<DetalheProdutoCaracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public Set<String> getLinksImagens() {
		return linksImagens;
	}
	public SortedSet<String> getPerguntas() {
		return perguntas;
	}

}
