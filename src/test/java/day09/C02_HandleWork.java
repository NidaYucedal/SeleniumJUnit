package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWork {

    //● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @After
    public void tearDown(){

        //driver.quit();

    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com.tr/");


        //Sayfa’nin window handle degerini String bir degiskene atayin
        String handle=driver.getWindowHandle();
        driver.findElement(By.cssSelector("input[id='sp-cc-accept']")).click();


        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle= driver.getTitle();
        String title="Amazon";
        Assert.assertTrue(actualTitle.contains(title));


        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actTitle=driver.getTitle();
        String tit="TECHPROEDUCATION";
        Assert.assertFalse(actTitle.contains(tit));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");



        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        driver.navigate().refresh();

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(handle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));

        driver.quit();


    }
}
