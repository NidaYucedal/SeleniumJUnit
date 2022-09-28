package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev02 {

    /*
    1. Bir Class olusturalim YanlisEmailTesti
2. http://automationpractice.com/index.php sayfasina gidelim
3. Sign in butonuna basalim
4. Email kutusuna @isareti olmayan bir mail yazip enter’a
bastigimizda “Invalid email address” uyarisi ciktigini test edelim

     */

    WebDriver driver;

    @After

    public void tearDown() {
        //driver.close();
    }

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1() {
        driver.get(" http://automationpractice.com/index.php");

        //3.Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class ='login']")).click();
    }
    @Test
    public void test1(){
        // 4.Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("wefgrht", Keys.ENTER);
    }
    @Test
    public void test2(){
        // bastigimizda “Invalid email address” uyarisi ciktigini testedelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }
}