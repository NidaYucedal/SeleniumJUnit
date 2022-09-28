package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev05 {

    WebDriver driver;
    /*
    1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
- https://www.facebook.com adresine gidin
- Cookies’i kabul edin
- “Create an Account” button’una basin
- “radio buttons” elementlerini locate edin
- Secili degilse cinsiyet butonundan size uygun olani secin
     */

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void method1(){

        driver.get("https://www.facebook.com");
        //“Create an Account” button’una basin
       WebElement open= driver.findElement(By.xpath("(//a[contains(text(),'Yeni Hesap Oluştur')])[1]"));
       open.click();



        //Radio butonun kullanımı CheckBox gibidir.
        // Yalnızca farkı tek seçenek seçmemiz gerektiği zamanlarda kullanılır.

        //- “radio buttons” elementlerini locate edin
       WebElement kadin= driver.findElement(By.xpath("//*[text()='Kadın']"));
       WebElement erkek= driver.findElement(By.xpath("//*[text()='Erkek']"));

        //- Secili degilse cinsiyet butonundan size uygun olani secin
        if (!kadin.isSelected()) {
            kadin.click();
        }





    }

}
