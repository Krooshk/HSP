package MyCalculator;

import MyOperation.Summ;

public class Calculator {
  public static int sum(int a, int b) {
    return Summ.sum(a, b);
  }

  public static int diff(int a, int b) {
    return a - b;
  }
}