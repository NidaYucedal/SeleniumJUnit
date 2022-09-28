package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseBeforeAfter;

public class Odev04 extends TestBaseBeforeAfter {

    /*
      1.Yeni bir class olusturalim (Homework)
2. facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
oldugunu dogrulayin (verify)
3.Sayfa'nin window handle degerini String bir degiskene atayin
4.Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin
5.yeni pencerede https://www.youtube.com/ sayfasina gidin.
6. Sayfa basliginin "youtube" icerdigini dogrulayin.
7.Ilk acilan sayfaya donun ve facebook sayfasina dondugunuzu test edin
8.sayfalari kapatin

         */

    @Test
    public void test(){

        driver.get("https://www.facebook.com/");

        String actualTitle=driver.getTitle();
        String title="Facebook";
        Assert.assertTrue(actualTitle.contains(title));

       String handle= driver.getWindowHandle();

        String actualUrl=driver.getCurrentUrl();
        String url="facebook";
        Assert.assertTrue(actualUrl.contains(url));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com/");

        String actualTitle2=driver.getTitle();
        String title2="youtube";
        Assert.assertTrue(actualTitle2.contains(title2));
        driver.switchTo().window(handle);

        Assert.assertTrue(driver.getTitle().contains("Facebook"));



    }

}
