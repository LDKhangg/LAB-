package oop;

import java.util.Date;

public class Student {
	public String stdId,firstName,lastName,gender;
	String DOB;
	String email,phone;
	boolean canDelete = true; //gán cứng
	//get set
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isCanDelete() {
		return canDelete;
	}
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	//constructor
	public Student(String stdId, String firstName, String lastName, String gender, String dOB, String email, String phone,
			boolean canDelete) {
		super();
		this.stdId = stdId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.DOB = dOB;
		this.email = email;
		this.phone = phone;
		this.canDelete = canDelete;
	}
	
	public void printInfo() {
		System.out.println("Student's id:\t\t\t"+stdId.toUpperCase());
		System.out.println("Student's name:\t\t\t"+firstName.toUpperCase()+" "+lastName.toUpperCase());
		System.out.println("Student's gender:\t\t"+gender.toUpperCase());
		System.out.println("Student's day of birthday:\t"+DOB);
		System.out.println("Student's email:\t\t"+email);
		System.out.println("Student's phone:\t\t"+phone);
	}
	
}
