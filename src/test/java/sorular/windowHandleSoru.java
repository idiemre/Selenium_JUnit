package sorular;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class windowHandleSoru extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaWHD= driver.getWindowHandle();
        // 2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN).perform();

        Thread.sleep(1700);
        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        // 4.Diger window'a gecin
        Set<String> listeWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:listeWHD
             ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }

        }
        driver.switchTo().window(ikinciSayfaWHD);
        // 5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("idiemre");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Papatya1");
        Thread.sleep(1700);
        // 6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualValidationYazi=driver.switchTo().alert().getText();
        Thread.sleep(1700);
        String expectedValidationYazi="validation failed";
        Assert.assertEquals(expectedValidationYazi,actualValidationYazi);
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWHD);
        // 10.Ilk sayfaya donuldugunu test edin
        WebElement ilkSayfaTestiElementi=driver.findElement(By.xpath("//a[@id='nav-title']"));
        Assert.assertTrue(ilkSayfaTestiElementi.isDisplayed());
    }
}
