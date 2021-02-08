package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionaopniaoproduto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
@Entity
public class Opniao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @Min(1) @Max(5) int nota;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String descricao;
	@ManyToOne
	private @NotNull @Valid Produto produto;
	@ManyToOne
	private @NotNull @Valid Usuario consumidor;

	public Opniao(@Min(1) @Max(5) int nota, @NotBlank String titulo, @NotBlank @Size(max = 500) String descricao,
			@NotNull @Valid Produto produto, @NotNull @Valid Usuario consumidor) {
				this.nota = nota;
				this.titulo = titulo;
				this.descricao = descricao;
				this.produto = produto;
				this.consumidor = consumidor;
	}

	@Override
	public String toString() {
		return "Opniao [id=" + id + ", nota=" + nota + ", titulo=" + titulo + ", descricao=" + descricao + ", produto="
				+ produto + ", consumidor=" + consumidor + "]";
	}


}
