package com.task8.utils.part2.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeCallable implements Callable<List<Integer>> {
  private final int firstEntrance;
  private final int lastEntrance;
  private final List<Integer> resultList;

  public PrimeCallable(int firstEntrance, int lastEntrance) {
    if (lastEntrance < firstEntrance) {
      throw new IllegalArgumentException("First entrance should be >= than last entrance");
    }
    if (firstEntrance < 0) {
      throw new IllegalArgumentException("Entrances should be > 0");
    }
    this.firstEntrance = firstEntrance;
    this.lastEntrance = lastEntrance;
    resultList = new ArrayList<>();
  }


  private void primeCheck(int numberToCheck) {
    for (int checker = numberToCheck - 1; checker >= 2; checker--) {
      if (numberToCheck % checker == 0) {
        return;
      }
    }
    resultList.add(numberToCheck);
  }

  @Override
  public List<Integer> call() throws Exception {
    for (int i = firstEntrance; i <= lastEntrance; i++) {
      primeCheck(i);
    }

    return resultList;
  }
}
