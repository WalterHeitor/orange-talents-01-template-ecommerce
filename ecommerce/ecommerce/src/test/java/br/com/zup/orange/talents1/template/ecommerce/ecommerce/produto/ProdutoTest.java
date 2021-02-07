package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.categoria.Categoria;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.SenhaLimpa;
import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;

public class ProdutoTest {
	
	@DisplayName("Um produto prescisa no minimo de 3 caracteristicas")
	@ParameterizedTest
	@MethodSource("geradorTeste1")
	void teste1(Collection<NovaCaracteristicaReques> caracteristicas)
			throws Exception{
		Categoria categoria = new Categoria("categoria");
		Usuario dono = new Usuario("walter@email.com", new SenhaLimpa("senhaa"),LocalDate.now() );
		new Produto("nome", 10, "descricao", BigDecimal.TEN,
				categoria, dono, caracteristicas);
	}
	static Stream<Arguments> geradorTeste1(){
		return Stream.of(
				Arguments.of(
						List.of(
								new NovaCaracteristicaReques("Key", "descricao"),
								new NovaCaracteristicaReques("Key1", "descricao1"),
								new NovaCaracteristicaReques("Key2", "descricao2")
								)
						),
				Arguments.of(
						List.of(
								new NovaCaracteristicaReques("Key", "descricao"),
								new NovaCaracteristicaReques("Key1", "descricao1"),
								new NovaCaracteristicaReques("Key2", "descricao2"),
								new NovaCaracteristicaReques("Key3", "descricao3")
								)
						)
				);
		
	}
	@DisplayName("um produto nao pode ser criado com menos de 3 caracteristicas.")
	@ParameterizedTest
	@MethodSource("geradorTeste2")
	void teste2 (Collection<NovaCaracteristicaReques> caracteristicas)
			throws Exception{
		Categoria categoria = new Categoria("categoria");
		Usuario dono = new Usuario("walter@email.com", new SenhaLimpa("senhaa"),LocalDate.now() );
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Produto("nome", 10, "descricao", BigDecimal.TEN,
				categoria, dono, caracteristicas);
		});
	}
	static Stream<Arguments> geradorTeste2(){
		return Stream.of(
				Arguments.of(
						List.of(
								new NovaCaracteristicaReques("Key", "descricao"),
								new NovaCaracteristicaReques("Key1", "descricao1")
								)
						),
				Arguments.of(
						List.of(
								new NovaCaracteristicaReques("Key", "descricao")
								)
						)
				);
		
	}

}
