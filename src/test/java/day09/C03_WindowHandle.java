package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {

    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım

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
        driver.get("https://www.amazon.com.tr/");
        String window=driver.getWindowHandle();
        driver.findElement(By.cssSelector("input[id='sp-cc-accept']")).click();

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl=driver.getCurrentUrl();
        String url="amazon";
        Assert.assertTrue(actualUrl.contains(url));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String best=driver.getWindowHandle();

        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle=driver.getTitle();
        String title="Best Buy";
        Assert.assertTrue(actualTitle.contains(title));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(window);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement java=driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));
        String arananKelime="Java";
        String actual=java.getText();
        Assert.assertTrue(actual.contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(best);

        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]")).isDisplayed());


        //) Icinde oldugumuz sayfanin window handle
        //degerini alma
        //driver.getWindowHandle()

        //2 ) Pencereler arasında geçiş yapma(switch)

        //3 ) Yeni tab olusturup geçiş yapma(switch)
        //driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().window(sayfa1HandleDegeri);
        //4 ) Yeni window olusturup geçiş yapma(switch)

        //driver.switchTo().newWindow(WindowType.WINDOW);


    }
}