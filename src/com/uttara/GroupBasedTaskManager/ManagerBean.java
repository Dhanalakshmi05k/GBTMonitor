package com.uttara.GroupBasedTaskManager;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ManagerBean {
	
	@NotEmpty(message="Enter FirstName")
	private String firstName;
	@NotEmpty(message="Enter LastName")
	private String lastName;
	@NotEmpty(message="Enter Email")
	@Email(message="Enter proper EmailId")
	private String	email;
	@NotEmpty(message="Enter phoneNumber")
	@Length(min=3,max=10,message="Enter 10 Digit Phone Number")
	private String	phoneNumber;
	@NotEmpty(message="Enter Password")
	private String	password;
	@NotEmpty(message="Enter repeatPassword")
	private String	repeatPassword;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	@Override
	public String toString() {
		return "EmployeeRegistraionBean [firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", repeatPassword=" + repeatPassword
				+ "]";
	}




}
