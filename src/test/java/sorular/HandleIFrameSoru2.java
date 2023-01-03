package sorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleIFrameSoru2 {

    // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    // 2) sayfadaki iframe sayısını bulunuz.
    // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
    // 5) ikinci iframe'deki (Jmeter Made Easy) linke
    // (https://www.guru99.com/live-selenium-project.html) tıklayınız


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
    public void test01(){

        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkIframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(ilkIframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        // 5) ikinci iframe'deki (Jmeter Made Easy) linke
        // (https://www.guru99.com/live-selenium-project.html) tıklayınız

        WebElement ikinciIframe= driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(ikinciIframe);
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();




    }
}
