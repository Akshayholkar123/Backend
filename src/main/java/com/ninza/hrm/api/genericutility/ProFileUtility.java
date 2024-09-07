package com.ninza.hrm.api.genericutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Deepak
 *
 */
public class ProFileUtility {
	/**
	 * used to read the data from propertied file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IConstantPath.path_file);
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		
		return data;
	}

}


