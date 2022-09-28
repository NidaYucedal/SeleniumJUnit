package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev01 {

    /*
    1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */


   static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){

        //driver.quit();
    }

    @Test
    public void test1(){
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void test2(){

        WebElement logo=driver.findElement(By.xpath("//*[@id='logo-icon']"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test3(){
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());


    }

    @Test
    public void test4(){
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle=driver.getTitle();
        String unexpected="youtube";
        Assert.assertNotEquals(unexpected,actualTitle);
    }
}
