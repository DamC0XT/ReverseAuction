package ie.damien1.jsonClass;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Bid {
	

	private int bidId;
	
	
	
	
	private boolean bid;
	
	
	private String jobName;
	

	
	
	private String userEmail;
	
	
	public Bid(int bidId, boolean bid, String jobName, String userEmail, double bidOffer) {
		
		this.bidId = bidId;
		this.bid = bid;
		this.jobName = jobName;
		this.userEmail = userEmail;
		this.bidOffer = bidOffer;
	}
	
	


	public Bid() {
		super();
		
	}




	public int getBidId() {
		return bidId;
	}


	public void setBidId(int bidId) {
		this.bidId = bidId;
	}


	public boolean isBid() {
		return bid;
	}


	public void setBid(boolean bid) {
		this.bid = bid;
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


	public double getBidOffer() {
		return bidOffer;
	}


	public void setBidOffer(double bidOffer) {
		this.bidOffer = bidOffer;
	}


	private double bidOffer;

}
