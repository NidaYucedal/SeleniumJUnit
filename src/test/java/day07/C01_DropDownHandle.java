package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropDownHandle {

    /*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin

        List<WebElement> drops =driver.findElements(By.xpath("//*[@class='hm-icon nav-sprite']"));
        System.out.println(drops.size());
        for (WebElement w:drops){
            System.out.println(w.getText());
        }

        int dropDown=drops.size();
        int sayi=45;
        Assert.assertNotEquals(sayi,dropDown);



    }

    @Test
    public void test2() {

        //Kategori menusunden Books seceneginisecin
        driver.findElement(By.cssSelector("#searchDropdownBox")).click();
        driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();

        //2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisiniyazdirin
        WebElement results=driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
        String get=results.getText();
        String [] sonuc=get.split(" ");
        System.out.println(sonuc[3]);

        //4.Sonucun Java kelimesini icerdigini testedin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).isDisplayed());


    }
}
