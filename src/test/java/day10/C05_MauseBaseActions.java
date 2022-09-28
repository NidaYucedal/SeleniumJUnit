package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_MauseBaseActions extends TestBaseBeforeAfter {

    @Test
    public void test(){

        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        //dragAndDrop ( ): WebElement’i bir noktadan diğerine
        //sürükler ve bırakır
        WebElement dragMe=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropMe=driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.dragAndDrop(dragMe,dropMe).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());



    }
}
