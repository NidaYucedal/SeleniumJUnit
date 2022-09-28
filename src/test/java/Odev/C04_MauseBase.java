package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C04_MauseBase extends TestBaseBeforeAfter {

    //Yeni bir class olusturalim: MouseActions3
    //1- https://www.amazon.com/ adresine gidelim
    //2- Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin
    //mouse'u bu menunun ustune getirelim
    //3- "Create a list" butonuna basalim
    //4- Acilan sayfada "Your Lists" yazisi oldugunu test edelim

    @Test
    public void test() {

        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin
        //mouse'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement list = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(list).perform();

        //3- "Create a list" butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        //4- Acilan sayfada "Your Lists" yazisi oldugunu test edelim
        WebElement youtLists = driver.findElement(By.cssSelector("div[role='heading']"));
        Assert.assertTrue(youtLists.isDisplayed());


    }

}
