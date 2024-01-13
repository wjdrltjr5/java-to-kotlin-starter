package com.lannstark.lec12;

public class Lec12Main {

  public static void main(String[] args) {
    // Person.Factory.newBaby("ABC");
    Lec12Main main = new Lec12Main();
    main.movavleTest(new Movable() {
      @Override
      public void move() {

      }

      @Override
      public void fly() {

      }
    });
  }
  public void movavleTest(Movable movable){
    movable.fly();
    movable.move();
  }
}
