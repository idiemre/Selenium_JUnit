package sorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;

public class day05_MavenTestiSoru extends TestBase {

    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6- Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8- Sayfayi kapatin

    @Test
    public void test01(){
        driver.get("https://www.google.com/");

        String actualTitle= driver.getTitle();
        String expectedTitle="Google";
        Assert.assertEquals(expectedTitle,actualTitle);

        WebElement aramaCubugu= driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella"+ Keys.ENTER);
        String sonucSayisistr=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println(sonucSayisistr);
        String[] sonucSayisiArr=sonucSayisistr.split(" ");
        System.out.println(Arrays.toString(sonucSayisiArr));
        System.out.println(sonucSayisiArr[1]);
        String sonucsayisi=sonucSayisiArr[1].replaceAll("\\.","");


        int sonucsayi=Integer.parseInt(sonucsayisi);
        Assert.assertTrue(sonucsayi>10000000);
        System.out.println(sonucsayi);



    }
}
