package tests;

import org.testng.annotations.Test;

public class SearchSamsungPhoneTest extends TestBase {

  @Test
  public void testSearchSamsungPhone() throws InterruptedException {
    yandexManager.getYandexBase().clickMarket();
    yandexManager.getYandexBase().clickElectronics();
    yandexManager.getYandexBase().clickMobilePhones();
    yandexManager.getYandexBase().chooseBrandCheckBox("Samsung");
    yandexManager.getYandexBase().typePriceFrom("40000");
    yandexManager.getYandexBase().compareNames();
  }
}
