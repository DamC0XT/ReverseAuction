package ie.damien.controllers;

import java.security.Principal;
import java.time.LocalDate;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ie.damien.entities.Job;

import ie.damien.form.JobForm;
import ie.damien.services.JobService;

@Controller
@RequestMapping("/")
public class JobFormController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping(value="/createjob")
	public String JobFormRequest(Model model) {
		
		model.addAttribute("jobForm",new JobForm());
		
		return "createjob";
		
		
		
	}
	
	
@PostMapping("/createjob")
	
	public String addJob(@Valid JobForm jobForm, BindingResult binding,Principal principal){
	
	   LocalDate now = LocalDate.now();
	 
		if(binding.hasErrors())
			return "createjob";
		
		Job job = new Job(jobForm.getJobName(),jobForm.getJobDescription(),jobForm.getJobCategory(),principal.getName(),now,true);
		job = jobService.save(job);
		
		if(job != null)
			
			return "redirect:/";
		
		else 
			
		return "redirect:createjob";
		
	}

}
