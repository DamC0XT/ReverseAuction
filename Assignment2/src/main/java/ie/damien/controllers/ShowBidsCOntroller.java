package ie.damien.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.damien.entities.Bid;
import ie.damien.entities.Job;
import ie.damien.services.BidService;

@Controller
@RequestMapping("/showbid")
public class ShowBidsCOntroller {
	@Autowired
	BidService bidService;
	
	@RequestMapping
	public String getJobs(Model model){
		
		List<Bid> bid1 = bidService.getBid();
		
		model.addAttribute("bids",bid1);
		
		return "showbid";
		
	}
	
	

}
