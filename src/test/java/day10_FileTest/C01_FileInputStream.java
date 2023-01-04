package day10_FileTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class C01_FileInputStream  {

    @Test
    public void test01() throws FileNotFoundException {


        String dosyaYolu ="C:\\Users\\Emre\\Desktop\\MerhabaJava.txt";

        FileInputStream fis=new FileInputStream(dosyaYolu);


        /*
          File testlerinde genellikle downloads'a indirilecek bir dosyanin
          indirildigindini test etmek
          veya masaustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz

          Ancak herkesin bilgisayarinin ismi, kullanici isimleri gibi farkliliklar
          olacagindadn testler tek bir bilgisayarda calisacak gibi yazilmak zorunda kalini.

          Bu karisikligin onune geccebilmek icin java
          2 basit kod blogu sunmus
         */

        System.out.println(System.getProperty("user.dir"));
        // o anda calisan dosyanin (C01_FileInputStream) yolunu verir
        // C:\Users\Emre\Desktop\com.Team105JUnit

        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path'ini verir
        // C:\Users\Emre

        //masaustune gitmek istersek
        // C:\Users\Emre + \Desktop eklememiz yeterlidir

        // Downloads'a gitmek istersek
        //C:\Users\Emre + \ Downloads eklememiz yeterlidir


        // kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylarar takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan alacak sekilde
        // olustururz

        // "C:\\Users\\Emre\\Desktop\\MerhabaJava.txt"

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.txt";
        System.out.println(dinamikDosyaYolu);

    }
}
