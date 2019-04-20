package providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	
	public ConfigDataProvider() {
		
		File file = new File("./src/test/resources/Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getChromePath() {
		String chromePath=prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getIePath() {
		String chromePath=prop.getProperty("iePath");
		return chromePath;
	}
	
	
	public String getApplicationUrl() {
		String url= prop.getProperty("url");
		return url;
		
	}	

}
