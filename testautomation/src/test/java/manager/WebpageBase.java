package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WebpageBase {
  public WebDriver wd;

  public WebpageBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  protected void waitPageLoading(int timeToWait) throws InterruptedException {
    Thread.sleep(timeToWait);
  }

  public void compareNames() {
    String locator = "/html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div[2]/a";
    String nameOnPhoneList = getText(By.xpath(locator));
    click(By.xpath(locator));
    String nameOnPhonePage = getText(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div[1]/div[1]/div/h1"));
    Assert.assertEquals(nameOnPhonePage,nameOnPhoneList, "Names differs");
  }

  public void scrollPageDown() {
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scroll(0,document.body.scrollHeight)");
  }

  public void switchWindow() {
    Set<String> allHandles = wd.getWindowHandles();

    //count the handles Here count is=2
    //System.out.println("Count of windows:"+allHandles.size());

    //Get current handle or default handle
    //String currentWindowHandle = allHandles.iterator().next();
    //System.out.println("currentWindow Handle"+currentWindowHandle);

    //Remove first/default Handle
    allHandles.remove(allHandles.iterator().next());

    //get the last Window Handle
    String lastHandle = allHandles.iterator().next();
    //System.out.println("last window handle"+lastHandle);

    //switch to second/last window, because we know there are only two windows 1-parent window 2-other window(ad window)
    wd.switchTo().window(lastHandle);
    //System.out.println(wd.getTitle());
    //wd.findElement(By.tagName("body")).click();
  }

  public void writeFile(String timeLog, String browser, String searchSystem, String[] arrayOfText) throws IOException {        BufferedWriter writer = null;
    try {
      File logFile = new File(timeLog + "_" + browser + "_" + searchSystem + ".txt");

      writer = new BufferedWriter(new FileWriter(logFile));
      for(String str: arrayOfText) {
        writer.write(str + "\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        writer.close();
      } catch (Exception e) {
      }
    }
  }

  public String getText(By locator) {
    return wd.findElement(locator).getText();
  }
}
