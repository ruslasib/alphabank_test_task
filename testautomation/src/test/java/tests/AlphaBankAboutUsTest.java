package tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class AlphaBankAboutUsTest extends TestBase {

  @Test
  public void testAlphaBankAboutUs() throws IOException {
    yandexManager.getYandexBase().enterSearchRequest("альфа банк");
    yandexManager.getYandexBase().findLinkToAlphabank("https://alfabank.ru/");
    yandexManager.getYandexBase().switchWindow();
    yandexManager.getYandexBase().scrollPageDown();
    yandexManager.getYandexBase().clickJobButton();
    yandexManager.getYandexBase().writeAboutUsText("Testfile.txt");
  }
}
