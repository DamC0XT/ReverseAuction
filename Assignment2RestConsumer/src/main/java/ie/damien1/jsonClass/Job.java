package ie.damien1.jsonClass;

import java.time.LocalDate;





public class Job {
	
	
	private int jobId;
	
	
	private String jobName;
	
	
	private String jobUser;
	
	private String jobDescription;
	
	
	private String jobCategory;
	
	
	private LocalDate createdatetime;


	public Job(int jobId, String jobName, String jobUser, String jobDescription, String jobCategory,
			LocalDate createdatetime) {
	
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobUser = jobUser;
		this.jobDescription = jobDescription;
		this.jobCategory = jobCategory;
		this.createdatetime = createdatetime;
	}


	public Job() {
		super();
		
		
	
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getJobUser() {
		return jobUser;
	}


	public void setJobUser(String jobUser) {
		this.jobUser = jobUser;
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


	public LocalDate getCreatedatetime() {
		return createdatetime;
	}


	public void setCreatedatetime(LocalDate createdatetime) {
		this.createdatetime = createdatetime;
	}
	
	
	
}
	
	
	