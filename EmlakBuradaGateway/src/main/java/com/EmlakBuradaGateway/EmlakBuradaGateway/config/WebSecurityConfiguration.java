package com.EmlakBuradaGateway.EmlakBuradaGateway.config;

import com.EmlakBuradaGateway.EmlakBuradaGateway.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.ServerCsrfTokenRepository;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfiguration {



	/*@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {


		//// @formatter:off
		http
		.httpBasic().disable()
		.formLogin().disable()

		.authorizeExchange()
		.pathMatchers(HttpMethod.GET, "/adverts/**")
		.permitAll()
		.pathMatchers(HttpMethod.POST, "/enrollees/**")
		.permitAll()
		.pathMatchers(HttpMethod.POST, "/auths")
		.permitAll()
		.and()
		.csrf().disable()
		.authorizeExchange()
		.anyExchange()
		.authenticated();

		return http.build();
		// @formatter:on

	}*/

	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		//// @formatter:off
		http
				.httpBasic().disable()
				.formLogin().disable()
				.csrf().disable();

		return http.build();
		// @formatter:on

	}

    @Autowired
    private JwtFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                //// @formatter:off


                .route("auth",
                        r -> r.path("/auths/**")
                                .uri("http://localhost:8082"))
                .route("EmlakBurada-for-hepsiemlak",
                        r -> r.method(HttpMethod.POST)
                                .and()
                                .path(("/adverts/**"))
                                .filters(f -> f.filter(filter)).uri("http://localhost:8097"))
                .route("EmlakBurada-for-hepsiemlak",
                        r -> r.method(HttpMethod.GET)
                                .and()
                                .path("/enrollees/**")
                                .filters(f -> f.filter(filter)).uri("http://localhost:8097"))
				.route("EmlakBurada-for-hepsiemlak",
						r -> r.method(HttpMethod.GET)
								.and()
								.path("/enrolleeName/**")
								.filters(f -> f.filter(filter)).uri("http://localhost:8097"))
				/*.route("EmlakBurada-for-hepsiemlak",
						r -> r.method(HttpMethod.POST)
								.and()
								.path("/enrollees/**")
								.filters(f -> f.filter(filter)).uri("http://localhost:8097"))*/
                .route("EmlakBurada-for-hepsiemlak",
                        r -> r.method(HttpMethod.POST)
                                .and()
                                .path(("/advertPockets/**"))
                                .filters(f -> f.filter(filter)).uri("http://localhost:8097"))
                .route("EmlakBurada-for-hepsiemlak",
                        r -> r.method(HttpMethod.POST)
                                .and()
                                .path(("/messages/**"))
                                .filters(f -> f.filter(filter)).uri("http://localhost:8097"))
                .route("EmlakBuradaPaymentSystem",
                        r -> r.path("/payments/**")
                                .filters(f -> f.filter(filter)).uri("http://localhost:8091"))
                .build();

        // @formatter:on
    }

}