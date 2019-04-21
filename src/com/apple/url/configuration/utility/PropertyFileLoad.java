package com.apple.url.configuration.utility;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertyFileLoad {
	public Properties propLoad() throws IOException  {
		Properties config =null;
		try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(ConstantUtility.PROB_FILE_NAME);) {
			config = new Properties();
			config.load(in);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return config; 
	 }
}