 
package Api_Chaining;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
//@SuppressWarnings("deprecation")
	
	String filePath = Driver.path;
public String getDataFromExcel(String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException,FileNotFoundException
{
	//FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
	FileInputStream fis=new FileInputStream(filePath);

	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowCount);
	Cell cell=row.getCell(cellCount);
	String data=cell.getStringCellValue();

	wb.close();
	return data;

}
public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int rc=sh.getLastRowNum();
		wb.close();
		return rc;
	
}
public void writedataInExcel(String sheetName,int rowCount,int cellCount,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(filePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowCount);
	Cell cell=row.createCell(cellCount);
	cell.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream(filePath);
	wb.write(fos);
	
wb.close();
}
}