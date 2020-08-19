 package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsondatareader 
{
	public String  firstName , lastName , eMail , Pswd ; 

	public void jsonReader() throws IOException, ParseException
	{
		 
		File srcFile=new File(System.getProperty("user.dir")+
				              "/src/test/java/data/testdata.json");
		FileReader FR = new FileReader(srcFile); 

		JSONParser parser= new JSONParser(); 
		JSONArray jarray= (JSONArray)parser.parse(FR); 

		for(Object jsonObj:jarray)
		{
			JSONObject userdata=(JSONObject)jsonObj ;
			firstName = (String)userdata.get("fname");  
			lastName= (String) userdata.get("lname");
			eMail=(String) userdata.get("mail");
			Pswd = (String) userdata.get("Pswd");
			System.out.println(firstName+" : " + lastName +" "+eMail +" "+Pswd + " " );
		}

	}
}
