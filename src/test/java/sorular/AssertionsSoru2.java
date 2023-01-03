package sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertionsSoru2 {

    // 1) Bir class oluşturun: YoutubeAssertions
    // 2) https://www.youtube.com adresine gidin
    // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void titleTest(){
        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

        WebElement youtubeResmi=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeResmi.isDisplayed());

        WebElement searchBoxElementi= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxElementi.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";

        Assert.assertNotEquals(expectedTitle,actualTitle);
    }
}
