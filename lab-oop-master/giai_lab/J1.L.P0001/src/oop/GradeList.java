package oop;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeList extends ArrayList<Grade> {
	StudentList listSTD;
	SubjectList listSub;

	public GradeList(StudentList listSTD, SubjectList listSub) {
		super();
		this.listSTD = listSTD;
		this.listSub = listSub;
	}

	Scanner sc = new Scanner(System.in);

	public void AddGrade() {
		String stdID, subID;
		int stdIndex, subIndex;
		double lab, test, fe;
		listSTD.PrintStudentList();
		listSub.PrintSubjectList();
		System.out.println(listSTD.SearchStudentId("SE1239012") == -1);
		do {
			// nhap mon hoc va ma sv
			do {
				System.out.print("Enter the student's id: ");
				stdID = sc.nextLine();
				if (listSTD.SearchStudentId(stdID) == -1)
					System.out.println("No data.");
			} while (listSTD.SearchStudentId(stdID) == -1);

			do {
				System.out.print("Enter the subject's id: ");
				subID = sc.nextLine();
				if (listSub.SearchSubject(subID) == -1)
					System.out.println("No data.");
			} while (listSub.SearchSubject(subID) == -1);

			// nhap diem
			System.out.print("Lab's grade: ");
			lab = InputGrade();
			System.out.print("Test's grade: ");
			test = InputGrade();
			System.out.print("FE's grade: ");
			fe = InputGrade();

			stdIndex = listSTD.SearchStudentId(stdID);
			subIndex = listSub.SearchSubject(subID);

			if (SearchGrade(stdID, subID))
				System.out.println("This grade existed!");
		} while (SearchGrade(stdID, subID));

		this.add(new Grade(listSTD.get(stdIndex), listSub.get(subIndex), lab, test, fe));
		listSTD.get(stdIndex).setCanDelete(false);
		listSub.get(subIndex).setCanDelete(false);
		System.out.println("A new grade have been added!");
		System.out.println();
	}

	public void PrintStudentReport() {
		String stdID;
		do {
			System.out.print("Enter the student's id: ");
			stdID = sc.nextLine();
			if (listSTD.SearchStudentId(stdID) == -1)
				System.out.println("No data.");
		} while (listSTD.SearchStudentId(stdID) == -1);
		System.out.println();
		int index = listSTD.SearchStudentId(stdID);
		System.out.println("Student ID: " + listSTD.get(index).getStdId().toUpperCase());
		System.out.println("Student ID: " + listSTD.get(index).getFirstName() + " "
				+ listSTD.get(index).getLastName().toUpperCase());
		int count = 1;
		boolean checknull = false;
		System.out.println("| ++No++ |     ++Subject++     |    ++Average++    |   ++Status++   |");
		for (Grade gr : this) {
			if (stdID.equalsIgnoreCase(gr.std.getStdId())) {
				System.out.print("     " + count + "\t\t" + gr.sub.subName.toUpperCase() + "\t\t" + gr.avg() + "\t\t"
						+ Status(gr.avg()).toUpperCase());
				System.out.println();
				count++;
				checknull = true;
			}
		}
		if (checknull == false)
			System.out.println("-------------------------------No data-------------------------------");
		System.out.println();
	}

	public void printSubjectReport() {
		printListGrade();
		String subID;
		do {
			System.out.print("Enter the subject's id: ");
			subID = sc.nextLine();
			if (listSub.SearchSubject(subID) == -1)
				System.out.println("No data.");
		} while (listSub.SearchSubject(subID) == -1);
		int index = listSub.SearchSubject(subID);
		System.out.println("Subject ID: " + subID);
		System.out.println("Subject name: " + listSub.get(index).getSubName());
		boolean checknull = false;
		System.out
				.println("|     ++Student ID++     |     ++Student Name++     |    ++Average++    |   ++Status++   |");
		for (Grade gr : this) {
			if (gr.sub.getSubID().equalsIgnoreCase(subID)) {
				System.out.println("\t" + gr.std.getStdId().toUpperCase() + "\t\t" + gr.std.getFirstName().toUpperCase()
						+ " " + gr.std.getLastName().toUpperCase() + "\t\t\t" + gr.avg() + "\t\t"
						+ Status(gr.avg()).toUpperCase());
				checknull = true;
			}
		}
		if (checknull == false)
			System.out.println(
					"------------------------------------------No Data-----------------------------------------");
		System.out.println();
	}

	public void printListGrade() {
		System.out.println("List of Grade: ");
		if (this.size() == 0)
			System.out.println("empty List");
		else {
			System.out.println("|  ++Subject Name++  |  ++Student ID++  |");
			for (Grade gr : this) {
				System.out.println("\t" + gr.sub.getSubID() + "    \t" + gr.std.getStdId());
			}
		}
		System.out.println();
	}

	public String Status(double num) {
		if (num < 5)
			return "Not Pass";
		return "Pass";
	}

	public boolean SearchGrade(String stdID, String subID) {
		boolean stdFlag = false, subFlag = false;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).std.getStdId().equalsIgnoreCase(stdID)) {
				stdFlag = true;
			}
		}
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).sub.getSubID().equalsIgnoreCase(subID)) {
				subFlag = true;
			}
		}
		if (subFlag && stdFlag)
			return true; // da co trong mang
		return false;// chua co trong mang
	}

	public double InputGrade() {
		boolean check = false;
		double num = 0;
		while (check == false || num < 0 || num > 10) {
			try {
				num = Double.parseDouble(sc.nextLine());
				check = true;
				if (num < 0 || num > 10) {
					System.out.println("Input number > 0 and <= 10!");
				}
			} catch (Exception e) {
				System.out.println("Please try again!");
			}
		}
		return num;
	}
}
