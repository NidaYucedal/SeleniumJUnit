package Odev02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;


public class C01_JSExecutor extends TestBaseBeforeAfter {

    Select select;
    //Yeni bir class olusturun : ScroolInto
    //2- hotelmycamp anasayfasina gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve
    //Js Executor kullanarak asagidaki oda turlerinden
    //ust sira ortadaki odayi tiklayin
    //4- istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void scroolInto() throws InterruptedException {


        driver.get("https://hotelmycamp.com");
        //2 farkli test method’u olusturarak actions classi ve Js Executor
        // kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        // actions ile->

        WebElement roomType = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        actions.scrollToElement(roomType).perform();
        Thread.sleep(2000);
        actions.moveToElement(roomType).click().perform();
        Thread.sleep(2000);
        WebElement roomAvailability = driver.findElement(By.xpath("//h4"));
        String expectedText = "Available Room";
        Assert.assertEquals(expectedText, roomAvailability.getText());

        // js ile
        WebElement room = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", room);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", room);
        Thread.sleep(2000);
        WebElement roomV = driver.findElement(By.xpath("//h4"));
        String expected = "Available Room";
        Assert.assertEquals(expected, roomV.getText());
    }
}
