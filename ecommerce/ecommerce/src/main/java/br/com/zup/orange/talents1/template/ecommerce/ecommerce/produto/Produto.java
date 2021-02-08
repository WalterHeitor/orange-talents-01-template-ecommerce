package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta.Pergunta;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.categoria.Categoria;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @Positive @Length(max = 1000) int quantidade;
	private @NotBlank String descricao;
	private @Positive BigDecimal valor;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Usuario usuarioLogado;
	@OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	private Set<CaracteristicaProduto> caracteristicas =
			new HashSet<>();
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<ImagemProduto> imagens =
			new HashSet<>();
	@OneToMany(mappedBy = "produto")
	@OrderBy("titulo asc")
	private SortedSet<Pergunta> perguntas =
			new TreeSet<>();
	
	@Deprecated
	public Produto() { }

	public Produto(@NotBlank String nome, @Positive @Length(max = 1000) int quantidade, @NotBlank String descricao,
			@Positive BigDecimal valor, Categoria categoria, Usuario usuarioLogado, 
			@Size(min = 3) @Valid Collection <NovaCaracteristicaReques> caracteristicas) {
				this.nome = nome;
				this.quantidade = quantidade;
				this.descricao = descricao;
				this.valor = valor;
				this.categoria = categoria;
				this.usuarioLogado = usuarioLogado;
				Set<CaracteristicaProduto> novasCaracteristicas = caracteristicas.stream()
						.map(caracteristica -> caracteristica
								.toModel(this)).collect(Collectors.toSet());
				this.caracteristicas.addAll(novasCaracteristicas);
				Assert.isTrue(this.caracteristicas.size() >= 3, "Todo produto prescisa ter no minimo 3"
						+ " ou mais caracteristicas");
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Set<CaracteristicaProduto> getCaracteristicas() {
		return caracteristicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public void associaImagens(Set<String> links) {
		Set<ImagemProduto> imagens = links.stream().map(link -> new ImagemProduto(this, link))
		.collect(Collectors.toSet());
		this.imagens.addAll(imagens);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", descricao=" + descricao
				+ ", valor=" + valor + ", categoria=" + categoria + ", usuarioLogado=" + usuarioLogado
				+ ", caracteristicas=" + caracteristicas + ", imagens=" + imagens + "]";
	}

	public boolean pertenceAoUsuario(Usuario possivelUsuarioLogado) {
		return this.usuarioLogado.equals(possivelUsuarioLogado);
	}
	
	public <T> Set<T> mapeiaCaracteristicas(Function<CaracteristicaProduto,
			T> funcaoMapeadora) {		
		return this.caracteristicas.stream().map(funcaoMapeadora).collect(Collectors.toSet());
	}

	public <T> Set<T> mapeiaImagens(Function<ImagemProduto, T> funcaoMapeadora) {
		return this.imagens.stream().map(funcaoMapeadora).collect(Collectors.toSet());
	}

	public <T extends Comparable<T>> SortedSet<T> mapeiaPerguntas(Function<Pergunta, T> funcaoMapeadora) {
		// TODO Auto-generated method stub
		return this.perguntas
	.stream().map(funcaoMapeadora).collect(Collectors.toCollection(TreeSet :: new ));
	}

//	public Set<DetalheProdutoCaracteristica> mapCaracteristicas(Function<CaracteristicaProduto,
//			DetalheProdutoCaracteristica> funcaoMapeadora) {		
//		return this.caracteristicas.stream().map(funcaoMapeadora).collect(Collectors.toSet());
//	}

	

	
	

}
