package ie.damien.form;

import javax.validation.constraints.NotEmpty;

public class JobForm {

	@NotEmpty(message = "{empty.error}")
	private String jobName;
	
	@NotEmpty(message = "{empty.error}")
	private String jobDescription;
	
	@NotEmpty(message = "{empty.error}")
	private String jobCategory;
	

	
	




	public JobForm() {
		
		super();
	}

	

	public String getJobName() {
		
		return jobName;
	}

	public void setJobName(String jobName) {
		
		this.jobName = jobName;
	}

	public String getJobDescription() {
		
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		
		this.jobDescription = jobDescription;
	}

	public String getJobCategory() {
		
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		
		this.jobCategory = jobCategory;
		
	}
}
