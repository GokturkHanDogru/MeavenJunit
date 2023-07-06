package day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead  {

    @Test
    public void test01() throws IOException {


        // dosya yolunu aliriz
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        //capital dosyasini bizim sistemimize getirmeliyiz
        FileInputStream  fis = new FileInputStream(dosyaYolu);


        //dosyayi workbooka atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);


        //sayfayi secmeliyiz
        Sheet sheet = workbook.getSheet("Sheet1");


        //satiri row secmeliyiz
        Row  row = sheet.getRow(0);


        //hücreyi secmeliyiz
        Cell cell = row.getCell(0); //1.sütun index 0'dan baslar


        
    }

    @Test
    public void readExcelTest2() throws IOException {

        //kisa yöntem
        //1.satir 1. sütundaki bilgiyi yazdiriniz

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();

        System.out.println(satir1Sutun1);


    }


    @Test
    public void readExcelTest3() throws IOException {

        //1.satir 2.sütundaki hücreyi yazdirin
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun2 = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();

        System.out.println(satir1Sutun2);
    }
}
