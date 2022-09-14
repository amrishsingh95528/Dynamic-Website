package com.web.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.project.entity.Admin;
import com.web.project.entity.Employee;
import com.web.project.entity.Fees;
import com.web.project.entity.Help;
import com.web.project.entity.Leave;
import com.web.project.entity.Login;
import com.web.project.entity.Manager;
import com.web.project.entity.Member;
import com.web.project.entity.Message;
import com.web.project.entity.Prospectus;
import com.web.project.entity.TTable;
import com.web.project.service.AdminService;
import com.web.project.service.EmployeeService;
import com.web.project.service.FeesService;
import com.web.project.service.HelpService;
import com.web.project.service.LeaveService;
import com.web.project.service.ManagerService;
import com.web.project.service.MemberService;
import com.web.project.service.MessageService;
import com.web.project.service.ProspectusService;
import com.web.project.service.TTableService;

@Controller
public class WebController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProspectusService prospectusService;

	@Autowired
	private TTableService ttableService;

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private HelpService helpService;
	
	@Autowired
	private MemberService memberService;
		
	private List<Member> members;
	
	@Autowired
	private FeesService feesService;
	
	@GetMapping("/findex")
	public String FIndexPage(Model model) {
		Message message=new Message();
		model.addAttribute("message", message);
		return "findex";
	}
	

	@GetMapping("/about")
	public String AboutPage() {
		return "about";
	}

	@GetMapping("/blog")
	public String BlogPage() {
		return "blog";
	}
		

	@GetMapping("/project")
	public String ProjectPage() {
		return "project";
	}

	@GetMapping("/services")
	public String ServicesPage() {
		return "services";
	}

	@GetMapping("/team")
	public String TeamPage() {
		return "team";
	}

	@GetMapping("/header")
	public String HeaderPage() {
		return "header";
	}

	@GetMapping("/footer")
	public String FooterPage() {
		return "footer";
	}

	@GetMapping("/newEmployee")
	public String NewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newEmployee";

	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/showEmployee";

	}
	
	@PostMapping("/saveEmployeeAdmin")
	public String saveEmployeeAdmin(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/showEmployeeAdmin";

	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/showEmployee";

	}

	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeService.updateEmployeeById(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";

	}
	
	@GetMapping("/updateEmployeeAdmin/{id}")
	public String updateEmployeeAdmin(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeService.updateEmployeeById(id);
		model.addAttribute("employee", employee);
		model.addAttribute("managerList", managerService.getAllManagers());
		return "updateEmployeeAdmin";

	}
	
	
	// display list of employees

	@GetMapping("/showEmployeeForEndUsers")
	public String showEmployeeForEmployee(Model model) {
		model.addAttribute("employee", employeeService.getAllEmployees());
		return "showEmployeeForEndUsers";
	}
	
	@GetMapping("/webShowEmployee")
	public String webShowEmployee(Model model) {
		model.addAttribute("employee", employeeService.getAllEmployees());
		return "webShowEmployee";
	}
	
	
		@GetMapping("/showEmployee")
		public String viewHomePage(Model model) {
			return findPaginated(1, "FullName", "asc", model);
		}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("employeeList", listEmployees);
		return "showEmployee";
	}
	
	@GetMapping("/showEmployeeAdmin")
	public String showEmployeeAdmin(Model model) {
		model.addAttribute("employeeList", employeeService.getAllEmployees());
		return "showEmployeeAdmin";

	}
	
	

	// Prospectus-Prospectus-Prospectus-Prospectus-Prospectus-Prospectus-Prospectus-Prospectus
	@GetMapping("/showProspectus")
	public String showProspectus(Model model) {
		model.addAttribute("prospectus", prospectusService.getAllProspectus());
		return "showProspectus";

	}

	@GetMapping("/webProspectus")
	public String webProspectus(Model model) {
		model.addAttribute("prospectus", prospectusService.getAllProspectus());
		return "webProspectus";

	}

	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/image";

	@GetMapping("/newProspectus")
	public String NewProspectus(Model model) {
		Prospectus prospectus = new Prospectus();
		model.addAttribute("prospectus", prospectus);
		return "newProspectus";

	}

	@PostMapping("/saveProspectus")
	public String saveProspectus(@ModelAttribute Prospectus prospectus, Model model,
			@RequestParam("files") MultipartFile[] files) {
		prospectusService.saveProspectus(prospectus);

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/showProspectus";

	}

	@GetMapping("/deleteProspectus/{id}")
	public String deleteProspectus(@PathVariable(value = "id") long id) {
		prospectusService.deleteProspectusById(id);
		return "redirect:/showProspectus";

	}

	public static String uploadDirectory2 = System.getProperty("user.dir") + "/src/main/resources/static/image";

	@GetMapping("/updateProspectus/{id}")
	public String updateProspectus(@PathVariable(value = "id") long id, Model model) {
		Prospectus prospectus = prospectusService.updateProspectusById(id);
		model.addAttribute("prospectus", prospectus);
		return "updateProspectus";

	}

	// Time Table-Time Table-Time Table-Time Table-Time Table-Time Table-Time
	// Table-Time Table
	@GetMapping("/showTTable")
	public String showTTable(Model model) {
		model.addAttribute("ttable", ttableService.getAllTTable());
		return "showTTable";

	}

	@GetMapping("/webTTable")
	public String webTTable(Model model) {
		model.addAttribute("ttable", ttableService.getAllTTable());
		return "webTTable";

	}

	public static String uploadDirectory3 = System.getProperty("user.dir") + "/src/main/resources/static/image";

	@GetMapping("/newTTable")
	public String NewTTable(Model model) {
		TTable ttable = new TTable();
		model.addAttribute("ttable", ttable);
		return "newTTable";

	}

	@PostMapping("/saveTTable")
	public String saveTTable(@ModelAttribute TTable ttable, Model model, @RequestParam("files") MultipartFile[] files) {
		ttableService.saveTTable(ttable);

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/showTTable";

	}

	@GetMapping("/deleteTTable/{id}")
	public String deleteTTable(@PathVariable(value = "id") long id) {
		ttableService.deleteTTableById(id);
		return "redirect:/showTTable";

	}

	public static String uploadDirectory4 = System.getProperty("user.dir") + "/src/main/resources/static/image";

	@GetMapping("/updateTTable/{id}")
	public String updateTTable(@PathVariable(value = "id") long id, Model model) {
		TTable ttable = ttableService.updateTTableById(id);
		model.addAttribute("ttable", ttable);
		return "updateTTable";

	}

	// Login
	// -Login-Login-Login-Login-Login-Login-Login-Login-Login-Login-Login-Login-Login-Login
	@GetMapping("/login")
	public String login(Model model) {
		Login login=new Login();
		model.addAttribute("login", login);
		return "Login";

	}

	@PostMapping("/varifylogin")
	public String login(@ModelAttribute("login") Login user, Model model) {
		model.addAttribute("employeeCount", employeeService.getCountOfEmployee());
		model.addAttribute("messageCount", messageService.getMessageCount());
		model.addAttribute("prospectusCount", prospectusService.getProspectusCount());
		model.addAttribute("ttableCount", ttableService.getAllTTableCount());
		model.addAttribute("adminCount", adminService.getAllAdmin());
		model.addAttribute("helpdeskCount", helpService.getAllHelp());
		model.addAttribute("leaveCount", leaveService.getAllLeave());
		model.addAttribute("managerCount", managerService.getAllManagers());
		model.addAttribute("sc_Count", memberService.findAll());
		model.addAttribute("messageCount", messageService.getAllMessage());
		model.addAttribute("feesCount", feesService.getAllFees());
		
		List<Employee> oauthUser = employeeService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		System.out.print(oauthUser);
		model.addAttribute("username", user.getUsername());
		if (oauthUser.isEmpty()) {

			return "redirect:/login";

		} else {
			return "index";

		}

	}
	
	
	@PostMapping("/logout")
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/findex";
    }
	
	//Message-Message-Message-Message-Message-Message-Message-Message-Message-Message-Message-Message
	@GetMapping("/newMessage")
	public String newMessage(Model model) {
		Message message=new Message();
		model.addAttribute("message", message);
		return "contact";
	}
	@PostMapping("/saveMessage")
	public String saveMessage(@ModelAttribute Message message) {
		messageService.saveMessage(message);
		return "redirect:/newMessage";
	}
	
	@PostMapping("/saveIndexMessage")
	public String saveIndexMessage(@ModelAttribute Message message) {
		messageService.saveMessage(message);
		return "redirect:/findex";
	}
	
	@GetMapping("/showMessage")
	public String showMessage(Model model) {
		model.addAttribute("message", messageService.getAllMessage());
		return "showMessage";

	}
	@GetMapping("/deleteMessage/{id}")
	public String deleteMessageId(@PathVariable(value="id") long id) {
		this.messageService.deleteMessageById(id);
		return "redirect:/showMessage";
	}
	
	@GetMapping("/base")
	public String basePage() {
		return "base";
	}
	
	// display list of Managers-display list of Managers-display list of Managers-display list of Managers
	@GetMapping("/showManager")
	public String showManager(Model model) {
		model.addAttribute("managerList", managerService.getAllManagers());
		return "showManager";
	}
	
		@GetMapping("/newManager")
		public String NewManager(Model model) {
			Manager manager=new Manager();
			model.addAttribute("manager", manager);
			return "newManager";

		}

		@PostMapping("/saveManager")
		public String saveManager(@ModelAttribute Manager manager) {
			managerService.saveManager(manager);
			return "redirect:/showManager";

		}

		@GetMapping("/deleteManager/{id}")
		public String deleteManager(@PathVariable(value = "id") long id) {
			managerService.deleteManagerById(id);
			return "redirect:/showManager";

		}

		@GetMapping("/updateManager/{id}")
		public String updateManager(@PathVariable(value = "id") long id, Model model) {
			Manager manager = managerService.updateManagerById(id);
			model.addAttribute("manager", manager);
			return "updateManager";

		}
		
		@GetMapping("/managerLogin")
		public String managerLogin(Model model) {
			Login login=new Login();
			model.addAttribute("login", login);
			return "managerLogin";

		}
		
		@PostMapping("/managerIndex")
		public String loginManager(@ModelAttribute("login") Login user, Model model) {
			model.addAttribute("employeeCount", employeeService.getCountOfEmployee());
			model.addAttribute("messageCount", messageService.getMessageCount());
			model.addAttribute("prospectusCount", prospectusService.getProspectusCount());
			model.addAttribute("ttableCount", ttableService.getAllTTableCount());
			model.addAttribute("adminCount", adminService.getAllAdmin());
			model.addAttribute("helpdeskCount", helpService.getAllHelp());
			model.addAttribute("leaveCount", leaveService.getAllLeave());
			model.addAttribute("managerCount", managerService.getAllManagers());
			model.addAttribute("sc_Count", memberService.findAll());
			model.addAttribute("messageCount", messageService.getAllMessage());
			model.addAttribute("feesCount", feesService.getAllFees());

			List<Manager> oauthUser = managerService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

			System.out.print(oauthUser);
			model.addAttribute("username", user.getUsername());
			if (oauthUser.isEmpty()) {

				return "redirect:/managerLogin";

			} else {
				return "managerIndex";

			}

		}
		
		@PostMapping("/managerLogout")
	    public String logoutDo1(HttpServletRequest request,HttpServletResponse response)
	    {
	    
	  
	        return "redirect:/findex";
	    }
		
		
		//Admin Dashboard-Admin Dashboard-Admin Dashboard-Admin Dashboard-Admin Dashboard
		
		@GetMapping("/showAdmin")
		public String showAdmin(Model model) {
			model.addAttribute("adminList", adminService.getAllAdmin());
			return "showAdmin";
		}
		
		
		@GetMapping("/newAdmin")
		public String NewAdmin(Model model) {
			Admin admin=new Admin();
			model.addAttribute("admin", admin);
			return "newAdmin";

		}

		@PostMapping("/saveAdmin")
		public String saveAdmin(@ModelAttribute Admin admin) {
			adminService.saveAdmin(admin);
			return "redirect:/showAdmin";

		}

		@GetMapping("/deleteAdmin/{id}")
		public String deleteAdmin(@PathVariable(value = "id") long id) {
			adminService.deleteAdminById(id);
			return "redirect:/showAdmin";

		}

		@GetMapping("/updateAdmin/{id}")
		public String updateAdmin(@PathVariable(value = "id") long id, Model model) {
			Admin admin = adminService.updateAdminById(id);
			model.addAttribute("admin", admin);
			return "updateAdmin";

		}
		
		@GetMapping("/adminLogin")
		public String adminLogin(Model model) {
			Login login=new Login();
			model.addAttribute("login", login);
			return "adminLogin";

		}
		
		@PostMapping("/adminIndex")
		public String loginAdmin(@ModelAttribute("login") Login user, Model model) {
			model.addAttribute("employeeCount", employeeService.getCountOfEmployee());
			model.addAttribute("messageCount", messageService.getMessageCount());
			model.addAttribute("prospectusCount", prospectusService.getProspectusCount());
			model.addAttribute("ttableCount", ttableService.getAllTTableCount());
			model.addAttribute("adminCount", adminService.getAllAdmin());
			model.addAttribute("helpdeskCount", helpService.getAllHelp());
			model.addAttribute("leaveCount", leaveService.getAllLeave());
			model.addAttribute("managerCount", managerService.getAllManagers());
			model.addAttribute("sc_Count", memberService.findAll());
			model.addAttribute("messageCount", messageService.getAllMessage());
			model.addAttribute("feesCount", feesService.getAllFees());

			List<Admin> oauthUser = adminService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

			System.out.print(oauthUser);
			model.addAttribute("username", user.getUsername());
			if (oauthUser.isEmpty()) {

				return "redirect:/adminLogin";

			} else {
				return "adminIndex";

			}

		}
		
		@PostMapping("/adminLogout")
	    public String logoutDo11(HttpServletRequest request,HttpServletResponse response)
	    {
	    
	  
	        return "redirect:/logout";
	    }
		
		//leave-leave-leave-leave-leave-leave-leave-leave-leave-leave-leave-leave-leave
		@GetMapping("/showLeave")
		public String showLeave(Model model) {
			model.addAttribute("leaveList", leaveService.getAllLeave());
			return "showLeave";
		}
		
		
		@GetMapping("/newLeave")
		public String NewLeave(Model model) {
			Leave leave=new Leave();
			model.addAttribute("leave", leave);
			return "newLeave";

		}
		@PostMapping("/saveEmployeeLeave")
		public String saveEmployeeLeave(@ModelAttribute Leave leave) {
			leaveService.saveLeave(leave);
			return "redirect:/newLeave";

		}
		
		@PostMapping("/saveLeave")
		public String saveLeave(@ModelAttribute Leave leave) {
			leaveService.saveLeave(leave);
			return "redirect:/showLeave";

		}

		@GetMapping("/deleteLeave/{id}")
		public String deleteLeave(@PathVariable(value = "id") long id) {
			leaveService.deleteLeaveById(id);
			return "redirect:/showLeave";

		}

		@GetMapping("/updateLeave/{id}")
		public String updateLeave(@PathVariable(value = "id") long id, Model model) {
			Leave leave = leaveService.updateLeaveById(id);
			model.addAttribute("leave", leave);
			return "updateLeave";

		}
		@GetMapping("/employee_view")
		public String employeeView(Model model) {
			model.addAttribute("leaveList", leaveService.getAllLeave());
			return "employee_view";
		}
		
		//Help Desk-Help Desk-Help Desk-Help Desk-Help Desk-Help Desk-Help Desk-Help Desk-
		@GetMapping("/showHelp")
		public String showHelp(Model model) {
			model.addAttribute("helpList", helpService.getAllHelp());
			return "showHelp";
		}
		
		@GetMapping("/empl_view")
		public String EmployeeView(Model model) {
			model.addAttribute("helpList", helpService.getAllHelp());
			return "empl_view";
		}
		
		@GetMapping("/newHelp")
		public String NewHelp(Model model) {
			Help help=new Help();
			model.addAttribute("help", help);
			return "newHelp";

		}
		
		@PostMapping("/saveHelp")
		public String saveHelp(@ModelAttribute Help help) {
			helpService.saveHelp(help);
			return "redirect:/newHelp";

		}
		
		@PostMapping("/saveHelpEmpl")
		public String saveHelpEmployee(@ModelAttribute Help help) {
			helpService.saveHelp(help);
			return "redirect:/showHelp";

		}
		
		@GetMapping("/updateHelp/{id}")
		public String updateHelp(@PathVariable(value = "id") long id, Model model) {
			Help help = helpService.updateHelpById(id);
			model.addAttribute("help", help);
			return "updateHelp";

		}
		
		// select Study Center-select Study Center-select Study Center-select Study Center-select Study Center
		@GetMapping("/studyCenter")
		public String studyCenter() {
			return "studyCenter";

		}
		
		//search functionality-search functionality-search functionality-search functionality-search functionality-search functionality
		
		
		@GetMapping("/members")
		public String showPage(Model model, String keyword) {
			members = new ArrayList<>();
			members = memberService.findAll();
			
			if(keyword!=null) {
				model.addAttribute("members", memberService.findByKeyword(keyword));
			} else {
				model.addAttribute("members", members);
			}
			return "home";
		}
		
		@GetMapping("/members/add")
		public String addMember(Model model) {
			Member member = new Member();
			model.addAttribute("member", member);
			return "member-form";
		}
		
		@PostMapping("/members/save")
		public String saveMember(@ModelAttribute("member") Member member) {
			
			memberService.saveMember(member);
			return "redirect:/members";
		}
		
		@GetMapping("/members/update")
		public String updateMember(@RequestParam("memberId") int memberId, Model model) {
			Member member = memberService.getMember(memberId);
			model.addAttribute("member", member);
			return "member-form";
		}
		
		@GetMapping("/members/delete")
		public String deleteMember(@RequestParam("memberId") int memberId) {
			Member member = memberService.getMember(memberId);
			memberService.deleteMember(memberId);
			return "redirect:/members";
		
	}
		
	@GetMapping("/form")
	public String getForm() {
		return "form";
	}
	
	
		// Fees Structure-Fees Structure-Fees Structure-Fees Structure-Fees Structure-Fees Structure-Fees Structure
			@GetMapping("/showFees")
			public String showFees(Model model) {
				model.addAttribute("feesList", feesService.getAllFees());
				return "showFees";
			}
			
			
			@GetMapping("/newFees")
			public String NewFees(Model model) {
				Fees fees=new Fees();
				model.addAttribute("fees", fees);
				return "newFees";

			}

			@PostMapping("/saveFees")
			public String saveFees(@ModelAttribute Fees fees) {
				feesService.saveFees(fees);
				return "redirect:/showFees";

			}

			@GetMapping("/deleteFees/{id}")
			public String deleteFees(@PathVariable(value = "id") long id) {
				feesService.deleteFeesById(id);
				return "redirect:/showFees";

			}

			@GetMapping("/updateFees/{id}")
			public String updateFees(@PathVariable(value = "id") long id, Model model) {
				Fees fees = feesService.updateFeesById(id);
				model.addAttribute("fees", fees);
				return "updateFees";

			}

}