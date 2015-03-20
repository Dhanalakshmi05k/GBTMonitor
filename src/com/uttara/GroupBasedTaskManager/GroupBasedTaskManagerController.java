package com.uttara.GroupBasedTaskManager;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/GroupBasedTaskManager")
public class GroupBasedTaskManagerController {

	@Autowired
	@Qualifier("service")
	private GroupBasedTaskManagerSevice service;

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("inside controller");
		return "HomePage";
	}

	@RequestMapping("/employeeRegistration")
	public String ShowRegisterPageToEmployees(ModelMap model) {
		EmployeeRegistraionBean eBean = new EmployeeRegistraionBean();
		model.addAttribute("eBean", eBean);
		return "EmployeeRegisterForm";
	}

	@RequestMapping("/registerEmployee")
	public String register(
			@ModelAttribute("eBean") @Validated EmployeeRegistraionBean eBean,
			BindingResult result, ModelMap modelMap) {

		System.out.println("inside of register bean data"
				+ eBean.getFirstName());

		if (result.hasErrors()) {
			System.out.println("inside error" + result);
			modelMap.addAttribute("eBean", eBean);
			return "EmployeeRegisterForm";
		}

		String resultFromDb = service.insertEmployeeDetails(eBean);

		if (!resultFromDb.equals(Constants.SUCCESS)) {
			modelMap.addAttribute("result", resultFromDb);
			System.out.println("Returned result is " + resultFromDb);
			return "EmployeeRegisterForm";
		}

		else {
			System.out.println("result from db" + resultFromDb);
			String Status = "Registration Completed";
			modelMap.addAttribute("Status", Status);
			System.out.println("Returned result is " + resultFromDb);
			return "EmployeeRegisterForm";

		}

	}

	@RequestMapping("/showLoginView")
	public String openLoginView(ModelMap lModel) {
		LoginBean lBean = new LoginBean();
		lModel.addAttribute("lBean", lBean);
		return "Login";
	}

	@RequestMapping("/Employeeweblogin")
	public String Employeeweblogin(
			@ModelAttribute("lBean") @Valid LoginBean lbean,
			BindingResult result, ModelMap model, HttpSession session) {
		String data;
		session.putValue("loginEmailid", lbean.getEmailId());
		if (result.hasErrors()) {
			System.out.println("erros in login" + result);
			model.addAttribute("lBean", lbean);
			return "Login";
		} else {
			System.out.println("login date" + lbean);
			data = service.validateEmailIdWeb(lbean);
			System.out.println("result from db" + data);
			if (!data.contains("Success")) {
				model.addAttribute("data", data);
				return "Login";
			}
			if (data.contains("Emp")) {
				return "EmployeeView";

			} else if (data.contains("Admin")) {
				return "AdminView";
			} else if (data.contains("Manager")) {
				return "ManagerView";
			}

		}
		return "Login";
	}
	
	
	@RequestMapping("/jsonLogin")
	
	//Git Comment
	public String EmployeeAnroidlogin( HttpServletRequest req,ModelMap map) {
			String data;
			LoginBean lbean=new LoginBean();
			System.out.println("Controll is in /addCustomer");
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			lbean.setEmailId(email);
			lbean.setPassword(pass);
			System.out.println("login date" + lbean);
			data = service.validateEmailIdAndroid(lbean);
			System.out.println("result from db" + data);
			map.addAttribute("data", data);
			return "Data";
	}
	


	@RequestMapping("/addManager")
	public String openaddManagerView(ModelMap lModel) {
		ManagerBean mBean = new ManagerBean();
		lModel.addAttribute("mBean", mBean);
		return "AddManager";
	}

	@RequestMapping("/addManagerToDb")
	public String addManagerToDb(
			@ModelAttribute("mBean") @Validated ManagerBean mBean,
			BindingResult result, ModelMap modelMap) {

		System.out.println("inside of register bean data"
				+ mBean.getFirstName());

		if (result.hasErrors()) {
			System.out.println("inside error" + result);
			modelMap.addAttribute("mBean", mBean);
			return "AddManager";
		}

		String resultFromDb = service.insertManagerDetails(mBean);

		if (!resultFromDb.equals(Constants.SUCCESS)) {
			modelMap.addAttribute("result", resultFromDb);
			System.out.println("Returned result is " + resultFromDb);
			return "AddManager";
		}

		else {
			System.out.println("result from db" + resultFromDb);
			String Status = "Registration Completed";
			modelMap.addAttribute("Status", Status);
			System.out.println("Returned result is " + resultFromDb);
			return "AddManager";

		}

	}

	@RequestMapping("/AddProject")
	public String addProject(ModelMap model) {
		ProjectBean pBean = new ProjectBean();
		/*Date d = pBean.getProj_CreatedDate();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		pBean.setProj_CreatedDate(d);*/
		 pBean.setProj_CreatedDate(new Date());
		model.addAttribute("pBean", pBean);
		return "Addproject";
	}
	
	

	@RequestMapping("/addProject")
	public String addproject(
			@ModelAttribute("pBean") @Validated ProjectBean pBean,
			BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			System.out.println("inside error" + result);
			modelMap.addAttribute("pBean", pBean);
			return "Addproject";
		}

		else {
			System.out.println("project data" + pBean);
			String resultDb=service.addProject(pBean);
			System.out.println("result from db"+resultDb);
			/*System.out.println("result from db" + data);
			if (!data.contains("Success")) {
				model.addAttribute("data", data);
				return "Login";
			}*/
		}
		return "ManagerView";
	}

	@RequestMapping("/listProject")
	public String listProjectForManager(HttpSession session ){
		java.util.List<ProjectBean>projectList=service.getAllprojects();
		session.putValue("listOfProjects", projectList);
		for (int i = 0; i < projectList.size(); i++) {
			System.out.println("data" + projectList.get(i));
		}
		return "ListOfprojects";

	}
	
	
	
	@RequestMapping("/editProject")
	public String editProject(HttpServletRequest request, ModelMap model) {
		String project_sl_noString = request.getParameter("project_sl_no");
		int project_sl_no = Integer.parseInt(project_sl_noString);
		System.out.println("converted" + project_sl_no);
		ProjectBean pBean=new ProjectBean();
		model.addAttribute("pBean", pBean);
		System.out.println("printing VSlno...!!!!" + project_sl_no);
		List<ProjectBean> list = service.getProjectDataForId(project_sl_no);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list data"+ list.get(i).getProject_sl_no());
			pBean.setProject_sl_no(list.get(i).getProject_sl_no());
			pBean.setProjectName(list.get(i).getProjectName());
			pBean.setProj_CreatedDate(list.get(i).getProj_CreatedDate());
			System.out.println("desc"+list.get(i).getDescription());
			pBean.setDescription(list.get(i).getDescription());
			pBean.setTypeOfProject(list.get(i).getTypeOfProject());
		}

		return "editProjectnew";

	}

	@RequestMapping("/editProjectData")
	public String updateProjectData(ProjectBean pBean){
		System.out.println("inside submit edited data"+ pBean.getProject_sl_no());
		String Status=service.editProject(pBean);
		System.out.println("status"+Status);
		return "Success";
		
	}

	@RequestMapping("/deleteProject")
	public String deleteProject(HttpServletRequest req){
		System.out.println("delete project"+req.getParameter("project_sl_no"));
		String delSlNo = req.getParameter("project_sl_no");
		System.out.println("delete slno!!!" + delSlNo);
		int delno = Integer.parseInt(delSlNo);
		System.out.println("integer number" + delno);
		String status = service.deleteProject(delno);
		System.out.println("status" + status);
		return "Success";		
	}

	@RequestMapping("/addTask")
	public String addTask(ModelMap model) {
		TaskBean tBean=new TaskBean();
		model.addAttribute("tBean", tBean);
		return "Addtask";
	}
	
	@RequestMapping("/addTaskForProjects")
	public String addTask(@ModelAttribute("tBean") @Validated TaskBean tBean,BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			System.out.println("inside error" + result);
			modelMap.addAttribute("tBean", tBean);
			return "Addtask";
		}
		else {
			System.out.println("project data outside " + tBean);
			String resultDb=service.addTask(tBean);
			System.out.println("result from db"+resultDb);
			}
		return "Addtask";
	}
		
	@RequestMapping("/listTask")
	public String listTaskForManager(HttpSession session ){
		java.util.List<TaskBean>taskList=service.getAllTask();
		session.putValue("listOftask", taskList);
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println("data" + taskList.get(i));
		}
		return "ListOftask";

	}
	@RequestMapping("/editTask")
	public String editTask(HttpServletRequest request, ModelMap model) {
		String task_sl_noString = request.getParameter("task_sl_no");
		int task_sl_no = Integer.parseInt(task_sl_noString);
		System.out.println("converted" + task_sl_no);
		TaskBean tBean=new TaskBean();
		model.addAttribute("tBean", tBean);
		System.out.println("printing VSlno...!!!!" + task_sl_no);
		List<TaskBean> list = service.getTaskDataForId(task_sl_no);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list data"+ list.get(i).getTask_sl_no());
			tBean.setTask_sl_no(list.get(i).getTask_sl_no());
			tBean.setTaskName(list.get(i).getTaskName());
			tBean.setTaskDesc(list.get(i).getTaskDesc());
			}
		return "editTasknew";

	}
	
/*	@RequestMapping("/editTask")
	public String updateTaskData(TaskBean tBean){
		System.out.println("inside submit edited data"+ tBean.getTask_sl_no());
		String Status=service.editTask(tBean);
		System.out.println("status"+Status);
		return "Success";
		
	}*/
			@RequestMapping("/deleteTask")
			public String deleteTask(HttpServletRequest req){
				System.out.println("delete project"+req.getParameter("task_sl_no"));
				String delSlNo = req.getParameter("task_sl_no");
				System.out.println("delete slno!!!" + delSlNo);
				int delno = Integer.parseInt(delSlNo);
				System.out.println("integer number" + delno);
				String status = service.deleteTask(delno);
				System.out.println("status" + status);
				return "Success";		
			}
			
}