package br.com.zup.orange.talents1.template.ecommerce.ecommerce.securityconfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private UserAutenticacao userAutenticacao;

    private static final String[] PUBLIC_MACHERS = {"/h2-console/**"};
    private static final String[] PUBLIC_MACHERS_GET = {"/usuario/**"};


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    //configuração de autorizaçao
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
//            http.headers().frameOptions().disable();
//        }
//
//        http.cors().and().csrf().disable();
//        http.authorizeRequests()
//                
//                .antMatchers(HttpMethod.POST, PUBLIC_MACHERS_GET).permitAll()
//                .antMatchers(PUBLIC_MACHERS).permitAll()
//                .anyRequest().authenticated();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//               // .and().httpBasic()
//                .and().formLogin();
    	
    	http
    		.authorizeRequests()
    		.antMatchers(PUBLIC_MACHERS).permitAll()
    		.antMatchers(PUBLIC_MACHERS_GET).permitAll()
    		.anyRequest().authenticated()
    		.and().formLogin();

    }
    //cofigurações de autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userAutenticacao)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSouce() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
    //cofiguração de recursos estaticos
    @Override
    public void configure(WebSecurity web) throws Exception {
    	// TODO Auto-generated method stub
    	super.configure(web);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

