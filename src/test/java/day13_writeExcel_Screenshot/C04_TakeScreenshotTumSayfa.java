package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeScreenshotTumSayfa extends TestBase {

    @Test
    public void test01(){

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        // anasayfaya gittginizi test edin
        String expectedURL="wisequarter";
        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
        ReusableMethods.tumSayfaScreenshotCek(driver);
        // tum sayfa SS alin


    }
}
