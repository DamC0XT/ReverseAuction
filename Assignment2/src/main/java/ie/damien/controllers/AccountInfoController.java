package ie.damien.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ie.damien.entities.Patrons;
import ie.damien.services.PatronsService;

@Controller
public class AccountInfoController {
	@Autowired
	PatronsService patronService;
	
	
	
	
	@GetMapping(value="/AccountInfo")
	public String getAllAccounts(Model model) {
		
		List<Patrons> user = patronService.getAllUsers();
		
		model.addAttribute("users", user);
		
		return "AccountInfo";
		
 	}

}
