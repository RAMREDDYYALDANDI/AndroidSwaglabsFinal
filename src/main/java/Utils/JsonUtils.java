package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {
	
	public List<HashMap<String,String>> jsonreader() throws IOException
	{
		FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/Logindata.json");
		
		List<HashMap<String,String>> data = new Gson().fromJson(reader, new TypeToken<List<HashMap<String,String>>>(){}.getType());
		
		reader.close();
		return data;
		
	}

}
