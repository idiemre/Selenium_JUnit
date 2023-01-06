package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void tes01() throws IOException {

        // excel dosyalari bilgisayarimizda oldugu icin
        // Java'dan FileInptStream class'i yardimiyla ulasacagiz

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

        // satir ve suun bilisini parametre olarak alip o hucredeki bilgiyi yazdiran bir method olusturun

        dataYazdir(25,2);
        dataYazdir(14,3);


    }





    private void dataYazdir(int satir, int sutun) throws IOException {
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));
    }


}
