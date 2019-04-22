package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class YandexBase extends WebpageBase {

  public YandexBase(WebDriver wd) {
    super(wd);
  }

  public void clickMarket() {
    click(By.xpath("//*[@data-id='market']"));
  }

  public void clickElectronics() {
    click(By.xpath("//a[@href='/catalog--elektronika/54440']"));
  }

  public void clickMobilePhones() {
    click(By.xpath("//a[.='Мобильные телефоны']"));
  }

  public void chooseBrandCheckBox(String brand) throws InterruptedException {
    String locator = "//*[@data-autotest-id='7893318']/ul/li[.=\'" + brand + "\']/div/a/label/div";
    click(By.xpath(locator));
    waitPageLoading(2000);
  }

  public void typePriceFrom(String price) throws InterruptedException {
    type(By.xpath("//*[@id=\"glpricefrom\"]"), price);
    waitPageLoading(2000);
  }

  public void typePriceTo(String price) throws InterruptedException {
    type(By.xpath("//*[@id=\"glpriceto\"]"), price);
    waitPageLoading(2000);
  }

  public void clickHeadphones() {
    click(By.xpath("//a[.='Наушники и Bluetooth-гарнитуры']"));
  }

  public void enterSearchRequest(String searchRequest) {
    type(By.xpath("//*[@id='text']"), searchRequest);
    clickFindButton();
  }

  public void clickFindButton() {
    click(By.xpath("//*[contains(concat(' ',@class,' '),' search2__button ')]"));
  }

  //Next code below is for AlphaBank web site, not for yandex
  public void findLinkToAlphabank(String url) {
    click(By.xpath("//a[@href='" + url + "']"));
  }

  public void clickJobButton() {
    click(By.xpath("//a[@href='http://job.alfabank.ru/']"));
  }

  public void writeAboutUsText(String name) throws IOException {
    FileWriter file = new FileWriter(name, true);
    writeTextIntoFile(file, By.tagName("h3"));
    writeTextIntoFile(file, By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/p[1]"));
    writeTextIntoFile(file, By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/p[2]"));
    writeTextIntoFile(file, By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/p[3]"));
  }
}
