package oop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentList extends ArrayList<Student> {
	Scanner sc = new Scanner(System.in);

	public int SearchStudentId(String id) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).stdId.equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

	public void AddStudent() {
		System.out.println("Input new Student: ");

		this.add(new Student(InputStudentID(), InputFirstName(), InputLastName(), InputGender(), InputDate(), InputEmail(),
				InputPhone(), true));

		System.out.println("Added student Successfully!");
		System.out.println();
	}

	public void UpdateStudent() {
		PrintStudentList();
		String idUpdate;
		do {
			System.out.print("Id you want to update: ");
			idUpdate = sc.nextLine();
			if (SearchStudentId(idUpdate) == -1)
				System.out.println("No data. Please try again.");
		} while (SearchStudentId(idUpdate) == -1);

		this.get(SearchStudentId(idUpdate)).setLastName(InputLastName());
		this.get(SearchStudentId(idUpdate)).setFirstName(InputFirstName());
		this.get(SearchStudentId(idUpdate)).setGender(InputGender());
		this.get(SearchStudentId(idUpdate)).setDOB(InputDate());
		this.get(SearchStudentId(idUpdate)).setEmail(InputEmail());
		this.get(SearchStudentId(idUpdate)).setPhone(InputPhone());
		System.out.println("Updated " + idUpdate.toUpperCase() + " successfully!");
		System.out.println();

	}

	public void DeleteStudent() {
		PrintStudentList();
		String idDelete;
		do {
			System.out.print("Id you want to delete: ");
			idDelete = sc.nextLine();
			if (SearchStudentId(idDelete) == -1)
				System.out.println("No data. Please try again.");
			else {
				if (!this.get(SearchStudentId(idDelete)).canDelete)
					System.out.println("Student can not be removed");
			}
		} while (SearchStudentId(idDelete) == -1 || !this.get(SearchStudentId(idDelete)).canDelete);
		String choice;
		do {
			System.out.print("Do you want to delete(Y/N)");
			choice = sc.nextLine();
			if (!choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("y"))
				System.out.println("Invalid characters");
		} while (!choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("y"));
		if (choice.equalsIgnoreCase("y")) {
			this.remove(SearchStudentId(idDelete));
			System.out.println("Deleted Succesfully!");
		} else {
			System.out.println("Cancel Successfully!");
		}
		System.out.println();
	}

	public String InputStudentID() {
		String newId;
		do {
			System.out.print("Enter student's id: ");
			newId = sc.nextLine();
			if (SearchStudentId(newId) != -1)
				System.out.println("Student ID duplicates are not allowed!");
		} while (SearchStudentId(newId) != -1);
		return newId;
	}

	public String InputFirstName() {
		String firstName;
		do {
			System.out.print("Enter student's first name: ");
			firstName = sc.nextLine();
			if (!checkNull(firstName))
				System.out.println("Input the first name!");
		} while (!checkNull(firstName));
		return firstName;
	}

	public String InputLastName() {
		String lastName;
		do {
			System.out.print("Enter student's last name: ");
			lastName = sc.nextLine();
			if (!checkNull(lastName))
				System.out.println("Input the last name!");
		} while (!checkNull(lastName));
		return lastName;
	}

	public String InputGender() {
		String gender;
		do {
			System.out.print("Enter student's gender: ");
			gender = sc.nextLine();
			if (!checkGender(gender))
				System.out.println("Your gender invalid!");
		} while (!checkGender(gender));
		return gender;
	}

	public String InputEmail() {
		String email;
		do {
			System.out.print("Enter student's email: ");
			email = sc.nextLine();
			if (!CheckEmail(email))
				System.out.println("Your email invalid!");
		} while (!CheckEmail(email));
		return email;
	}

	public String InputPhone() {
		String phone;
		do {
			System.out.print("Enter student's phone: ");
			phone = sc.nextLine();
			if (!CheckPhone(phone))
				System.out.println("Your phone invalid");
		} while (!CheckPhone(phone));
		return phone;
	}

	public String InputDate() {
		String date;
		do {
			System.out.print("Enter DOB: ");
			date = sc.nextLine();
		}while(!checkDate(date));
		
		return date;
	}
	
	public void PrintStudentList() {
		System.out.println("List of Student: ");
		if (this.size() == 0) {
			System.out.println("Empty List.");
			System.out.println();
		} else {
			for (Student std : this) {
				std.printInfo();
				System.out.println();
			}
		}
	}

	public void AddStudentTest() {
		this.add(new Student("Se1239012", "Tran", "Gia Bao", "Male", null, "asdjhasjd@gmail.com", "1293821903", true));
		this.add(new Student("Se1239022", "Tran", "Gia Nam", "Male", null, "asdjhasjd@gmail.com", "1293821903", true));
		this.add(new Student("Se1239032", "Tran", "Gia Hung", "Male", null, "asdjhasjd@gmail.com", "1293821903", true));
		this.add(new Student("Se1239062", "Tran", "Gia dung", "Male", null, "asdjhasjd@gmail.com", "1293821903", true));

	}

	public boolean checkDate(String date) {
		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	
	public boolean checkNull(String string) {
		if (string.equals(""))
			return false;
		return true;
	}

	public boolean checkGender(String gender) {
		if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))
			return false;
		return true;
	}

	public boolean CheckEmail(String email) {
		String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean CheckPhone(String phone) {
		try {
			if (phone.length() < 10 || phone.length() > 12)
				return false;
			long convertLong = Long.parseLong(phone);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
