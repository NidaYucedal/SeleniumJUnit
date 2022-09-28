package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C10_GenelTekrar extends TestBaseBeforeAfter {

    /*
    -  amazon gidin
Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
dropdown menude 40 eleman olduğunu doğrulayın
Test02
dropdown menuden elektronik bölümü seçin
arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
sonuc sayisi bildiren yazinin iphone icerdigini test edin
ikinci ürüne relative locater kullanarak tıklayin
ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
Test03
yeni bir sekme açarak amazon anasayfaya gidin
dropdown’dan bebek bölümüne secin
bebek puset aratıp bulundan sonuç sayısını yazdırın
sonuç yazsının puset içerdiğini test edin
5-üçüncü ürüne relative locater kullanarak tıklayin
6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */

    @Test
    public void test1() {

        driver.get("https://amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //dropdown menude 40 eleman olduğunu doğrulayın
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w : drops) {
            System.out.println(w.getText());

        }

        int dropDownSize = drops.size();
        int expected = 40;
        Assert.assertNotEquals(expected, dropDownSize);


    }

    @Test
    public void test2() {

        driver.get("https://amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expected = "iphone";
        String actualResult = sonuc.getText();
        Assert.assertTrue(actualResult.contains(expected));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilk = driver.findElement(By.xpath("//*[@data-image-index='1']"));
        WebElement ucuncu = driver.findElement(By.xpath("//*[@data-image-index='3']"));
        WebElement ikinci = driver.findElement(RelativeLocator.with
                (By.xpath("//*[@data-image-index='2']")).toRightOf(ilk).toLeftOf(ucuncu));
        ikinci.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        //WebElement title = driver.findElement(By.id("productTitle"));
        //title.getText();
        //WebElement price = driver.findElement(By.xpath("//*[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        //price.getText();
        //driver.findElement(By.xpath("//*[@id='exportsUndeliverable-cart-announce']")).click();

        WebElement title = driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
        WebElement cartText = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertTrue(cartText.getText().contains("Added to Cart"));


    }

    @Test
    public void test3() {

        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");

        //dropdown'dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select2 = new Select(ddm);
        select2.selectByVisibleText("Baby");


        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby poussette", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuç sayısı= " + result.getText());

        //sonuç yazsının puset içerdiğini test edin
        String expectedResult = "poussette";
        Assert.assertTrue(result.getText().contains(expectedResult));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //WebElement ilk= driver.findElement(By.xpath("//*[@data-image-index='1']"));
        WebElement ikinci = driver.findElement(By.xpath("(//img[@class='s-image'])[3]"));
        WebElement dorduncu = driver.findElement(By.xpath("(//img[@class='s-image'])[5]"));
        WebElement ucuncu = driver.findElement(RelativeLocator.with(By.xpath("(//img[@class='s-image'])[4]"))
                .below(ikinci).above(dorduncu));
        ucuncu.click();


        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement title = driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));

        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();

        if (driver.findElement(By.xpath("(//span[@id='attach-warranty-displayTitle'])[1]")).isEnabled()) {

            driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")).click();
        }

        WebElement cartText = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertTrue(cartText.getText().contains("Added to Cart"));

        //sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        WebElement addCartButton = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(addCartButton).click().perform();

        WebElement cartText2 = driver.findElement(By.xpath("(//span[@class='a-truncate-full a-offscreen'])[1]"));
        WebElement cartPrice = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));

        if (title.equals(cartText2)) {

            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        if (price.equals(cartPrice)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAIL");
        }
    }
}
