package ie.damien.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	
	@GetMapping(value="/logout")
	public String logoutRequest() {
		
		return "logout";
	}

}
