package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProdutoRequestTest {

	@DisplayName("Cria um produto com diversos tipos de caracteristicas")
	@ParameterizedTest
	@MethodSource("gerador")
	void teste1(int esperado, List<NovaCaracteristicaReques> novasCaracteristicas)
			throws Exception{
		ProdutoRequest request = new ProdutoRequest("nome", 10, "descricao", BigDecimal.TEN, 1L, novasCaracteristicas);
		Assertions.assertEquals(esperado, request.buscarCaracteristicasIguais().size());
	}
	private static Stream<Arguments> gerador(){
		return Stream.of(
				Arguments.of(0, List.of()),
				Arguments.of(0, List.of(new NovaCaracteristicaReques("key", "descricao"))),
				Arguments.of(0, List.of(
						new NovaCaracteristicaReques("key", "descricao"), 
						new NovaCaracteristicaReques("key1", "descricao1"))),
				Arguments.of(1, List.of(
						new NovaCaracteristicaReques("key", "descricao"), 
						new NovaCaracteristicaReques("key", "descricao")))
				);
	}

}
