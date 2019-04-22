package manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Draft1 {
  public static void main(String[] args) {
    File file = new File("success.txt");
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
      writer.write("Some text.");
    }
    catch(IOException e) {
      e.getStackTrace();
    }
  }
}
