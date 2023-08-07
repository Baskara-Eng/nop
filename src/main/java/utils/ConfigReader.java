package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties loadProperties() throws IOException {
		prop= new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resource/configs/config.properties");
		prop.load(fis);
		return prop;
	}
	

}
