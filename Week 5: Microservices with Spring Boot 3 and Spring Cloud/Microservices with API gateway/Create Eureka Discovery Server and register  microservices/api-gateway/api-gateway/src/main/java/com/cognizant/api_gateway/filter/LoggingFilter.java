package com.cognizant.api_gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        logger.info("Global Pre Filter: Request path = {}", exchange.getRequest().getPath());

        return chain.filter(exchange).then(Mono.fromRunnable(() ->
            logger.info("Global Post Filter: Response status code = {}", exchange.getResponse().getStatusCode())
        ));
    }

    @Override
    public int getOrder() {
        return -1; // Highest precedence
    }
}
