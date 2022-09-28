package day15;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test() throws IOException {

        driver.get("https://hepsiburada.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
         */

        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/hepsiallPage.jpeg"));
       // FileUtils.copyFile(tumSayfaResmi, new File("target/screenShot/" + driver.getTitle() + "AllPage.jpeg"));


        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/AllPage" + tarih + ".jpeg"));


    }
}
