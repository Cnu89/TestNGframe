package Dataprovides;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataTesting {
    @Test(dataProvider = "static")
    public void TC01(String Uname, String Password) {
        System.out.println(Uname);
        System.out.println(Password);
    }

    @DataProvider(name = "static")
    public Object[][] Testdata() {
        Object[][] arr = {{"Pakala", "Srinivas"}, {"P", "S"}};
        return arr;
    }

    @DataProvider(name = "Excel")
    public Object[][] Readdatafromexcel() throws IOException {
        FileInputStream fr = new FileInputStream("./src/Testdata/Excelsheet.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fr);
        XSSFSheet sh = wb.getSheet("Sheet1");
        int noofrows = sh.getPhysicalNumberOfRows();
        XSSFRow row = sh.getRow(0);
        int noofcolumns= row.getPhysicalNumberOfCells();
        Object[][] testdata = new Object[noofrows][noofcolumns];
        for (int i=0; i<sh.getLastRowNum(); i++)
        {
            for (int k=0;k<noofcolumns;k++)
            {
                testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
                testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
                testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
                testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
                testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
            }
        }
        return testdata;
    }
    @Test(dataProvider ="Excel" )
    public void testdatfromexcel(String sno,String name,String age,String gender,String salary){
        System.out.println(sno);
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(salary);
    }
}