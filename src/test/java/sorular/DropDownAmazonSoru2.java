package sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.time.Instant;
import java.util.List;

public class DropDownAmazonSoru2 {

    // https://www.amazon.com/ adresine gidin.
    // - Test 1
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    // oldugunu test edin
    // -Test 2
    // 1. Kategori menusunden Books secenegini secin
    // 2. Arama kutusuna Java yazin ve aratin
    // 3. Bulunan sonuc sayisini yazdirin
    // 4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public  void tearDown() {
        driver.close();

    }

    @Test
    public void test01(){
        // - Test 1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        // oldugunu test edin
        driver.get("https://www.amazon.com/");
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdown);

        int actualUzunluk=select.getOptions().size();
        int expectedUzunluk=28;

        Assert.assertEquals(expectedUzunluk,actualUzunluk);
    }

    @Test
    public void test02(){
        // -Test 2
        // 1. Kategori menusunden Books secenegini secin
        // 2. Arama kutusuna Java yazin ve aratin
        // 3. Bulunan sonuc sayisini yazdirin
        // 4. Sonucun Java kelimesini icerdigini test edin

        driver.get("https://www.amazon.com/");
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        String sonucSayisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(sonucSayisi);

        String expectedKelime="Java";

        Assert.assertTrue(sonucSayisi.contains(expectedKelime));


    }
}
