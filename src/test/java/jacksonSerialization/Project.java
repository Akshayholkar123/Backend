package jacksonSerialization;


/*@JsonPropertyOrder(
		value= {
				"createdBy",
				"projectName",
				"teamSize",
				"status"
		})
@JsonIgnoreProperties(
		value= {
		      "teamSize"
		})*/

public class Project{//POJO Class <plain old java Object>
//	@Getter @Setter
	private String projectName;
	//@JsonProperty(value="created By")
	private String createdBy;
	private int teamSize;
	private String status;
	
	
	public Project() {
	}
	public Project(String projectName,String status, String createdBy, int teamSize) {
		this.projectName = projectName;
		this.status = status;

		this.createdBy = createdBy;
		this.teamSize = teamSize;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

}
