package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {


    //1- https://www.amazon.com/ adresine gidin
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
    //mouse’u bu menunun ustune getirin
    //3- “Create a list” butonuna basin
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin



    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        WebElement accountElementi= driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountElementi).perform();
        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListYazisi= driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourListYazisi.isDisplayed());
    }

}
