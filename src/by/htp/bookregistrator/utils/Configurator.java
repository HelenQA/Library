package by.htp.bookregistrator.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configurator {
	
	static private ResourceBundle resBundle;

	static {
		resBundle = ResourceBundle.getBundle("prop");
	}

	public static String getKey(String key) {
		try {
			String value = resBundle.getString(key);
			return value;
		} catch (MissingResourceException e) {
			System.out.println("Eroor with prop.properties");
			return null;
		}
	}

}
