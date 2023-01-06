package sorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class iframeSoru extends TestBase {



    @Test
    public void test01() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement iframe=driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        //2. “Our Products” butonuna basin
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3. “Cameras product”i tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        //4. Popup mesajini yazdirin
       String popUpYazisi=driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();
        System.out.println(popUpYazisi);
        //5. “close” butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Close']")).click();
        Thread.sleep(2000);
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@href='..\\index.html'])[1]")).click();
        Thread.sleep(2000);
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualURL= driver.getCurrentUrl();
        String expectedURl="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedURl,actualURL);
    }
}
