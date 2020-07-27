package utilites;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Helper 

{
	//Take ScreenShots for failed test cases 

	public static void takeScreenShoot(WebDriver driver , String ScreenShootName) throws IOException  

	{
		Path ScreenShootdest=Paths.get(".\\Screenshots",ScreenShootName+".png"); 
		try {

			//get the parent for the destination we will write to it 
			Files.createDirectories(ScreenShootdest.getParent());
			//open output stream 
			FileOutputStream output = new FileOutputStream(ScreenShootdest.toString()); 
			//Define the Takescreenshoot function and source 
			//TakesScreenshot TS= (TakesScreenshot)driver; 
			//File sourcefile= TS.getScreenshotAs(OutputType.FILE); 
			output.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			output.close();
		}
		catch (Exception e) {

		}
		//TakesScreenshot ts = (TakesScreenshot)driver; 
		//File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		//FileUtils.copyFile(source, new File("./Screenshots/"+ result.getName()+".png"));
	}

}
