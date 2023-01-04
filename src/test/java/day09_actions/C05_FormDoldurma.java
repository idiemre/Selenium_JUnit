package day09_actions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.sql.ResultSet;

public class C05_FormDoldurma extends TestBase {

    @Test
    public void test(){
        // facebook.com sayfasina gidin
        driver.get("https://www.facebook.com");
        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // ilgili alanlari faker kutuphanesinden degerlerle doldurun
        WebElement firstNameKutusu=driver.findElement(By.name("firstname"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();

        String mailAdresi=faker.internet().emailAddress();

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .sendKeys("2002")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();


        // kaydol butonuna basin
        WebElement signUpButton=driver.findElement(By.name("websubmit"));
        signUpButton.click();

        ReusableMethods.bekle(10);




    }

}
