package br.com.zup.orange.talents1.template.ecommerce.ecommerce.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

public class CategoriaRequest {
	
	@NotBlank
	private String nome;
	@Positive
	private Long idCategoriaMae;
	
	
	
	public String getNome() {
		return nome;
	}
	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdCategoriaMae(Long idCategoriaMae) {
		this.idCategoriaMae = idCategoriaMae;
	}
	@Override
	public String toString() {
		return "CategoriaRequest [nome=" + nome + ", idCategoriaMae=" + idCategoriaMae + "]";
	}
	public Categoria transformaParaObjeto(EntityManager manager) {
		Categoria categoria = new Categoria(nome);
		if (idCategoriaMae != null){
			Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
			System.out.println(categoriaMae);
			Assert.notNull(categoriaMae, "O id da categoria mãe prescisa ser válido");
			categoria.setCategoriaMae(categoriaMae);
		}
		return categoria;
	}
	
	

}
