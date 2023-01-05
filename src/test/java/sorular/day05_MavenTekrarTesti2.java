package sorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class day05_MavenTekrarTesti2 extends TestBase {

    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    @Test
    public void test01(){
           //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

           //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");

           //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("secret_sauce");

           //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

           //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrunIsmi=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();

           //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

           //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

           //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String actualUrunIsmi=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        String expecteUrunIsmi="Sauce Labs Backpack";
        Assert.assertEquals(expecteUrunIsmi,actualUrunIsmi);


    }
}
