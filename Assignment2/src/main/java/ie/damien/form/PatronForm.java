package ie.damien.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class PatronForm {
	
	@NotEmpty(message = "{empty.error}")
	private String userName;
	
	@NotEmpty(message = "{empty.error}")
	@Email
	private String userEmail;
	
	@NotEmpty(message = "{empty.error}")
	private String password;
	
	public PatronForm() {
		
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
