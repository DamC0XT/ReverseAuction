package ie.damien.form;

import javax.validation.constraints.PositiveOrZero;


public class BidForm {
	
	private String jobName;
	
	
	private String userEmail;
	
	@PositiveOrZero
	private double bidOffer;
	
	

	public double getBidOffer() {
		return bidOffer;
	}

	public void setBidOffer(double bidOffer) {
		this.bidOffer = bidOffer;
	}

	public BidForm(){
		
		super();
		
	}

	public String getJobName() {
		
		return jobName;
		
	}

	public void setJobName(String jobName) {
		
		this.jobName = jobName;
		
	}
	
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	

}
