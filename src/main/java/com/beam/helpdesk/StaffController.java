package com.beam.helpdesk;

// Spring Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import static org.springframework.web.bind.annotation.RequestMethod.*;

// Java Imports
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.util.Date;

// Javax Imports
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

// Data Imports
import com.beam.helpdesk.domain.Staff;
import com.beam.helpdesk.domain.Ticket;
import com.beam.helpdesk.db.StaffRepository;
import com.beam.helpdesk.db.TicketRepository;

@Controller
@RequestMapping("/staff")
public class StaffController
{
    // -------------------------------------------------------------------------\\
    // Dependency Injection
    // -------------------------------------------------------------------------\\

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // -------------------------------------------------------------------------\\
    // Constructor
    // -------------------------------------------------------------------------\\

    @Autowired
    public StaffController(StaffRepository staffRepository)
    {
        this.staffRepository = staffRepository;
        this.ticketRepository = ticketRepository;
    }

    // -------------------------------------------------------------------------\\
    // API Methods
    // -------------------------------------------------------------------------\\

    /**
     * GET hostname:port/staff/list returns a list of all staff members
     *
     * @param model
     * @return List<Staff>
     * 
     */
    @RequestMapping(value = "/api", method = GET)
    public @ResponseBody List<Staff> getStaffList(Model model)
    {
        List<Staff> staffList = staffRepository.findAll();
        return staffList;

    }

    /**
     * GET hostname:port/staff/api/{id} returns one staff member by their Id
     *
     * @return staff/api/{id}
     * 
     */
    @RequestMapping(value = "/api/{id}", method = GET)
    public @ResponseBody Staff getCountryById(@PathVariable Long id)
    {

        Staff staff = staffRepository.findOne(id);
        return staff;
    }

