package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionaopniaoproduto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;

public class NovaOpniaoRequest {

	@Min(1)
	@Max(5)
	private int nota;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max=500)
	private String descricao;
	public NovaOpniaoRequest(@Min(1) @Max(5) int nota, @NotBlank String titulo,
			@NotBlank @Size(max = 500) String descricao) {
		super();
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	public Opniao toModel(@NotNull @Valid Produto produto,@NotNull @Valid Usuario consumidor) {
		// TODO Auto-generated method stub
		return new Opniao(nota, titulo, descricao, produto , consumidor);
	}
	
}
