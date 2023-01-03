package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01(){

        // amazon'a gidin
        driver.get("https://www.amazon.com/");

        //amazona gitiginizi teest edin
        String expectedKelime="amazon";
        String actualurl= driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains(expectedKelime));

        ReusableMethods.bekle(3);
    }
}
