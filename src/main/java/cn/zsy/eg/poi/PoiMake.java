package cn.zsy.eg.poi;


import cn.zsy.util.Des3;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiMake {


    public static void main(String[] args) throws Exception {
        makeA();
        makeB();
//        updateInfo();
//        String decode = Des3.decode("A46+1w4chx2aTIo+iRbMnw==");
//        String encode = Des3.encode("admin10000");
//        System.out.println(decode);
//        System.out.println(encode);
    }


    public static void makeA() throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("E:\\aa\\daorudingzhimobancode.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        for (int j = 1; j <= 100; j++) {
            for (int i = 1; i <= 1000; i++) {
                HSSFRow row = sheet.createRow(i);
                row.createCell(0).setCellValue("广州平台测试学校（验收专用）");
                row.createCell(1).setCellValue("小三(8)班");
                row.createCell(2).setCellValue(String.format("%dB%d", j, i));
                row.createCell(4).setCellValue(13450953452L);
            }
            FileOutputStream fileOut = new FileOutputStream("E:\\poi\\info" + j + ".xls");
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
    }


    public static void makeB() throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("E:\\aa\\sssstudent_input_admin.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        for (int j = 1; j <= 100; j++) {
            for (int i = 1; i <= 1000; i++) {
                HSSFRow row = sheet.createRow(i);
                row.createCell(0).setCellValue(String.format("%dB%d", j, i));
                row.createCell(2).setCellValue(13450953452L);
                row.createCell(3).setCellValue("小三(8)班");
            }
            FileOutputStream fileOut = new FileOutputStream("E:\\poi\\Binfo" + j + ".xls");
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
    }

    public static void updateInfo() throws Exception {
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("E:\\poi\\1470195812858_100308875.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        for (int j = 3; j <= 159; j++) {
            HSSFRow row = sheet.getRow(j);
            HSSFCell hssfCellA = row.getCell(10);
            HSSFCell hssfCellB = row.getCell(11);
            String username = hssfCellA.getStringCellValue();
            String password = hssfCellB.getStringCellValue();
            String encode = Des3.encode(username);
            String passencode = Des3.encode(password);
            HSSFCell createHssfCellA = row.createCell(14);
            HSSFCell createHssfCellB = row.createCell(15);
            createHssfCellA.setCellValue(encode);
            createHssfCellB.setCellValue(passencode);
        }
        FileOutputStream fileOut = new FileOutputStream("E:\\poi\\userinfo.xls");
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();

    }

}
