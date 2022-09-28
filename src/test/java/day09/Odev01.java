package day09;

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

public class Odev01 {

    //● Bir class olusturun: IframeTest02
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.guru99.com/test/guru99home/");



    }

    @After
    public void tearDown() {

        // driver.quit();
    }

    @Test
    public void test() {

        //sayfadaki iframe sayısını bulunuz.
        List<WebElement> frame= new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        System.out.println("Frame Size: "+frame.size());

        //ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(frame.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        driver.navigate().refresh();

        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("html/body/a/img")).click();
       // driver.findElement(By.xpath("//iframe[@id='a077aa5e']")).click();



    }
}
