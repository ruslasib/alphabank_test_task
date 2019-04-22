package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.concurrent.TimeUnit.SECONDS;

public class YandexManager {

  private String browser;
  private WebDriver wd;
  private YandexBase yandexBase;

  public YandexManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    definingBrowser();
    wd.manage().timeouts().implicitlyWait(5, SECONDS);
    wd.manage().window().maximize();
    wd.get("https://yandex.ru/");
    yandexBase = new YandexBase(wd);
  }

  public void stop() {
    wd.close();
  }

  private void definingBrowser() {
    if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      wd = new EdgeDriver();
    }
  }

  public YandexBase getYandexBase() {
    return yandexBase;
  }

  public String getTestStartTime() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    System.out.println(dateFormat.format(cal.getTime()));
    return dateFormat.format(cal.getTime());
  }

}
