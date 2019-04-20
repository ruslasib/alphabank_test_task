package tests;

import org.testng.annotations.Test;

public class SearchBeatsHeadphoneTest extends TestBase {

  @Test
  public void testSearchBeatsHeadphone() throws InterruptedException{
    yandexManager.getYandexBase().clickMarket();
    yandexManager.getYandexBase().clickElectronics();
    yandexManager.getYandexBase().clickHeadphones();
    yandexManager.getYandexBase().chooseBrandCheckBox("Beats");
    yandexManager.getYandexBase().typePriceFrom("17000");
    yandexManager.getYandexBase().typePriceTo("25000");
    yandexManager.getYandexBase().compareNames();
  }
}
