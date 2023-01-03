package day07_dropDown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {

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
        // ilgili ayarlari yapip
        // amazon anasayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in java icerdigini test edin

        driver.get("https://www.amazon.com/");

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select= new Select(dropdown);
        select.selectByVisibleText("Books");

        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Java"+ Keys.ENTER);

        String expectedKelime="Java";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKelime));

        //dropdown menuden books seceneginin secildigini test edin
        /*
            Locate ettigimiz elementi bulamazsa NoSuchElementException
            sayfa yenilendigi icin var olan bir elementi kullanamazsa
            StaleElementException verir
            bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir
         */

        dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select= new Select(dropdown);
        select.selectByVisibleText("Books");

        String actualSecilenOption= select.getFirstSelectedOption().getText();
        String expectedSecilenOption="Books";

        Assert.assertEquals(expectedSecilenOption,actualSecilenOption);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin

        List<WebElement> optionsWebElementListesi= select.getOptions();

        int actualOptionSayisi= optionsWebElementListesi.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        Thread.sleep(5000);
    }
}
