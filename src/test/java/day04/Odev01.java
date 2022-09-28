package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Odev01 {


    WebDriver driver;
        /*
1-C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4-Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
6-Bulunan sonuc sayisini yazdirin
7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8-Sayfayi kapatin

         */
    @Before
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void method1(){

        driver.get("https://www.google.com/");

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
       String actualTitle= driver.getTitle();
       String title="Google";
       String result=actualTitle.contains(title)? "Passed" : driver.getTitle();
        System.out.println("page title: "+result);

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Nutella", Keys.ENTER);

        WebElement results=driver.findElement(By.id("result-stats"));
        String get=results.getText();
        String [] sonuc=get.split(" ");
        //System.out.println(sonuc[1]);
        //limit(2) ilk 2 sonucu,yazıyı al yani şu kadarını göster
        //skip(1) birini atla digerini getir

        Arrays.stream(sonuc).limit(2).skip(1).forEach(System.out::println);

       // sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int sonucInt = Integer.parseInt(sonuc[1].replaceAll("\\D", ""));
        System.out.println(sonucInt);

        if (sonucInt > 10000000) System.out.println("PASSED");
        else System.out.println("FAIL");



    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
