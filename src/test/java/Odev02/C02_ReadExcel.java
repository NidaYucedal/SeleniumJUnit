package Odev02;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //-WorkbookFactory.create(fileInputStream)
    //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin

    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        int satirSayisi = (workbook.getSheet("Sayfa2").getLastRowNum()) + 1;
        int sutunSayisi = workbook.getSheet("Sayfa2").getRow(satirSayisi - 1).getLastCellNum();

        System.out.println("satirSayisi = " + satirSayisi);
        System.out.println("sutunSayisi = " + sutunSayisi);

        int satirStunToplam = satirSayisi + sutunSayisi;
        Assert.assertEquals(satirStunToplam, 9);
    }
}


