package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    /*
    BeforeClass ve AfterClass notasyonlari kullaniyorsak olusturacagımız methodu static yapmamiz gerekiyor
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void afterClass(){
        driver.close();

    }

    @Test
    @Ignore ("bunu atla")
    public void method1(){
        driver.get("https://amazon.com");
    }

    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }

    @Test
    public void method3(){
        driver.get("https://hepsiburada.com");
    }
}
