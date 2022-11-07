package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws IOException {
		String basePath = System.getProperty("user.dir");
		String path = basePath+ "\\src\\main\\java\\resources\\data.properties";
		System.out.println("Path: " + path);
	}

}
