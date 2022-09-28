package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */

        driver.get("https://www.amazon.com/");

        List<WebElement> urunListesi = driver.findElements(By.cssSelector("div[class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String[] arr = urunListesi.get(0).getText().split(" ");
        System.out.println(arr[2]);

        //5- Ilk urunu tiklayalim

        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();


        //6- Sayfadaki tum basliklari yazdiralim

        List<WebElement> headers = driver.findElements(By.xpath("//h1"));
        headers.stream().map(WebElement::getText).forEach(System.out::println);


    }
}
