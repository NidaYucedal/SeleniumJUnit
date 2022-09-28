package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test1() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String tablo = "";

        //excel tablosundaki tum tabloyu konsola yazdirin
        for (int i = 0; i <= sonSatir; i++) {
            tablo = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

        }

        /*
        kısa yol
                for (int i = 0; i <sonData ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(workbook.getSheet("Sayfa1").getRow(i).getCell(j)+", ");
             }
            System.out.println("");
                }
         */


    }
}
