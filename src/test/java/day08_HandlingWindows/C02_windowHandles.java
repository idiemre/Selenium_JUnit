package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_windowHandles {

    // ● Tests package’inda yeni bir class olusturun: WindowHandle2
    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
    // dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
    // olduğunu doğrulayın.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYazi=driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        String expectedYazi="Opening a new window";
        Assert.assertEquals(expectedYazi,actualYazi);

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        // ● Click Here butonuna basın.
        String ilkSayfaWHD=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        // dogrulayin.
        String ikinciWHD="";
        Set<String> ikiSayfaninHandleDegeri=driver.getWindowHandles();
        for (String each:ikiSayfaninHandleDegeri) {

            if (!ilkSayfaWHD.equals(each)){
                ikinciWHD=each;
            }
        }
        Thread.sleep(2000);
        driver.switchTo().window(ikinciWHD);
        String actualTitle2= driver.getTitle();
        String expectedTitle2="New Window";
        Assert.assertEquals(actualTitle2,expectedTitle2);


        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newWindowYazi=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedNewWindowYazi="New Window";

        Assert.assertEquals(expectedNewWindowYazi,newWindowYazi);
        Thread.sleep(2000);
        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        // olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        String title= driver.getTitle();
        String titleebiz="The Internet";
        Assert.assertEquals(titleebiz,title);
    }
}
