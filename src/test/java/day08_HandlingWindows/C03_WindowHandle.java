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

public class C03_WindowHandle {
    // https://the-internet.herokuapp.com/iframe adresine gidin
    // elemental selenium linkini tiklayin
    // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
    // ilk sayfaya geri donup, sayfadaki yazinin
    // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edelim

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
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        Set<String> whdDegerleri=driver.getWindowHandles();
        String ikinciWHD="";
        for (String each:whdDegerleri) {
            if (!ilkSayfaHandleDegeri.equals(each)){
                ikinciWHD=each;
            }
        }

        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        driver.switchTo().window(ikinciWHD);
        String actualEnBuyukYazi=driver.findElement(By.tagName("h1")).getText();
        String expectedEnBuyukYazi="Elemental Selenium";
        Assert.assertEquals(expectedEnBuyukYazi,actualEnBuyukYazi);
        // ilk sayfaya geri donup, sayfadaki yazinin
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edelim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        String actualAnFrameYazisi=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedAnFrameYazisi="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(expectedAnFrameYazisi,actualAnFrameYazisi);

    }
}
