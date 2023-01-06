package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver)  {

        // 1- TakeScreenshot objesi olustur
        TakesScreenshot tss=(TakesScreenshot)driver;
        // Resmi son olarak kaydedecegimiz dosyayi olustur
        // her resim cektiginde ust uste kaydetmemesi icin
        // resim dosya yoluna tarih ve saat iceren bir ek yapalim
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimler/tumEkranSS"+tarih+".jpeg";
        File tumSayfaScreenshot=new File(dosyaYolu);
        // 3- takeScreenshot objesi kullanarak ekran goruntusu alip gecici dosyaya kaydedelim
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        // 4- gecici dosyayi ana dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {

        }
    }

    public static void elementSSCek(WebElement aramaSonucElementi) {

        // screenshot alacagimiz elementi locate et
        // kaydedecegimiz dosyayi olustur
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimler/istenenElementSS"+tarih+".jpeg";

        File elementSS=new File(dosyaYolu);

        // gecici dosyayi olusturup element uzerinden ss yapalaiö

        File gecici=aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        // gecici dosyayi hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {

        }
    }
}
