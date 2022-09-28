package day10;

import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_IlkTestBaseBeforeClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
    }
}
