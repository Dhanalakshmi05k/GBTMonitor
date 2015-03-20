package com.uttara.GroupBasedTaskManager;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskBean {
	private String projectName;
	private int projectTaskSlno;
	private int task_sl_no;
	private String status;
	private String taskName;
	private String taskDesc;
	private Date taskCreatedDate;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date taskCompletionDate;
	private int priority;
	private String EmployeeName;
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectTaskSlno() {
		return projectTaskSlno;
	}
	public void setProjectTaskSlno(int projectTaskSlno) {
		this.projectTaskSlno = projectTaskSlno;
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
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	@Override
	public String toString() {
		return "TaskBean [projectName=" + projectName + ", projectTaskSlno="
				+ projectTaskSlno + ", task_sl_no=" + task_sl_no + ", status="
				+ status + ", taskName=" + taskName + ", taskDesc=" + taskDesc
				+ ", taskCreatedDate=" + taskCreatedDate
				+ ", taskCompletionDate=" + taskCompletionDate + ", priority="
				+ priority + ", EmployeeName=" + EmployeeName + "]";
	}
	
	
	
	

}
