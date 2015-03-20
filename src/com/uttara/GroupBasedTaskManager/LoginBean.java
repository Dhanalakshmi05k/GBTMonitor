package com.uttara.GroupBasedTaskManager;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	
	@NotEmpty(message="Enter Correct EmailId")
	private String emailId;
	@NotEmpty(message="Enter Correct Password")
	private String password;
	private String emp_Sl_No;
	private String role;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmp_Sl_No() {
		return emp_Sl_No;
	}
	public void setEmp_Sl_No(String emp_Sl_No) {
		this.emp_Sl_No = emp_Sl_No;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginBean [emailId=" + emailId + ", password=" + password
				+ ", emp_Sl_No=" + emp_Sl_No + ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result
				+ ((emp_Sl_No == null) ? 0 : emp_Sl_No.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (emp_Sl_No == null) {
			if (other.emp_Sl_No != null)
				return false;
		} else if (!emp_Sl_No.equals(other.emp_Sl_No))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	

}
