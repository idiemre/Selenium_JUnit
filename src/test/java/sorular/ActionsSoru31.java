package sorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsSoru31 extends TestBase {

    @Test
    public void test01(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverMeFirstElementi=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMeFirstElementi).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElementi= driver.findElement(By.xpath("(//p[text()='Click and Hold!'])[1]"));
        actions.clickAndHold(clickAndHoldElementi).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHoldYazisi=driver.findElement(By.xpath("//div[@id='click-box']")).getText();
        System.out.println(clickAndHoldYazisi);
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi= driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickElementi).perform();
    }

}
