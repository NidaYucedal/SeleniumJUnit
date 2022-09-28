package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C04_MauseBase extends TestBaseBeforeAfter {

    @Test
    public void test() {

        //Yeni bir class olusturalim: MouseActions1
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        // 3- Cizili alan uzerinde sag click yapalim
        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        //Tamam diyerek alert’i kapatalim
        //Elemental Selenium linkine tiklayalim
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim


        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement alan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(alan).perform();

        String alert = driver.switchTo().alert().getText();
        String ex = "You selected a context menu";
        Assert.assertTrue(alert.contains(ex));

        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("a[target='_blank']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

    }
}
