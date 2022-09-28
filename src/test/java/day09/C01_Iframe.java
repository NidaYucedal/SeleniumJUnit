package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */

public class C01_Iframe {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");


    }

    @After
    public void tearDown() {

        //driver.quit();
    }

    @Test
    public void test() {

        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement ifrmae = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(ifrmae.isDisplayed());
        System.out.println(ifrmae.getText());

        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(textBox);
        WebElement hello = driver.findElement(By.xpath("//p"));
        hello.clear();
        hello.sendKeys("Hello World!");
        driver.switchTo().defaultContent();

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin
        WebElement elemental = driver.findElement(By.xpath("//*[normalize-space()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());


    }
}


