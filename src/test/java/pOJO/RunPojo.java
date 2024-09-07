package pOJO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunPojo {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException
	{
		List<String> lst=new ArrayList<String>();
		lst.add("john");
		lst.add("steav");
		lst.add("david");
		//create object for project manager so we pass in constructor
		
	ProjectManager pM=new ProjectManager("Akshay","tp01");
		
	PojoClassForCreateProj projectObj=new PojoClassForCreateProj("Akshay","Created",10,lst,pM);
//	System.out.println(projectObj.projectName);
ObjectMapper objM=new ObjectMapper();
objM.writeValue(new File("./project1.json"),projectObj);
System.out.println("===success==");
	}

}
