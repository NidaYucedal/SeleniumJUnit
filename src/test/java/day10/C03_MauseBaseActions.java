package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_MauseBaseActions extends TestBaseBeforeAfter {

    //doubleClick ( ): WebElement’e çift tıklama yapar

    //➢ clickAndHold ( ): WebElement uzerinde click yapili
    //olarak bizden komut bekler.

    //➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine
    //sürükler ve bırakır

    //➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in
    //uzerinde tutar

    //➢ contextClick ( ): Mouse ile istedigimiz WebElement’e
    //sag tiklama yapar.


    @Test
    public void test(){

        driver.get("https://www.amazon.com");
        Actions action=new Actions(driver);
        WebElement accountLink=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        action.moveToElement(accountLink).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();



    }
}
