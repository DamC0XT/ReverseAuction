package ie.damien.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class denyController {
	
	
	@GetMapping(value="/403")
	public String denyRequest() {
		
		return "403";
	}

}
