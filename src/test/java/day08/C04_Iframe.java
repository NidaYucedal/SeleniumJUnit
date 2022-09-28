package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

public class C04_Iframe {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @After
    public void tearDown() {

        //driver.quit();
    }

    @Test
    public void test() {

        driver.get("https://html.com/tags/iframe/");

        //1 ) index ile :
        //driver.switchTo( ).frame(index of the iframe); //index 0’dan baslar

        //2 ) id veya name value ile
        //driver.switchTo( ).frame("id of the iframe");

        //3 ) WebElement ile
        //driver.switchTo( ).frame(WebElement of the iframe);
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();



    }
}
