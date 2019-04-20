package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class YandexBase {

  public WebDriver wd;
  public YandexBase(WebDriver wd) {
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

  private void waitPageLoading(int timeToWait) throws InterruptedException {
    Thread.sleep(timeToWait);
  }

  public void clickMarket() {
    click(By.xpath("//*[@data-id='market']"));
  }

  public void clickElectronics() {
    click(By.xpath("/html/body/div[1]/div/span/div[2]/noindex/div[2]/div/div/div[2]/a"));
  }

  public void clickMobilePhones() {
    click(By.xpath("/html/body/div[1]/div[2]/div[7]/div/div/div[1]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/a"));
  }

  public void chooseBrandCheckBox(String brand) throws InterruptedException{
    String locator = "//*[@data-autotest-id='7893318']/ul/li[.=\'" + brand + "\']/div/a/label/div";
    click(By.xpath(locator));
    waitPageLoading(2000);
  }

  public void typePriceFrom(String price) throws InterruptedException  {
    type(By.xpath("//*[@id=\"glpricefrom\"]"), price);
    waitPageLoading(2000);
  }

  public void typePriceTo(String price) throws InterruptedException {
    type(By.xpath("//*[@id=\"glpriceto\"]"),price);
    waitPageLoading(2000);
  }

  public void compareNames() {
    String locator = "/html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div[2]/a";
    String nameOnPhoneList = wd.findElement(By.xpath(locator)).getText();
    click(By.xpath(locator));
    String nameOnPhonePage = wd.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div[1]/div[1]/div/h1")).getText();
    Assert.assertEquals(nameOnPhonePage,nameOnPhoneList, "Names differs");
  }

  public void clickHeadphones() {
    click(By.xpath("/html/body/div[1]/div[2]/div[7]/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a"));
  }
}
