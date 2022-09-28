package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_KeyBaseActions extends TestBaseBeforeAfter {


    //sendKeys ( ): Öğeye bir dizi anahtar gönderir
    //■ keyDown ( ): Klavyede tuşa basma işlemi gerçekleştirir
    //■ keyUp ( ): Klavyede tuşu serbest bırakma işlemi gerçekleştirir

    //Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method'larine kullanarak
    //samsung A71 yazdirin ve Enter'a basarak arama
    //yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test() {

        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method'larine kullanarak
        //samsung A71 yazdirin ve Enter'a basarak arama yaptirin
        WebElement box=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        //actions.moveToElement(box).click();
       // actions.sendKeys("samsung A71").build().perform();
       // WebElement click=driver.findElement(By.cssSelector("#nav-search-submit-button"));
        //actions.keyDown(click,Keys.ENTER).build().perform();
        actions.click(box).sendKeys("samsung A71").sendKeys(Keys.ENTER).perform();

        //4- aramanin gerceklestigini test edin
        Assert.assertTrue(driver.findElement(By.cssSelector(".a-color-state.a-text-bold")).isDisplayed());


    }
}
