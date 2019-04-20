package main.java;

import java.io.IOException;

public class NumberArrangementLauncher {

  public static void main(String[] args) throws IOException {

    NumberArrangement numberArrangement = new NumberArrangement();
    int[] arrayOfNums = numberArrangement.getArrayOfNums("files/Numbers.txt");
    numberArrangement.upArrangement(arrayOfNums);
    numberArrangement.downArrangement(arrayOfNums);
  }
}
