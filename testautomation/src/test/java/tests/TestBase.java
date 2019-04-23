package tests;

import manager.YandexManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBase {

  private String browser = BrowserType.CHROME;
  private String searchSystem = "yandex";
  private String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
  protected final YandexManager yandexManager = new YandexManager(timeLog, browser, searchSystem);

  @BeforeMethod
  public void setUp() {
    yandexManager.getTestStartTime();
    yandexManager.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    yandexManager.stop();
  }
}
