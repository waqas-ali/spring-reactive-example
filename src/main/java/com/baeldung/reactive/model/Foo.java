package com.baeldung.reactive.model;

import java.util.function.Supplier;

public class Foo implements Supplier<Foo> {
  private int id;
  private String name;
  
  public Foo(int id, String name) {
    this.id = id;
    this.name = name;
  }
  public Foo() {
    
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return id + "-" + name;
  }
  @Override
  public Foo get() {
    return new Foo(this.id + 1,this.name);
  }
  
}
