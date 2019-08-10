package com.ygs.palindrome.handler;

import com.ygs.palindrome.PalindromeRange;
import com.ygs.palindrome.pojo.PalindromeCollection;
import com.ygs.palindrome.pojo.Request;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;


@Component
public class Handler {
    public Mono<ServerResponse> findPalindromes(ServerRequest request) {
        final  Mono<Request>req = request.bodyToMono(Request.class);
        /*@TODO update message size*/
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(req.map(toPalReq-> {
                    PalindromeRange range = new PalindromeRange(toPalReq.getNumber(),toPalReq.getPalindromeNum());
                    ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList(range.getPalindromes()));
                    return

                            new PalindromeCollection(toPalReq.getNumber(),arrayList);
                    }), PalindromeCollection.class));
    }
    public Mono<ServerResponse>redirect(ServerRequest request){
        return ServerResponse.temporaryRedirect(URI.create("/index.html"))
                            .build();

    }
}
