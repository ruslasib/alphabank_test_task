package main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NumberArrangement {

  private File file;
  private FileReader fileReader;
  private int[] arrayOfNums;

  public int[] readFile(String name) throws IOException {
    file = new File(name);
    fileReader = new FileReader(file);
    StringBuilder stringBuilder = new StringBuilder();

    //read file symbol by symbol
    //create string
    int codeOfSymbol;
    String stringRaw = "";

    for (; ; ) {
      codeOfSymbol = fileReader.read();
      if (codeOfSymbol != -1) {
        stringBuilder.append((char) codeOfSymbol);
        stringRaw = stringBuilder.toString();
      }
      else {
        break;
      }
    }

    //transform strings into arrays of int, delete commas
    String[] arrayOfStringWithNums = stringRaw.split(",");
    arrayOfNums = new int[arrayOfStringWithNums.length];
    int count = 0;
    for (String str : arrayOfStringWithNums) {
      arrayOfNums[count] = Integer.parseInt(str);
      count++;
    }
    System.out.println();
    return arrayOfNums;
  }


  public void upArrangement(int[] arrayOfNums) {
    Arrays.sort(arrayOfNums);
    System.out.println("Numbers down-to-up: ");
    for (int i : arrayOfNums) {
      System.out.print(i + " ");
    }
  }

  public void downArrangement(int[] arrayOfNums) {
    Arrays.sort(arrayOfNums);
    System.out.println('\n' + "Numbers up-to-down: ");
    for (int i = arrayOfNums.length; i > 0; i--) {
      System.out.print(i + " ");
    }
  }

  public int[] getArrayOfNums(String name) throws IOException {
    readFile(name);
    return arrayOfNums;
  }
}