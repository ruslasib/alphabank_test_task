package tests;

import manager.YandexManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  private String browser = BrowserType.CHROME;
  protected final YandexManager yandexManager = new YandexManager(browser);

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
