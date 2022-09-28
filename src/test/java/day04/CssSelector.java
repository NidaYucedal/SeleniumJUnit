package day04;

public class CssSelector {

    //node[attribute_name = ‘attribute_value’]

    //node is the tag name of the HTML element, which needs to locate.
    //attribute_name is the name of the attribute which can locate the element.
    //attribute_value is the value of the attribute, which can locate the element.
    //You can write the tag name directly like “form”, “div”, “img”,”body”.xpath de tag name yerine // yazıyoruz
    //You can use tag[attribute=’value’] syntax.
    //You can use “Tag.Class”
    //You can use “Tag#Id”


    // WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
    //attribute adı name olan

    // driver.findElements(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']"));
    //div classının css i

    //driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
    //name attributin farklı bir yolu

    //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("username");
    //ibput yerine // de olur attribute olarak type aldım


    //driver.findElement(By.cssSelector("button[lang='fr']"));
    //inputu button aldık attribute name i lang olarak aldık

    //driver.findElement(By.cssSelector("#twotabsearchtextbox"));
    //id # koyarak locate edebiliriz

    //driver.findElement(By.cssSelector("input[id='sp-cc-accept']"));
    //attribute i id olan

    //driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));
    //class,classname için nokta(.) kullanırız

    // driver.findElement(By.cssSelector("a[href='windows/new']"));
    //a link tagı olarak aldık attribute ise href

    //driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
    //button tag adı attibute dı ise onclick
}
