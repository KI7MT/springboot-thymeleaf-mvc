package com.beam.helpdesk;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beam.helpdesk.db.StaffRepository;
import com.beam.helpdesk.db.TicketRepository;
import com.beam.helpdesk.domain.Staff;
import com.beam.helpdesk.domain.Ticket;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    public HomeController(StaffRepository staffRepository, TicketRepository ticketRepository) {

      this.staffRepository = staffRepository;
      this.ticketRepository = ticketRepository;
    
    }
    
   	@RequestMapping(method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
        List<Staff> staffCount = staffRepository.findAll();
        List<Ticket> tickitCount = ticketRepository.findAll();
        
   	    // Staff Count
   	    model.addAttribute("staffCounter", "Count : " + staffCount.size());
   	    
        // Ticket Count
        model.addAttribute("ticketCounter", "Count : " + tickitCount.size());
   	    
	    // Greeting For the user
	    model.addAttribute("greeting", "Spring MVC / Thymeleaf ");

	    // Used by: index.html
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		
        // Used by: index.html
		model.addAttribute("currentTime", dateFormat.format(new Date()));

		// CONSOLE PRINT
		System.err.println("\nHome Page Console Load Stats");
	    System.err.println("-----------------------------");
	    System.err.printf("Staff Count...: %s%n", staffCount.size());
	    System.err.printf("Ticket Count..: %s%n", tickitCount.size());
	    
		return "home/home";
	}
   	
    @RequestMapping(value = "/about", method=RequestMethod.GET)
    public String about(Locale locale, Model model) {

        List<Staff> staffCount = staffRepository.findAll();
        List<Ticket> tickitCount = ticketRepository.findAll();
        
        // Staff Count
        model.addAttribute("staffCounter", "Count : " + staffCount.size());
        
        // Ticket Count
        model.addAttribute("ticketCounter", "Count : " + tickitCount.size());

        // Used by: index.html
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
        
        // Used by: index.html
        model.addAttribute("currentTime", dateFormat.format(new Date()));

        return "home/about";
    }
}