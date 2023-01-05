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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitlySoru {

    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsGone=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsGone.isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // 7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsBack=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBack.isDisplayed());
    }
}
