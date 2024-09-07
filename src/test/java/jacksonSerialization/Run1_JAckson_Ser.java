package jacksonSerialization;

import java.io.File;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run1_JAckson_Ser {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException 
	{
		Project pObj=new Project("Orange","Created","Akshay",10);

		ObjectMapper objM=new ObjectMapper();
	    objM.writeValue(new File("./project.json"),pObj);	
	
	System.out.println("===success===");
	}

}
