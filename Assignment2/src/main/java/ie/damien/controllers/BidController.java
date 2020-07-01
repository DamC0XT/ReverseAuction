package ie.damien.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ie.damien.dao.BidDao;
import ie.damien.entities.Bid;
import ie.damien.form.BidForm;
import ie.damien.services.BidService;
import ie.damien.services.JobService;
import ie.damien.services.PatronsService;

@Controller

public class BidController {
	@Autowired
	BidService bidService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	PatronsService patronService;
	
	@Autowired
	BidDao bidDao;
	
	
	@GetMapping("/Bid/{id}")
	public String FormRequest(Model model,@RequestParam("id") int id, HttpSession session) {
		
		model.addAttribute("bidForm",new BidForm());
		model.addAttribute("id",id);
		session.setAttribute("ID", id);
		
		return "Bid";
		
		
	}
	
	
	@PostMapping("/Bid{id}")
	
	public String addNewBid(@Valid BidForm bidForm, BindingResult binding, Principal principal,Model model,HttpSession session){
	
		Bid bid = null;
		List<Bid> bids = bidDao.findAll();
		
		 bidForm.setJobName(jobService.findJobName((int) session.getAttribute("ID")));
		
		if(binding.hasErrors())
			return "Bid";
		
		
		 	
			if((bidForm.getBidOffer() < bidService.findBidByJobName(bidForm.getJobName())) && (principal.getName() != bidService.findBidUser((int) session.getAttribute("ID")))){
					
					bidForm.setJobName(jobService.findJobName((int) session.getAttribute("ID")));
			
					bid = new Bid(true,bidForm.getJobName(),principal.getName(),bidForm.getBidOffer(),true);
					bid = bidService.save(bid);
										
					
				
				}
				if(bid != null)
					return "redirect:/showbid";
					
				
				
				else
					return "redirect:/Bid";
			
		
		
			
		
		
	}
	

}
