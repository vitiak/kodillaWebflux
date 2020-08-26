package com.kodilla.kodillawebflux.controller;

import com.kodilla.kodillawebflux.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/book")
    public Flux<String> getBook(Book book) {
        return Flux
                .just(book.getAuthor(), " ", book.getTitle(), " ", String.valueOf(book.getYear()))
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

}
