package com.uttara.GroupBasedTaskManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component("service")
public class GroupBasedTaskManagerSevice {

	public String insertEmployeeDetails(EmployeeRegistraionBean eBean) {
		System.out.println("inside Service");
		System.out.println("data" + eBean.getFirstName());
		Connection con = null;
		ResultSet rs1 = null;
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null, ps_ins4 = null;
		con = JDBCHelper.getConnection();
		try {
			String sql2 = "SELECT * FROM EMPLOYEEDETAILS  where email=?";
			ps_ins1 = con.prepareStatement(sql2);
			ps_ins1.setString(1, eBean.getEmail());
			ps_ins1.execute();
			rs1 = ps_ins1.getResultSet();
			while (rs1.next()) {
				return "Already Registered<br>";
			}
			String sql = "INSERT INTO EMPLOYEEDETAILS(FIRSTNAME, LASTNAME,EMAIL,PHONENUMBER,PASSWORD,ROLE_SL_NO)"
					+ "VALUES (?,?,?,?,?,?)";
			ps_ins = con.prepareStatement(sql);
			ps_ins.setString(1, eBean.getFirstName());
			ps_ins.setString(2, eBean.getLastName());
			ps_ins.setString(3, eBean.getEmail());
			ps_ins.setString(4, eBean.getPhoneNumber());
			ps_ins.setString(5, eBean.getPassword());
			ps_ins.setInt(6, 1);
			ps_ins.execute();
			System.out.println("Employee Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Constants.SUCCESS;
	}

	public String validateEmailIdWeb(LoginBean lbean) {
		System.out.println("login bean data" + lbean);
		Connection con = null;
		PreparedStatement ps_ins = null, ps_ins1 = null;
		ResultSet rs1 = null, rs2 = null;
		JSONObject json = new JSONObject();
		// TraiService service=new TraiService();
		String passFromDb = "";
		int sl_no;
		int role_sl_no;
		String emailId = "";
		String role = "";
		boolean flag = false;
		try {
			con = JDBCHelper.getConnection();
			String sql2 = "SELECT * FROM EMPLOYEEDETAILS  where email= ?";
			ps_ins = con.prepareStatement(sql2);
			ps_ins.setString(1, lbean.getEmailId());
			ps_ins.execute();
			rs1 = ps_ins.getResultSet();
			while (rs1.next()) {
				flag = true;
				passFromDb = rs1.getString("password");
				sl_no = rs1.getInt("emp_sl_no");
				System.out.println("sl no from db is " + sl_no);
				emailId = rs1.getString("email");
				System.out.println("emailid" + emailId);
				role_sl_no = rs1.getInt("role_sl_no");
				String Sql3 = "SELECT role_name FROM ROLE where role_sl_no=?";
				ps_ins = con.prepareStatement(Sql3);
				ps_ins.setInt(1, role_sl_no);
				ps_ins.execute();
				rs2 = ps_ins.getResultSet();
				while (rs2.next()) {
					role = rs2.getString("role_name");
					System.out.println("role from db" + role);
				}
			}
			String message = "Email id is not found";
			if (flag == true) {
				if (!(lbean.getPassword().equals(passFromDb))) {
					System.out.println("both id same" + lbean.getPassword()
							+ "from db" + passFromDb);
					message = "Enter correct password";
					return message;
				}
			} else {

				System.out.println("Control is here");
				message = "Enter correct Email id";
				return message;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return role+"Success";

		
	}

	public String insertManagerDetails(ManagerBean eBean) {
		System.out.println("inside Service");
		System.out.println("data" + eBean.getFirstName());
		Connection con = null;
		ResultSet rs1 = null;
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null, ps_ins4 = null;
		con = JDBCHelper.getConnection();
		try {

			String sql2 = "SELECT * FROM EMPLOYEEDETAILS  where email=?";
			ps_ins1 = con.prepareStatement(sql2);
			ps_ins1.setString(1, eBean.getEmail());
			ps_ins1.execute();
			rs1 = ps_ins1.getResultSet();
			while (rs1.next()) {
				return "Already Registered<br>";
			}
			String sql = "INSERT INTO EMPLOYEEDETAILS(FIRSTNAME, LASTNAME,EMAIL,PHONENUMBER,PASSWORD,ROLE_SL_NO)"
					+ "VALUES (?,?,?,?,?,?)";
			ps_ins = con.prepareStatement(sql);
			ps_ins.setString(1, eBean.getFirstName());
			ps_ins.setString(2, eBean.getLastName());
			ps_ins.setString(3, eBean.getEmail());
			ps_ins.setString(4, eBean.getPhoneNumber());
			ps_ins.setString(5, eBean.getPassword());
			ps_ins.setInt(6, 2);
			ps_ins.execute();
			System.out.println("Employee Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Constants.SUCCESS;
	}

	public static int getEmployeeSlnoForEmployee(String email) {
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null, ps_ins4 = null, ps_ins5 = null;
		ResultSet rs1 = null, rs2 = null;
		int empslno = 0, empslnoTask = 0;
		Connection con = JDBCHelper.getConnection();

		String inter1Sql = "SELECT emp_sl_no FROM EMPLOYEEDETAILS where  email=?";
		try {
			ps_ins1 = con.prepareStatement(inter1Sql);
			ps_ins1.setString(1, email);
			ps_ins1.execute();
			rs1 = ps_ins1.getResultSet();
			while (rs1.next()) {
				empslno = rs1.getInt("emp_sl_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* ps_ins2.setString(1, pBean.getEmployeeName()); */
		return empslno;

	}

	public static  boolean CheckuniqueProject(String projectName) {
		PreparedStatement ps_sel = null;
		ResultSet rs1 = null;
		Connection con = JDBCHelper.getConnection();
		try {
			String sql = "SELECT * FROM PROJECTDETAILS where projectname=?";
			ps_sel = con.prepareStatement(sql);
			ps_sel.setString(1, projectName);
			ps_sel.execute();
			rs1=ps_sel.getResultSet();
			if(rs1.next()) {
				return false;
			}
			else{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static  int getSlnoProject(String projectName) {
		PreparedStatement ps_sel = null;
		ResultSet rs1 = null;
		Connection con = JDBCHelper.getConnection();
		int pSlNo = 0;
		try {
			String sql = "SELECT project_sl_no FROM PROJECTDETAILS where projectname=?";
			ps_sel = con.prepareStatement(sql);
			ps_sel.setString(1, projectName);
			ps_sel.execute();
			rs1=ps_sel.getResultSet();
			while (rs1.next()) {
			 pSlNo=rs1.getInt("project_sl_no");
			 System.out.println("inside method get sl number"+pSlNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pSlNo;

	}

	public String addProject(ProjectBean pBean) {
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null, ps_ins4 = null, ps_ins5 = null;
		ResultSet rs1 = null, rs2 = null;
		int empslno = 0, empslnoTask = 0;
		Connection con = JDBCHelper.getConnection();
		try {
			boolean status=GroupBasedTaskManagerSevice.CheckuniqueProject(pBean.getProjectName());
			if(status==true){
			String sql = "INSERT INTO PROJECTDETAILS(PROJECTNAME,PROJ_CREATEDDATE,DESCRIPTION,TYPEOFPROJECT,status,MANAGER_SL_NO)VALUES (?,?,?,?,?,?)";
			ps_ins = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps_ins.setString(1, pBean.getProjectName());
			ps_ins.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			ps_ins.setString(3, pBean.getDescription());
			ps_ins.setString(4, pBean.getTypeOfProject());
			ps_ins.setString(5, "new");
			//thsi is know which manager has added that particular project input should be given from andoird
			empslno = GroupBasedTaskManagerSevice
					.getEmployeeSlnoForEmployee("manager1@gmail.com");
			ps_ins.setInt(6, empslno);
			ps_ins.execute();
			ResultSet rs = ps_ins.getGeneratedKeys();
			int db_cont_sl_no = 0;
			if (rs.next()) {
				db_cont_sl_no = rs.getInt(1);
			System.out.println("@@@@@@@@@@@@@ sl no is " + db_cont_sl_no);
			System.out.println("DB SL No is " + db_cont_sl_no);
			System.out.println("project Data Inserted");
			}
			System.out.println("data inserted for taskintercommunication table");
			}else{
				return"project already exists";
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
			/*String sql1 = "INSERT INTO TASKDETAILS(STATUS,TASKNAME,TASKDESC,TASKCREATEDDATE,TASKCOMPLETIONDATE,PRIORITY,emp_sl_no,project_sl_no)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			ps_ins1 = con.prepareStatement(sql1,
					Statement.RETURN_GENERATED_KEYS);
			ps_ins1.setString(1, "new");
			ps_ins1.setString(2, pBean.getTaskName());
			ps_ins1.setString(3, pBean.getTaskDesc());
			ps_ins1.setDate(4,
					new java.sql.Date(new java.util.Date().getTime()));
			ps_ins1.setDate(5,
					new java.sql.Date(new java.util.Date().getTime()));
			ps_ins1.setInt(6, pBean.getPriority());
			int emp_sl_no = GroupBasedTaskManagerSevice
					.getEmployeeSlnoForEmployee("test@test.com");
			System.out.println("emplyso" + emp_sl_no);
			ps_ins1.setInt(7, emp_sl_no);
			ps_ins1.setInt(8, db_cont_sl_no);
			ps_ins1.execute();
			ResultSet rstask = ps_ins1.getGeneratedKeys();
			int db_cont_sl_notask = 0;
			if (rstask.next()) {
				db_cont_sl_notask = rstask.getInt(1);
			}
			System.out.println("task Data Inserted" + db_cont_sl_no);
			String sql2 = "INSERT INTO TEAMMEMBERS(EMP_SL_NO,TASK_SL_NO,PROJECT_SL_NO)VALUES (?,?,?)";
			ps_ins2 = con.prepareStatement(sql2);
			int employeeslno = GroupBasedTaskManagerSevice
					.getEmployeeSlnoForEmployee("test@test.com");
			ps_ins2.setInt(1, employeeslno);
			ps_ins2.setInt(2, db_cont_sl_notask);
			ps_ins2.setInt(3, db_cont_sl_no);
			System.out.println("Emp No:" + employeeslno + ", Task : "
					+ db_cont_sl_notask + ", Project : " + db_cont_sl_no);
			ps_ins2.execute();
			}*/
			
			/*
			 * String sql3=
			 * "INSERT INTO PROJECTINTERCOMMUNICATION(EMP_SL_NO,PROJECT_SL_NO) VALUES ( ?, ?)"
			 * ; ps_ins2 = con.prepareStatement(sql3); String inter1Sql=
			 * "SELECT emp_sl_no FROM EMPLOYEEDETAILS where  email='sam@gmail.com'"
			 * ; ps_ins3 = con.prepareStatement(inter1Sql); ps_ins2.setString(1,
			 * pBean.getEmployeeName()); ps_ins3.execute(); rs1 =
			 * ps_ins3.getResultSet(); while (rs1.next()) {
			 * empslno=rs1.getInt("emp_sl_no"); } ps_ins2.setInt(1,empslno);
			 * ps_ins2.setInt(2,db_cont_sl_no); ps_ins2.execute();
			 * System.out.println("intermediaet sql excuted ");
			 * 
			 * String sql4=
			 * "INSERT INTO TASKINTERCOMMUNICATION(EMP_SL_NO,PROJECT_SL_NO,TASK_SL_NO) VALUES (?,?,?)"
			 * ; ps_ins4 = con.prepareStatement(sql4); String inter2Sql=
			 * "SELECT emp_sl_no FROM EMPLOYEEDETAILS where  email='sam@gmail.com'"
			 * ; ps_ins5 = con.prepareStatement(inter2Sql); ps_ins2.setString(1,
			 * pBean.getEmployeeName()); ps_ins5.execute(); rs2 =
			 * ps_ins5.getResultSet(); while (rs2.next()) {
			 * empslnoTask=rs2.getInt("emp_sl_no"); }
			 * System.out.println("empslnoTask"+empslnoTask);
			 * ps_ins4.setInt(1,empslnoTask);
			 * System.out.println("db_cont_sl_no"+db_cont_sl_no);
			 * ps_ins4.setInt(2,db_cont_sl_no);
			 * System.out.println("db_cont_sl_notask"+db_cont_sl_notask);
			 * ps_ins4.setInt(3, db_cont_sl_notask); ps_ins4.execute();
			 */
			
		return Constants.SUCCESS;
	}

	public java.util.List<ProjectBean> getAllprojects() {
		Connection con = null;
		PreparedStatement ps_ins = null, ps_ins1;
		ResultSet rs1 = null;
		ProjectBean pBean;
		java.util.List<ProjectBean> projectListBean = new ArrayList<ProjectBean>();
		try {
			con = JDBCHelper.getConnection();
			String sql = "SELECT * FROM PROJECTDETAILS";
			ps_ins1 = con.prepareStatement(sql);
			ps_ins1.execute();
			rs1 = ps_ins1.getResultSet();
			while (rs1.next()) {
				pBean = new ProjectBean();
				System.out.println("resultset Not Empty..!!!"
						+ rs1.getString("projectname"));
				pBean.setProject_sl_no(rs1.getInt("PROJECT_SL_NO"));
				pBean.setProjectName(rs1.getString("PROJECTNAME"));
				pBean.setProj_CreatedDate(rs1.getDate("PROJ_CREATEDDATE"));
				pBean.setDescription(rs1.getString("DESCRIPTION"));
				pBean.setTypeOfProject(rs1.getString("TYPEOFPROJECT"));
				projectListBean.add(pBean);
				/* return projectListBean; */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectListBean;
	}

	public List<ProjectBean> getProjectDataForId(int project_sl_no) {
		System.out.println("sl number is" + project_sl_no);
		DateHelper helper = null;
		Connection con = null;
		ResultSet rs1 = null;
		ProjectBean pBean = null;
		java.util.List<ProjectBean> editList = new ArrayList<ProjectBean>();
		PreparedStatement ps_sel = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null;
		try {

			con = JDBCHelper.getConnection();
			String sql2 = "SELECT * FROM PROJECTDETAILS where project_sl_no=?";
			ps_sel = con.prepareStatement(sql2);
			ps_sel.setInt(1, project_sl_no);
			ps_sel.execute();
			rs1 = ps_sel.getResultSet();
			while (rs1.next()) {
				pBean = new ProjectBean();
				System.out.println(rs1.getInt("project_sl_no"));
				pBean.setProject_sl_no(rs1.getInt("project_sl_no"));
				pBean.setProjectName(rs1.getString("projectName"));
				pBean.setProj_CreatedDate(rs1.getDate("proj_CreatedDate"));
				pBean.setDescription(rs1.getString("description"));
				System.out.println("project desc"
						+ rs1.getString("description"));
				pBean.setTypeOfProject(rs1.getString("typeOfProject"));
				System.out.println("project type"
						+ rs1.getString("typeOfProject"));
				editList.add(pBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editList;

	}

	public String editProject(ProjectBean pBean) {
		System.out.println("prject edited data" + pBean);
		DateHelper helper = null;
		Connection con = null;
		ResultSet rs1 = null;
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null;
		try {
			con = JDBCHelper.getConnection();
			String sql2 = "UPDATE PROJECTDETAILS SET PROJECTNAME=?,DESCRIPTION=?,TYPEOFPROJECT=? where project_sl_no=?";
			ps_ins2 = con.prepareStatement(sql2);
			ps_ins2.setString(1, pBean.getProjectName());
			ps_ins2.setString(2, pBean.getDescription());
			ps_ins2.setString(3, pBean.getTypeOfProject());
			ps_ins2.setInt(4, pBean.getProject_sl_no());
			ps_ins2.execute();
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.SUCCESS;

	}

	public String deleteProject(int delno) {
		System.out.println("slno delete verifier" + delno);
		Connection con = null;
		ResultSet rs1 = null;
		ProjectBean pBean = null;
		java.util.List<ProjectBean> List = new ArrayList<ProjectBean>();
		PreparedStatement ps_del= null,ps_del1;
		try {
			con = JDBCHelper.getConnection();
			String sql = "DELETE FROM TASKDETAILS where project_sl_no=?";
			ps_del = con.prepareStatement(sql);
			ps_del.setInt(1, delno);
			ps_del.execute();
			System.out.println("deleted from task table");
			String sql1 = "DELETE FROM PROJECTDETAILS where project_sl_no=?";
			ps_del1 = con.prepareStatement(sql1);
			ps_del1.setInt(1, delno);
			ps_del1.execute();
			System.out.println("deleted from project table");


		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.SUCCESS;
		// TODO Auto-generated method stub

	}

	public String addTask(TaskBean tBean) {
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null, ps_ins4 = null, ps_ins5 = null;
		ResultSet rs1 = null, rs2 = null;
		int empslno = 0, empslnoTask = 0;
		Connection con = JDBCHelper.getConnection();
		System.out.println("inside add task service"+tBean);
		try {
			String sql1 = "INSERT INTO TASKDETAILS(STATUS,TASKNAME,TASKDESC,TASKCREATEDDATE,TASKCOMPLETIONDATE,PRIORITY,emp_sl_no,project_sl_no)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			ps_ins1 = con.prepareStatement(sql1,
					Statement.RETURN_GENERATED_KEYS);
			ps_ins1.setString(1,"new");
			ps_ins1.setString(2, tBean.getTaskName());
			ps_ins1.setString(3, tBean.getTaskDesc());
			ps_ins1.setDate(4,
					new java.sql.Date(new java.util.Date().getTime()));
			ps_ins1.setDate(5,
					new java.sql.Date(new java.util.Date().getTime()));
			ps_ins1.setInt(6, tBean.getPriority());
			int emp_sl_no = GroupBasedTaskManagerSevice
					.getEmployeeSlnoForEmployee("employee1@gmail.com");
			System.out.println("emplyso" + emp_sl_no);
			ps_ins1.setInt(7, emp_sl_no);
			System.out.println("project name"+tBean.getProjectName());
			int projectSlNo=GroupBasedTaskManagerSevice.getSlnoProject(tBean.getProjectName());
			System.out.println("projectSlNo"+projectSlNo);
			ps_ins1.setInt(8, projectSlNo);
			ps_ins1.execute();
			ResultSet rstask = ps_ins1.getGeneratedKeys();
			int db_cont_sl_notask = 0;
			if (rstask.next()) {
				db_cont_sl_notask = rstask.getInt(1);
			}
			/*System.out.println("task Data Inserted" + db_cont_sl_no);
			String sql2 = "INSERT INTO TEAMMEMBERS(EMP_SL_NO,TASK_SL_NO,PROJECT_SL_NO)VALUES (?,?,?)";
			ps_ins2 = con.prepareStatement(sql2);
			int employeeslno = GroupBasedTaskManagerSevice
					.getEmployeeSlnoForEmployee("test@test.com");
			ps_ins2.setInt(1, employeeslno);
			ps_ins2.setInt(2, db_cont_sl_notask);
			ps_ins2.setInt(3, db_cont_sl_no);
			System.out.println("Emp No:" + employeeslno + ", Task : "
					+ db_cont_sl_notask + ", Project : " + db_cont_sl_no);
			ps_ins2.execute();
			}
			else{
				return"project already exists";
			}
			 */		
		}catch(Exception e){
			e.printStackTrace();
		}
		return Constants.SUCCESS;

	}

	public List<TaskBean> getAllTask() {
		Connection con = null;
		PreparedStatement ps_ins = null, ps_ins1;
		ResultSet rs1 = null;
		TaskBean tBean;
		java.util.List<TaskBean> taskListBean = new ArrayList<TaskBean>();
		try {
			con = JDBCHelper.getConnection();
			String sql = "SELECT * FROM TASKDETAILS";
			ps_ins1 = con.prepareStatement(sql);
			ps_ins1.execute();
			rs1 = ps_ins1.getResultSet();
			while (rs1.next()) {
				tBean = new TaskBean();
				tBean.setTask_sl_no(rs1.getInt("task_SL_NO"));
				tBean.setTaskName(rs1.getString("taskname"));
				tBean.setTaskDesc(rs1.getString("taskdesc"));
				tBean.setPriority(rs1.getInt("priority"));
				taskListBean.add(tBean);
				/* return projectListBean; */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskListBean;
	}

	public List<TaskBean> getTaskDataForId(int task_sl_no) {
		Connection con = null;
		PreparedStatement ps_ins = null, ps_ins1;
		ResultSet rs1 = null;
		TaskBean tBean;
		java.util.List<TaskBean> taskListBean = new ArrayList<TaskBean>();
		try {
			con = JDBCHelper.getConnection();
			String sql = "SELECT * FROM TASKDETAILS where task_sl_no=?";
			ps_ins1 = con.prepareStatement(sql);
			ps_ins1.setInt(1,task_sl_no );
			ps_ins1.execute();
			rs1 = ps_ins1.getResultSet();
			while (rs1.next()) {
				tBean = new TaskBean();
				tBean.setTask_sl_no(rs1.getInt("task_SL_NO"));
				tBean.setTaskName(rs1.getString("taskname"));
				tBean.setTaskDesc(rs1.getString("taskdesc"));
				tBean.setPriority(rs1.getInt("priority"));
				taskListBean.add(tBean);
				/* return projectListBean; */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskListBean;

	}

	public String editTask(TaskBean tBean) {
		System.out.println("prject edited data" + tBean);
		DateHelper helper = null;
		Connection con = null;
		ResultSet rs1 = null;
		PreparedStatement ps_ins = null, ps_ins1 = null, ps_ins2 = null, ps_ins3 = null;
		try {
			con = JDBCHelper.getConnection();
			String sql2 = "UPDATE TASKDETAILS  SET taskname=?,taskdesc=?,priority=? where task_sl_no=?";
			ps_ins2 = con.prepareStatement(sql2);
			ps_ins2.setString(1, tBean.getTaskName());
			ps_ins2.setString(2, tBean.getTaskDesc());
			ps_ins2.setInt(3, tBean.getPriority());
			ps_ins2.setInt(4, tBean.getTask_sl_no());
			ps_ins2.execute();
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.SUCCESS;

	}

	public String deleteTask(int delno) {
		System.out.println("slno delete task" + delno);
		Connection con = null;
		ResultSet rs1 = null;
		ProjectBean pBean = null;
		java.util.List<ProjectBean> List = new ArrayList<ProjectBean>();
		PreparedStatement ps_del= null,ps_del1;
		try {
			con = JDBCHelper.getConnection();
			String sql = "DELETE FROM TASKDETAILS where task_sl_no=?";
			ps_del = con.prepareStatement(sql);
			ps_del.setInt(1, delno);
			ps_del.execute();
			System.out.println("deleted from task table");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.SUCCESS;
		

	}
	
	
	
	public String validateEmailIdAndroid(LoginBean lbean) {
		System.out.println("login bean data" + lbean);
		Connection con = null;
		PreparedStatement ps_ins = null, ps_ins1 = null;
		ResultSet rs1 = null, rs2 = null;
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		// TraiService service=new TraiService();
		String passFromDb = "";
		int sl_no;
		int role_sl_no;
		String emailId = "";
		String role = "";
		boolean flag = false;
		try {
			con = JDBCHelper.getConnection();
			String sql2 = "SELECT * FROM EMPLOYEEDETAILS  where email= ?";
			ps_ins = con.prepareStatement(sql2);
			ps_ins.setString(1, lbean.getEmailId());
			ps_ins.execute();
			rs1 = ps_ins.getResultSet();
			while (rs1.next()) {
				flag = true;
				passFromDb = rs1.getString("password");
				sl_no = rs1.getInt("emp_sl_no");
				System.out.println("sl no from db is " + sl_no);
				emailId = rs1.getString("email");
				System.out.println("emailid" + emailId);
				role_sl_no = rs1.getInt("role_sl_no");
				String Sql3 = "SELECT role_name FROM ROLE where role_sl_no=?";
				ps_ins = con.prepareStatement(Sql3);
				ps_ins.setInt(1, role_sl_no);
				ps_ins.execute();
				rs2 = ps_ins.getResultSet();
				while (rs2.next()) {
					role = rs2.getString("role_name");
					System.out.println("role from db" + role);
				}
			}
			String message = "Email id is not found";
			if (flag == true) {
				if (!(lbean.getPassword().equals(passFromDb))) {
					System.out.println("both id same" + lbean.getPassword()
							+ "from db" + passFromDb);
					message = "Enter correct password";
					json.put("status", message);
					return json.toString();
				}
			} else {

				System.out.println("Control is here");
				message = "Enter correct Email id";
				json.put("status", message);
				return json.toString();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.put("role", role);
		return json.toString();

		
	}
 




}
