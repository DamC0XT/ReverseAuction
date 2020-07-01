package ie.damien.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.damien.dao.JobDao;
import ie.damien.entities.Job;
import ie.damien.entities.Patrons;
import ie.damien.services.JobService;
import ie.damien.services.PatronsService;



@Controller
@RequestMapping("/")
public class indexController {
	@Autowired
	JobService jobService;
	
	@Autowired
	PatronsService patronService;
	
	
	@RequestMapping
	public String getJobs(Model model){
		
		List<Job> job1 = jobService.getAllJobs();
	    
		model.addAttribute("jobs",job1);
		
		
		return "index";
		
	}
	
	
	
}




	
	
	
	
	


	
	
	
	
	
	


