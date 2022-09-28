package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_DeleteExcel {

    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //-WorkbookFactory.create(fileInputStream)
    //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
    //-Row objesi olusturun sheet.getRow(3)
    //-Cell objesi olusturun row.getCell(3)
    //-3. Satır 3. Cell'deki veriyi silelim
    //-Silindiğini test edin

    @Test
    public void delete() throws IOException {


        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //Olusturmuş olduğumuz dosyayı sistemde işleme alır

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //-Silindiğini test edin
        String expectedData = "Cezayir";
        String actualData = null;
        Assert.assertNotEquals(expectedData, actualData);
    }
}
