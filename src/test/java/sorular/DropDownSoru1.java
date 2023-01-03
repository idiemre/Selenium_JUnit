package sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownSoru1 {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
    // yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
    // degilse False yazdırın.

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
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElementi=driver.findElement(By.id("dropdown"));

        Select select=new Select(dropdownElementi);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
    }
}
