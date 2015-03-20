package com.uttara.GroupBasedTaskManager;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ProjectBean {

	private int project_sl_no;
	@NotEmpty(message="Enter Project Name")
	private String projectName;
	private Date proj_CreatedDate;
	@NotEmpty(message="Enter Project Description")
	private String description; 
	@NotEmpty(message="Enter Type Of Project")
	private String typeOfProject;
	private int task_sl_no;
	private String status;
	private String taskName;
	private String taskDesc;
	private Date taskCreatedDate;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date taskCompletionDate;
	private int priority;
	private String EmployeeName;
	
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public int getProject_sl_no() {
		return project_sl_no;
	}
	public void setProject_sl_no(int project_sl_no) {
		this.project_sl_no = project_sl_no;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getProj_CreatedDate() {
		return proj_CreatedDate;
	}
	public void setProj_CreatedDate(Date proj_CreatedDate) {
		this.proj_CreatedDate = proj_CreatedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeOfProject() {
		return typeOfProject;
	}
	public void setTypeOfProject(String typeOfProject) {
		this.typeOfProject = typeOfProject;
	}
	public int getTask_sl_no() {
		return task_sl_no;
	}
	public void setTask_sl_no(int task_sl_no) {
		this.task_sl_no = task_sl_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getTaskCreatedDate() {
		return taskCreatedDate;
	}
	public void setTaskCreatedDate(Date taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}
	public Date getTaskCompletionDate() {
		return taskCompletionDate;
	}
	public void setTaskCompletionDate(Date taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "ProjectBean [project_sl_no=" + project_sl_no + ", projectName="
				+ projectName + ", proj_CreatedDate=" + proj_CreatedDate
				+ ", description=" + description + ", typeOfProject="
				+ typeOfProject + ", task_sl_no=" + task_sl_no + ", status="
				+ status + ", taskName=" + taskName + ", taskDesc=" + taskDesc
				+ ", taskCreatedDate=" + taskCreatedDate
				+ ", taskCompletionDate=" + taskCompletionDate + ", priority="
				+ priority + "]";
	}
	
}
