package Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.crypto.KeyAgreementSpi;

public class C07_BaseActions extends TestBaseBeforeAfter {

    //Yeni bir class olusturalim: D15_MouseActions4
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

    @Test
    public void test(){

        driver.get("https://www.facebook.com");

        // Yeni hesap olustur butonuna basalim

        WebElement hesap=driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions=new Actions(driver);
        actions.keyDown(hesap,Keys.SHIFT).build().perform();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //TODO

        //4- Kaydol tusuna basalim
    }
}
