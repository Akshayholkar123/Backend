package pOJO;

public class ProjectManager {//pojo inbuilt 1
	   String name;
		String empId;

	   public ProjectManager(String name, String empId) {
	this.name = name;
	this.empId = empId;
}
		//String empId;    this one or above one
public ProjectManager()
{
	
}

	    public void setName(String name) {
	        this.name = name;
	    }
    public String getName() {
        return name;	    }
	    
	    public void setEmpId(String empId) {
	        this.empId = empId;
	    }
	    public String getEmpId() {
	        return empId;
	    }
	   }
