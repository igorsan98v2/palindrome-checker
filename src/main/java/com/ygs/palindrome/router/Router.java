package com.ygs.palindrome.router;

        import com.ygs.palindrome.handler.Handler;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.http.MediaType;
        import org.springframework.web.reactive.function.server.RequestPredicates;
        import org.springframework.web.reactive.function.server.RouterFunction;
        import org.springframework.web.reactive.function.server.RouterFunctions;
        import org.springframework.web.reactive.function.server.ServerResponse;

        import java.net.URI;

        import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
        import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> route(Handler handler) {

        return RouterFunctions
                .route(GET("/auth").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findPalindromes);
    }

    @Bean
    public RouterFunction<ServerResponse> findPalindromes(Handler handler) {

        return RouterFunctions
                .route(POST("/palindromes").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findPalindromes);
    }


    @Bean
    public RouterFunction<ServerResponse> redirect(Handler handler) {

        return RouterFunctions
                .route(GET("/").and(RequestPredicates.accept(MediaType.ALL)), handler::redirect);
    }

}