    /**
     * 
     * POST API hostname:port/staff/api add one staff entity to database
     * 
     * @param staff
     * @param response
     * @return staff
     */
    @RequestMapping(value = "/api", method = POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Staff postCountry(@RequestBody Staff staff, HttpServletResponse response)
    {

        System.err.println(staff.getLastName());
        staff = staffRepository.save(staff);

        return staff;
    }

    // -------------------------------------------------------------------------\\
    // VIEW Methods
    // -------------------------------------------------------------------------\\
    /**
     * 
     * GET ALl Staff and return list
     * 
     * @param locale
     * @param model
     * @return model attributes
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getStaffList(Locale locale, Model model)
    {

        List<Staff> staffList = staffRepository.findAll();
        List<Ticket> tickitCount = ticketRepository.findAll();

        // Staff Count
        model.addAttribute("staffCounter", "Count : " + staffList.size());

        // Ticket Count
        model.addAttribute("ticketCounter", "Count : " + tickitCount.size());

        // Staff List
        model.addAttribute("allStaffMembers", staffRepository.findAll());

        // Greeting For the user
        model.addAttribute("greeting", "Staff List");

        // Used by: index.html
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        // Used by: index.html
        model.addAttribute("currentTime", dateFormat.format(new Date()));

        // CONSOLE PRINT
        System.err.println("\nStaff View Console Load Stats");
        System.err.println("-----------------------------");
        System.err.printf("Staff Count...: %s%n", staffList.size());
        System.err.printf("Ticket Count..: %s%n", tickitCount.size());
        System.err.printf(staffList.toString());

        return "staff/stafflist";
    }

    /**
     * 
     * GET Method for One Staff Member by {id}
     * 
     * @param id
     * @param locale
     * @param model
     * @return model attributes : greeting, staffCounter, ticketCounter,
     *         oneStaffMember currentTime
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStaffById(@PathVariable Long id, Locale locale, Model model)
    {
        List<Staff> staffList = staffRepository.findAll();
        List<Ticket> tickitCount = ticketRepository.findAll();

        // Conditional Re-Direct
        if (staffList.contains(staffRepository.getOne(id)))
        {
            System.err.printf("ID ( %s ) Exists in database", id.toString());
        }
        else
        {
            System.err.printf("ID ( %s ) DOES NOT Exist in Database", id.toString() );
            model.addAttribute("staffCounter", "Count - See DB Error");
            model.addAttribute("ticketCounter", "Count - See DB Error");
            return "staff/notfound";
        }
      
               
        // Greeting For the user
        model.addAttribute("greeting", "Staff by ID");

        // Staff Count
        model.addAttribute("staffCounter", "Count : " + staffList.size());

        // Ticket Count
        model.addAttribute("ticketCounter", "Count : " + tickitCount.size());

        // Used by: localhost:port/home.html
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        // Used by: localhost:port/home.html
        model.addAttribute("currentTime", dateFormat.format(new Date()));
        
        // Staff by {id}
        Staff staffOne = staffRepository.findOne(id);
        model.addAttribute("oneStaffMember", staffOne);
        
        // CONSOLE PRINT
        System.err.println("\nStaff By Id Console Load Stats");
        System.err.println("--------------------------------");
        System.err.printf(staffOne.toString());

        
        return "staff/detail";
    }

    
    @RequestMapping(value="/add", method=GET)
    public String showCreateForm(Locale locale, Model model)
    {

        // CONSOLE PRINT
        System.err.println("\nStaffForm Objects");
        System.err.println("--------------------");

        // Add StaffForm Object
        StaffForm staffForm = new StaffForm();
        model.addAttribute("staffForm", new StaffForm());
        
        List<Staff> staffList = staffRepository.findAll();
        List<Ticket> tickitCount = ticketRepository.findAll();
        
        // Greeting For the user
        model.addAttribute("greeting", "Add Staff Member");

        // Staff Count
        model.addAttribute("staffCounter", "Count : " + staffList.size());
        System.err.printf("Staff Count...: %s%n", staffList.size());
        
        // Ticket Count
        model.addAttribute("ticketCounter", "Count : " + tickitCount.size());
        System.err.printf("Ticket Count..: %s%n", tickitCount.size());        
        
        // Used by: localhost:port/home.html
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        model.addAttribute("currentTime", dateFormat.format(new Date()));
        System.err.printf("DateTime......: " +  dateFormat.format(new Date()));
        
        return "staff/add";

    }
    
    /**
     * 
     * POST new {@see com.beam.helpdesk.db.Staff}
     * 
     * @param staffForm
     *            @see {@link resources/staff/add.html}
     * @param errors
     *            if field validations fails.
     *            {@see com.beam.helpdesk.StaffForm.}
     * @return redirect to {@link hostname:potrt/staff/{id}}
     */
    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public String createStaffEntry(@Valid StaffForm staffForm, Errors errors)
    {

        System.err.println("\nInbound POST..: " + staffForm.toString());
        System.err.println("Has errors......: " + errors.hasErrors());
        
        // Create new Staff Object
        Staff staff = new Staff();

        // Add entity data from staffForm. These are @NotNull properties
        staff.setFirstName(staffForm.getFirstName());
        
        staff.setLastName(staffForm.getLastName());
        
        staff.setBadgeCode(staffForm.getBadgeCode());
        
        staff.setSkillLevel(staffForm.getSkillLevel());
        
        staff.setStatus(staffForm.getStatus());
        
        staff.setPhone(staffForm.getPhone());
        
        staff.setEmail(staffForm.getEmail());        
        System.err.println("\nOutbound to DB.: " + staff.toString() + "\n");
        
        
        // Return back to {@link resources/staff/addForm.html} form if errors != null
        // This should re-direct to an error page.
        if (errors.hasErrors())
        {
            return "staff/add";
        }

        // Save the staff entry
        staff = staffRepository.save(staff);
        

        // Redirect back to staff view : hostname:port/staff/{id}
        return "redirect:/staff/" + staff.getStaffId();
    }
    
    

}
