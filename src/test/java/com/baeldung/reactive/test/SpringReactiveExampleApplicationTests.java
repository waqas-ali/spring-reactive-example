package com.baeldung.reactive.test;

import java.time.Duration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import com.baeldung.reactive.app.SpringReactiveExampleApplication;
import com.baeldung.reactive.model.Foo;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringReactiveExampleApplication.class},
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringReactiveExampleApplicationTests {

  @Autowired
  ApplicationContext context;

  @LocalServerPort
  private int serverPort;

  private WebClient webClient;

  @Before
  public void setUp() {
    this.webClient = WebClient.create("http://localhost:" + serverPort);
    
  }

  @Test
  public void simpleGetRequest() {

    Flux<Foo> receivedFlux = webClient.get().uri("/foo-resource").accept(MediaType.TEXT_EVENT_STREAM).exchange()
        .flatMapMany(response -> response.bodyToFlux(Foo.class));


    StepVerifier.create(receivedFlux).expectNext(new Foo(1, "foo"))
        //.expectNoEvent(Duration.ofMillis(999))
        .expectNext(new Foo(2, "foo"))
        .expectNoEvent(Duration.ofMillis(999))
        .expectNext(new Foo(3, "foo"))
        .expectNoEvent(Duration.ofMillis(999))
        .expectNext(new Foo(4, "foo"))
        .expectComplete().verify();

  }
}
