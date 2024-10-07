package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * This method is written to read data from property file
	 * @param Key
	 * @return
	 * @throws Throwable
	 */

public String getKeyandVapuePair(String Key) throws Throwable {
	FileInputStream fis = new FileInputStream(IPathConstants.filepath);
	
	//step 2: do the object creation file and load the keys present in properties file
	Properties pro = new Properties();
	pro.load(fis);
	
	//step 3 : call key from properties file with the help of getproperties methos
	String Value = pro.getProperty(Key);
	return Value;
	
}
}
