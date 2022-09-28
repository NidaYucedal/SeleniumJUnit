package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {

   /*
Amazon sayfasina git
3 farkli test method'u olustur
- url'in "amazon" icergini test et
- title'in "facebook" icermedigini test et
- sol ust kosede amazon logosunun gorundugunu test et
 */

    // Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
    // BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
    // BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.


    //assertTrue
    //beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
    // Parametre olarak iki değer alır.
    // İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
    //assertFalse
    //beklenen bir sonucun false olması durumunda kullanılır.
    // İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
    // assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.
    //İki parametre alır, yani biri mesaj, diğeri ise iddianın uygulanması gereken koşuldur.
    // Yanlış iddiası yöntemine geçen koşul karşılanmazsa bir AssertionError atar.


    //assertNull
    //assert null, sağlanan nesnenin bir boş değer içerip içermediğini doğrulamak için kullanılır.
    // Parametre olarak bir nesneyi alır ve sağlanan nesne bir boş değer içermiyorsa bir AssertionError atar.

    //assertNotNull
    //assert not null, sağlanan bir nesnenin boş bir değer içermediğini doğrulamak için kullanılır.
    // Parametre olarak bir nesneyi alır ve sağlanan nesne bir boş değer içermiyorsa bir AssertionError atar.

    //assertSame
    //aynı yöntemi ileri sür,
    // parametreler olarak sağlanan iki nesnenin aynı nesneye atıfta bulunup bulunmadığını kontrol eder. Sağlanan nesneler sağlanan mesajla aynı nesneye başvurmuyorsa bir AssertionError atar.
    //Lütfen aynı Assert'in yalnızca nesnelerin referanslarını karşılaştırdığını,
    // ancak gerçek değerleri karşılaştırmadığını unutmayın.

    //assertNotSame
    //aynı olmadığını iddia etmek, iki nesnenin eşit olmadığını doğrular.
    // Aynı nesneye başvuran iki nesne varsa, bir AssertionError atılır.
    //Lütfen aynı olmayan yöntemin nesnelerin referanslarını karşılaştırdığını ve
    // nesnelerde bulunan değerleri karşılaştırmadığını unutmayın.


    //assertArrayEquals
    //assert equals, iki nesne dizisinin eşit olduğunu doğrular.
    // Her iki dizi de boş değerler içeriyorsa, eşit olarak kabul edilirler.
    // Bu yöntem, her iki nesne dizisi de eşit kabul edilmezse,
    // sağlanan mesajla birlikte bir AssertionError hatası atar.

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        //a-Url'nin facebook içerdiğini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //Assert.assertNotEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test2() {
        //b-Title'in facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test3() {
        //c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test4() {
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl, actualUrl);
    }
}


