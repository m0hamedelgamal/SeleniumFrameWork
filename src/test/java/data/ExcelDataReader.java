package data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader 
{
	static FileInputStream inputstream=null; 

	public FileInputStream getFileInputStream()
	{
	//String filepath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\x1.xlsx"; 	
		//String filepath= "C:\\Users\\User\\eclipse\\eclipse\\Eclipse Projects\\POM-Training\\src\\test\\java\\data\\usertestingdata.xlsx";  	
		
		String filepath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\x1.xlsx"; 	
		File srcfile= new File(filepath); 
		
		try {
			inputstream = new FileInputStream(srcfile);
		}
		catch (FileNotFoundException e) {
		System.out.println("File not found ");
		}
		return inputstream;
	} 
	
	public Object [][] getTestDataFromExcel() throws IOException
	{
		inputstream = getFileInputStream(); 
		XSSFWorkbook wb = new XSSFWorkbook(inputstream); 
		XSSFSheet sheet= wb.getSheetAt(0);  
		int totalnumberofrows= (sheet.getLastRowNum()+1);  
		int totalnumberofcolumns= 4 ; 
		String [][] excelCellData= new String[totalnumberofrows][totalnumberofcolumns]; 

		for (int i = 0; i < totalnumberofrows; i++) 
		{
			for (int j = 0; j < totalnumberofcolumns; j++) 
			{
				XSSFRow row = sheet.getRow(i); 
				excelCellData[i][j]= row.getCell(j).toString();
			}
			} 
		wb.close();
		return excelCellData;
	}

}

