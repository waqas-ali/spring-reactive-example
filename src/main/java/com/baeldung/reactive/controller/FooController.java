package com.baeldung.reactive.controller;

import java.time.Duration;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baeldung.reactive.model.Foo;
import reactor.core.publisher.Flux;

@RestController
public class FooController {

  private static final int DELAY_PER_ITEM_MS = 1000;
  
  @GetMapping(value = "/foo-resource",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Foo> getFoo() { 
    Stream<Foo> stream = Stream.iterate(new Foo(1,"foo"),Foo::get);
    Flux<Foo> flux = Flux.fromStream(stream).delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS));
    return flux;
  }
}
