package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        // dosya yolunu olusturalim
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        // fileINputStream objesi olusturup paramaetre olarak dosyaYoplunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // kod alanaimizdad excel'in bir kopyasini olusturup
        // tum bilgileri ona kopyalacagiz

        Workbook workbook= WorkbookFactory.create(fis);

        //workbook icerisinde birden fazla sayfa olabilir istediginiz sayfaya gidin

        Sheet sheet= workbook.getSheet("Sayfa1");

        // angola yazdirmak istedigimiz icin 5. satira gidleiö

        Row row= sheet.getRow(5);

        //5. satirida 2. index'deki datayi alaliim

        Cell cell=row.getCell(2);
        System.out.println(cell);
    }
}
