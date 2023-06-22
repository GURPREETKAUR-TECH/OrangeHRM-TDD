package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] readdata(String Sheetname)	{
		
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\gurpr\\eclipse-workspace\\newguru\\Orangehrm\\src\\test\\java\\testdata\\details.xlsx");
		System.out.println(file);}
		catch(FileNotFoundException e) {
			e.printStackTrace();}
		try {
	book=WorkbookFactory.create(file);//to create a workbook in an appropriate file format (it automatically detects the file format)
		}
		catch(IOException a) {
			a.printStackTrace();}
	sheet=book.getSheet(Sheetname);
	//from my workbook get the sheet and its name is stored as parameter in readdata method
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];//2 dimensional object array 
	for (int i=0;i<sheet.getLastRowNum();i++) {//to fetch rows
		for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){//to fetch columns	
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();}
	}
	return data;
	}}

