package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {


    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropMe= driver.findElement(By.xpath("//div[@id='droppable']"));

        actions.dragAndDrop(dragMe,dropMe).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDropHere=driver.findElement(By.xpath("(//p[text()='Dropped!'])[1]")).getText();
        String expectedDropped="Dropped!";
        Assert.assertEquals(expectedDropped,actualDropHere);


    }
}
