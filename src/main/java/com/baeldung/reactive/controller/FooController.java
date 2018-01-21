package com.baeldung.reactive.controller;

import java.time.Duration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baeldung.reactive.model.Foo;
import reactor.core.publisher.Flux;

@RestController
public class FooController {

  private static final int DELAY_PER_ITEM_MS = 1000;
  
  @GetMapping("/foo-resource")
  public Flux<Foo> getFoo() {
    Foo[] array = getFooArray();
    
    Flux<Foo> flux = Flux.fromArray(array).delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS)).take(1);
    return flux;
  }
  private Foo[] getFooArray() {
    Foo[] array = new Foo[100];
    for ( int i =0; i< array.length; i++) {
      Foo foo = new Foo(i+1, "foo");
      array[i] = foo;
    }
    return array;
  }
}
