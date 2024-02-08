package org.cloud.sample.Filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
/**
 * global filter for all services
 * @author ryan
 * */
@Component
public class GlobalAuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // excluded paths
        String path = request.getPath().toString();
        if(path.equals("/auth/login")){
            return chain.filter(exchange);
        }
        // get my_token from cookie
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        List<HttpCookie> cookie = cookies.get("my_token");
        if(cookie == null || cookie.isEmpty()){
            return handleError(exchange);
        }
        return chain.filter(exchange);
    }
    /**
     * GPT is amazing, lol
     * */
    private Mono<Void> handleError(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);  // Set your desired HTTP status code
        response.getHeaders().add("Content-Type", "application/json");

        // You can customize the error response body here
        String responseBody = "{" +
                "\"error\": \"pls login\"" +
                "\"url\": \"localhost:8080/auth/login\"" +
                "}";

        // Write the error response to the response body
        return response.writeWith(Mono.just(response.bufferFactory().wrap(responseBody.getBytes())));
    }
}
