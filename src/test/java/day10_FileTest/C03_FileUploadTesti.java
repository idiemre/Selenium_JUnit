package day10_FileTest;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Paths;

public class C03_FileUploadTesti extends TestBase {

    //2. https://the-internet.herokuapp.com/upload adresine gidelim
    //3. chooseFile butonuna basalim
    //4. Yuklemek istediginiz dosyayi secelim.
    //5. Upload butonuna basalim.
    //6. “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test01() throws IOException {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        WebElement choose=driver.findElement(By.xpath("//*[@id='file-upload']"));



        //4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.txt";
         choose.sendKeys(dosyaYolu);

        //5. Upload butonuna basalim.

        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        ReusableMethods.bekle(6);
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYazisi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }
}
