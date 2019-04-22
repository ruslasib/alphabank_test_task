package manager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class Draft {

  //WebDriver wd = new ChromeDriver();

  @Ignore
  @Test
  public void scroll() {
    scrollTest();
  }

  public void scrollTest() {
    //wd.get("https://alfabank.ru/");

    //JavascriptExecutor jse = (JavascriptExecutor) wd;
    //jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }

  @Test
  public void writeFile() {
    try {
      FileWriter fileWriter = new FileWriter("123.txt", true);
      fileWriter.write("John, ");
      fileWriter.write("YO!");
    }
    catch (IOException e) {
      e.getStackTrace();
    }
  }
}
