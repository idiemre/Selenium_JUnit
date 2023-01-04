package day10_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01(){
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        //3. logo.png dosyasını indirelim
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim


        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. sample.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='sample.png']")).click();
        ReusableMethods.bekle(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Test icin oncelikle dosyanin indirildigini dosyaYolu ne olacak bunu olusturmaliyiz
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\sample.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // bir dosyanin bilgisayarimizda var oldugunu
        // test etmek icin javada'ki Files class'indan yardim aliriz

    }

    @Test
    public void test02(){
        // masaustunde MerhabaJava.txt dosyasi oldugunu test edin

        String dosyaJava=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaJava)));
    }
}
