package br.com.zup.orange.talents1.template.ecommerce.ecommerce.adcionarpergunta;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto.Produto;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;

public class PerguntaRequest {

	@NotBlank
	private String titulo;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
//	public PerguntaRequest(@NotBlank String titulo) {
//		this.titulo = titulo;
//	}


	public Pergunta toModel(@NotNull @Valid Usuario interessada,
			@NotNull @Valid Produto produto) {
		
		return new Pergunta(titulo, interessada, produto);
	}
	@Override
	public String toString() {
		return "PerguntaRequest [titulo=" + titulo + "]";
	}
	
}
