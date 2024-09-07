package pOJO;
import java.util.List;

public class PojoClassForCreateProj {//pojo inbuilt 1



	public	String projectstatus;

	String projectName;
	int teamSize;

	List<String> teamMember;

	ProjectManager projectManager;


	public PojoClassForCreateProj(String projectName, String projectstatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {//projectManager

		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	//	   public Project1(String projectName2, String projectstatus2, String string, List<String> lst, ProjectManager projectManager) {
	//		// TODO Auto-generated constructor stub
	//	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
//	public String getProjectstatus() {
//		return projectstatus;
//	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}
	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	public ProjectManager getProjectManager() {
		return projectManager;
	}
	public PojoClassForCreateProj(ProjectManager projectManager) {

		this.projectManager = projectManager;
	}

}

