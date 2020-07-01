package ie.damien.controllers;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.damien.dao.RoleDao;
import ie.damien.entities.Patrons;
import ie.damien.entities.Role;

import ie.damien.form.PatronForm;
import ie.damien.services.PatronsService;

@Controller
@RequestMapping("/")
public class CreateAccountController {
	
	@Autowired
	PatronsService patronService;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping(value="/createaccount")
	public String FormRequest(Model model) {
		
		model.addAttribute("patronForm", new PatronForm());
		
		return "createaccount";
		
		
	}
	
	@PostMapping("/createaccount")
	public String addNewAccount(@Valid PatronForm patronForm, BindingResult binding1) {
		
		if(binding1.hasErrors())
			return "createaccount";
		
		Role role3 = new Role(patronForm.getUserEmail(),"ROLE_USER");
		roleDao.save(role3);
		
		Patrons user3 = new Patrons(passwordEncoder.encode(patronForm.getPassword()),patronForm.getUserEmail(),patronForm.getUserName(),role3,true);
		
		user3 = patronService.save(user3);
		
		if(user3 != null)
			
			return "redirect:/login";
		
		else 
			
		return "redirect:createaccount";
		
		
	}

}
