package main;

import java.util.Scanner;

import oop.GradeList;
import oop.Menu;
import oop.StudentList;
import oop.SubjectList;

public class main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		StudentList listSTD = new StudentList();
		SubjectList listSub = new SubjectList();
		GradeList listGrade = new GradeList(listSTD,listSub);
		listSTD.AddStudentTest();
		listSub.AddTestSubject();
		
		int choice;
		menu.AddItemMenu("Add new student");
		menu.AddItemMenu("Update Student");
		menu.AddItemMenu("Delete Student");
		menu.AddItemMenu("Add new Subject");
		menu.AddItemMenu("Update Subject");
		menu.AddItemMenu("Delete Subject");
		menu.AddItemMenu("Enter Grade");
		menu.AddItemMenu("Display Student Grade Report");
		menu.AddItemMenu("Display Subject Grade Report");
		menu.AddItemMenu("Quit");
		do {
			choice = menu.GetUserChoice();
			switch(choice) {
			case 1:
				listSTD.AddStudent();
				break;
			case 2:
				listSTD.UpdateStudent();
				break;
			case 3:
				listSTD.DeleteStudent();
				break;
			case 4:
				listSub.AddSubject();
				break;
			case 5:
				listSub.UpdateSubject();
				break;
			case 6:
				listSub.DeleteSubject();
				break;
			case 7:
				listGrade.AddGrade();
				break;
			case 8:
				listGrade.PrintStudentReport();
				break;
			case 9:
				listGrade.printSubjectReport();
				break;
			case 10:
				break;
				default:
					System.out.println("Don't have this function!");
			}
		}while(choice != 10);
		
	}

}
