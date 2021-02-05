package br.com.zup.orange.talents1.template.ecommerce.ecommerce.securityconfig;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.zup.orange.talents1.template.ecommerce.ecommerce.usuario.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class TokenService {
	
	@Value("${ecommerce.jwt.expiration}")
	String espiration;
	@Value("${ecommerce.jwt.secret}")
	String secret;

	public String gerarToken(Authentication authenticate) {
		Usuario logado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date expiracao = new Date(hoje.getTime() + Long.parseLong(espiration));
		return Jwts.builder()
				.setIssuer("API Ecommerce")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(hoje)
				.setExpiration(expiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isvalido(String token) {
		try {
			Jwts
			.parser()
			.setSigningKey(this.secret)
			.parseClaimsJws(token);
		return true;
		} catch (Exception e) {
			return false;			
		}
			
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts
		.parser()
		.setSigningKey(this.secret)
		.parseClaimsJws(token)
		.getBody();
		return Long.parseLong(claims.getSubject());
	}

}
