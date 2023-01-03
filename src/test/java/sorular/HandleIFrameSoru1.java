package sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleIFrameSoru1 {

    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
    // konsolda yazdirin.
    // - Text Box’a “Merhaba Dunya!” yazin.
    // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
    // gorunur oldugunu dogrulayin ve konsolda yazdirin.


    WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @After
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void iframeTest() throws InterruptedException {
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        // konsolda yazdirin.
        WebElement yazi=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(yazi.isEnabled());
        System.out.println(yazi.getText());
        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframeElementi);
        WebElement textBoxElementi= driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBoxElementi.clear();
        Thread.sleep(10000);
        textBoxElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(10000);
        driver.switchTo().defaultContent();

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        // gorunur oldugunu dogrulayin ve konsolda yazdirin.

        WebElement elementalSeleniumYazisi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumYazisi.isDisplayed());
        System.out.println(elementalSeleniumYazisi.getText());
    }

}
