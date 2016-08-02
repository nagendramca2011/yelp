package wow.yelp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONObject;

public class CreateJsonFile {
	
	public CreateJsonFile()
	{
		
	}
	public void GiveMeJsonObject(String jsonobject)
	{
		JSONObject obj = new JSONObject();
		//Creating a new file
	    Path newFile = Paths.get("D:\\test.json");
	    try {
	      Files.deleteIfExists(newFile);
	      newFile = Files.createFile(newFile);
	    } catch (IOException ex) {
	      System.out.println("Error creating file");
	    }
	    System.out.println(Files.exists(newFile));

	    //Writing to file
	    try(BufferedWriter writer = Files.newBufferedWriter(
	            newFile, Charset.defaultCharset())){
	    	System.out.println("json file:"+jsonobject);
	      writer.append(jsonobject);
	      //writer.flush();
	      
	      FileWriter file = new FileWriter("D:\\test.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
	    }catch(IOException exception){
	      System.out.println("Error writing to file");
	    }
	}	
}
