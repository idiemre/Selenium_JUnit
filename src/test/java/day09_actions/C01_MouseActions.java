package day09_actions;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
import java.util.Set;

public class C01_MouseActions extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    //3- Cizili alan uzerinde sag click yapin
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim


    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWHD=driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapin

        Actions actions=new Actions(driver);
        actions.contextClick( driver.findElement(By.xpath("//div[@id='hot-spot']"))).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="You selected a context menu";
        Assert.assertEquals(expectedAlert,actualAlert);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> listeWHD=driver.getWindowHandles();
        String ikinciWHD="";

        for (String each :listeWHD
             ) {
            if (!ilkSayfaWHD.equals(each)) {
                ikinciWHD=each;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciWHD);

        String actualElemental=driver.findElement(By.tagName("h1")).getText();
        String expectedElemental="Elemental Selenium";
        Assert.assertEquals(expectedElemental,actualElemental);

        ReusableMethods.bekle(5);
    }
}
