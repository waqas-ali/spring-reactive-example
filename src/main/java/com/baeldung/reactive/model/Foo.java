package com.baeldung.reactive.model;

public class Foo {
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
  
}
