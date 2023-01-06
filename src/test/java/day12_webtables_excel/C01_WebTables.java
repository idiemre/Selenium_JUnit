package day12_webtables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    //1. “https://demoqa.com/webtables” sayfasina gidin
    //2. Headers da bulunan basliklari yazdirin
    //3. 3.sutunun basligini yazdirin
    //4. Tablodaki tum datalari yazdirin
    //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    //6. Tablodaki satir sayisini yazdirin
    //7. Tablodaki sutun sayisini yazdirin
    //8. Tablodaki 3.kolonu yazdirin
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
    //sayisini girdigimde bana datayi yazdirsi

    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersList=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        int sayi=1;
        for (WebElement each:headersList
             ) {
            System.out.println(sayi+"- "+each.getText());
            sayi++;
        }
        //3. 3.sutunun basligini yazdirin
        System.out.println("=================================");
        System.out.println("3. sutun baslik : "+headersList.get(2).getText());
        System.out.println("=================================");
        //4. Tablodaki tum datalari yazdirin
        WebElement bodyElementi=driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("body:\n"+bodyElementi.getText());


        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("=================================");
        List<WebElement> headersDataListesi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        int siraNo=1;
        for (WebElement each:headersDataListesi
        ) {
           if (!(each.getText().equals("") || each.getText().equals(" "))){
               System.out.println(siraNo+". - "+each.getText());
               siraNo++;
           }
        }
        //6. Tablodaki satir sayisini yazdirin
        System.out.println("=================================");
       List <WebElement> satirSayisiListesi= driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        System.out.println("tabloda'ki satir sayisi : "+satirSayisiListesi.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("tabloda'ki sütun sayisi : "+headersList.size());
        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("=================================");
        List<WebElement> ucuncuSutunDatalar=driver.findElements(By.xpath("((//div[@class='rt-tr-group']))//div[1]/div[3]"));

        for (WebElement each:ucuncuSutunDatalar
        ) {
            if (!(each.getText().equals("") || each.getText().equals(" "))){
                System.out.println(each.getText());

            }
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //   index'i saydiralim Kierra'yi bulunca indexin 4 fazlasni yazdiralim

        System.out.println("=================================");

        for (int i = 0; i <headersDataListesi.size() ; i++) {
            if (headersDataListesi.get(i).getText().equals("Alden")){
                System.out.println("istenen kisinin maasi : "+headersDataListesi.get(i+4).getText());
            }
        }



        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsi
    }
}
