package day07_dropDown_jsAlerts;

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

public class C04_IFrame {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        // konsolda yazdirin.
        WebElement actualSayfaYazisiElementi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        Thread.sleep(3000);
        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeWebElementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframeWebElementi);

        WebElement textBoxElementi=driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        // gorunur oldugunu dogrulayin ve konsolda yazdirin.



        // Iframe'in icine girdikten sonra, oradan cik denilinceye kadar
        // driver iframe'in icinde kalir
        // eger disina cikmka isterseniz

        //driver.switchTo().parentFrame(); // bulundugu iframe'in bir ust html sayfasina gecer
        // bu daha cok ic ice iframe'ler oldugunda tercih edilir
        driver.switchTo().defaultContent(); // anasayfaya gecis yapar

        WebElement elementalSeleniumYazisi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumYazisi.isDisplayed());
        System.out.println(elementalSeleniumYazisi.getText());

    }

}
