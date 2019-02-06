package com.joe.testStubs;

import java.util.Random;

public class ClassToTest {
  
  DependencyClass dependentClass = new DependencyClass();

  
  public String alterNumberAndCaptureNumber() {
    //we generate some random data
    Random rand = new Random();
    int value = rand.nextInt(50);
    dependentClass.parseInt(value);
    return String.valueOf(value);
  }

}
