package ee.uxp.training;

import java.util.UUID;

public class Person {

  private UUID id;
  private String first;
  private String last;

  public UUID getId() {
    return id;
  }

  public Person setId(UUID id) {
    this.id = id;

    return this;
  }

  public String getFirst() {
    return first;
  }

  public Person setFirst(String first) {
    this.first = first;

    return this;
  }

  public String getLast() {
    return last;
  }

  public Person setLast(String last) {
    this.last = last;

    return this;
  }
}
