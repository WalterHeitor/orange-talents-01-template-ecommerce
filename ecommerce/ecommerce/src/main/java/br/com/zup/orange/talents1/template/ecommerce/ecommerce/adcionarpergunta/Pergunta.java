package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
@Entity
public class Pergunta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	@ManyToOne
	private @NotNull @Valid Usuario interessada;
	@ManyToOne
	private @NotNull @Valid Produto produto;
	
	private LocalDate intante;
	
	@Deprecated
	public Pergunta() {	}

	public Pergunta(@NotBlank String titulo, @NotNull @Valid Usuario interessada,
			@NotNull @Valid Produto produto) {
				this.titulo = titulo;
				this.interessada = interessada;
				this.produto = produto;
				this.intante = LocalDate.now();
		
	}
	

	@Override
	public String toString() {
		return "Pergunta [id=" + id + ", titulo=" + titulo + ", interessada=" + interessada + ", produto=" + produto
				+ "]";
	}

	public Usuario getPerguntador() {
		return interessada;
	}

	public Usuario getDonoProduto() {
		// TODO Auto-generated method stub
		return produto.getUsuarioLogado();
	}
	

}
