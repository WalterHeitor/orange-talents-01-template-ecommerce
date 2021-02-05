package br.com.zup.orange.talents1.template.ecommerce.ecommerce.autenticacao;

public class TokenResponse {

	private String tipo;
	private String token;

	public TokenResponse(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}

	public String getToken() {
		return token;
	}
	

}
