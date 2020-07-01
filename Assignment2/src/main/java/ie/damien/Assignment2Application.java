package ie.damien;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import ie.damien.dao.BidDao;
import ie.damien.dao.JobDao;
import ie.damien.dao.PatronDao;
import ie.damien.dao.RoleDao;
import ie.damien.entities.Bid;
import ie.damien.entities.Job;
import ie.damien.entities.Patrons;
import ie.damien.entities.Role;
import ie.damien.services.BidService;
import ie.damien.services.JobService;
import ie.damien.services.PatronsService;

@SpringBootApplication
@EnableScheduling
public class Assignment2Application implements CommandLineRunner{
	@Autowired
	JobService jobService;
	
	@Autowired
	BidDao bidDao;
	
	@Autowired
	BidService bidService;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PatronDao patronDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	PatronsService patronService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		LocalDate now = LocalDate.now();
		
		
		
		
		Job cleaning = new Job("HouseCleaning","My house needs a deepclean especially the kitchen","Cleaning","me@email.com",now,true);
		
		jobService.save(cleaning);	
		Job Prepair = new Job("Phone Repair","My screen is broken looking for an I.T specialist to Repair","Repair","me@email.com",now,true);
		jobService.save(Prepair);	
		Job gardening = new Job("Grass Cutting","I need my grass cut on the weekend","Gardening","me@email.com",now,true);
		jobService.save(gardening);	
		Job window = new Job("New Windows","Looking for a reasonable price","Installation","me@email.com",now,true);
		jobService.save(window);	
		
		Bid bid = new Bid(true,"HouseCleaning","Minus0",2000,false);
		bidDao.save(bid);
		Bid bid1 = new Bid(true,"Phone Repair","Minus0",500,false);
		bidDao.save(bid1);
		Bid bid2 = new Bid(true,"Grass Cutting","Minus0",25,false);
		bidDao.save(bid2);
		Bid bid3 = new Bid(true,"New Windows","Minus0",900,false);
		bidDao.save(bid3);
		
		
		
		
		Role role1 = new Role("david@yahoo.ie","ROLE_USER");
		
		
		roleDao.save(role1);
		
		
		Patrons user1 = new Patrons(passwordEncoder.encode("password124"),"david@yahoo.ie","David123",role1,true);
		
		
		patronDao.save(user1);
		
		
		
		Role role2 = new Role("me@admin.com","ROLE_ADMIN");
		
		roleDao.save(role2);
		
		Patrons user2 = new Patrons(passwordEncoder.encode("fhag339S@#"),"me@admin.com","Minus0",role2,true);
		
		patronDao.save(user2);
		
		
		System.out.println(bidService.findBidByJobName("HouseCleaning"));
		
		
		
	
		
	
		
	   
		
		

	   
		
		
		
	}

}
