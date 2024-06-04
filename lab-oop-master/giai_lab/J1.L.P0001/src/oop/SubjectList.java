package oop;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectList extends ArrayList<Subject> {
	Scanner sc = new Scanner(System.in);

	public int SearchSubject(String id) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getSubID().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

	public void AddSubject() {
		System.out.println("Input new subject:");

		this.add(new Subject(InputSubjectID(), InputSubjectName(), InputSubjectCredit(), true));

		System.out.println("Added Succesfully!");
		System.out.println();
	}

	public void UpdateSubject() {
		PrintSubjectList();
		String idSubUpdate;
		do {
			System.out.print("Id you want to update: ");
			idSubUpdate = sc.nextLine();
			if (SearchSubject(idSubUpdate) == -1)
				System.out.println("No data.");
		} while (SearchSubject(idSubUpdate) == -1);

		this.get(SearchSubject(idSubUpdate)).setSubName(InputSubjectName());
		;
		this.get(SearchSubject(idSubUpdate)).setCredit(InputSubjectCredit());

		System.out.println("Updated " + idSubUpdate.toUpperCase() + " Successfully!");
		System.out.println();
	}

	public void DeleteSubject() {
		PrintSubjectList();
		String idDelete;
		do {
			System.out.print("Id you want to delete: ");
			idDelete = sc.nextLine();
			if (SearchSubject(idDelete) == -1)
				System.out.println("No data.");
			else {
				if (!this.get(SearchSubject(idDelete)).canDelete)
					System.out.println("Cant's delete this subject!");
			}
		} while (SearchSubject(idDelete) == -1 || !this.get(SearchSubject(idDelete)).canDelete);
		String choice;
		do {
			System.out.print("Do you want to delete(Y/N)");
			choice = sc.nextLine();
			if (!choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("y"))
				System.out.println("Invalid characters");
		} while (!choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("y"));
		if (choice.equalsIgnoreCase("y")) {
			this.remove(SearchSubject(idDelete));
			System.out.println("Deleted Succesfully!");
		} else {
			System.out.println("Cancel Successfully!");
		}
		System.out.println();
	}

	public void PrintSubjectList() {
		if (this.size() == 0) {
			System.out.println("Empty List");
			System.out.println();
		} else {
			System.out.println("List of Subject: ");
			for (Subject sj : this) {
				sj.printSubject();
				System.out.println();
			}
		}
	}

	public String InputSubjectID() {
		String id;
		do {
			System.out.print("Enter subject's id: ");
			id = sc.nextLine();
			if (SearchSubject(id) != -1)
				System.out.println("Subject ID duplicates are not allowed!");
		} while (SearchSubject(id) != -1);
		return id;
	}

	public String InputSubjectName() {
		String subName;
		do {
			System.out.print("Enter subject's name: ");
			subName = sc.nextLine();
			if (!checkNull(subName))
				System.out.println("Not allow null!");
		} while (!checkNull(subName));
		return subName;
	}

	public int InputSubjectCredit() {
		int credit = 0;
		boolean checkCredit = true;
		while (checkCredit || credit > 30 || credit <= 0) {
			try {
				System.out.print("Enter subject's credit: ");
				credit = Integer.parseInt(sc.nextLine());
				checkCredit = false;
				if (credit > 30 || credit <= 0)
					System.out.println("0 < Credit <= 30");
			} catch (Exception e) {
				System.out.println("Please try again.");
			}
		}
		return credit;
	}

	public boolean checkNull(String str) {
		if (str.equals(""))
			return false;
		return true;
	}

	public void AddTestSubject() {
		this.add(new Subject("JAVA", "JAVA Core", 20, true));
		this.add(new Subject("C", "  C/C++  ", 20, true));
		this.add(new Subject("OSG", "opera system", 20, true));
		this.add(new Subject("DB", "Data Base", 20, true));
	}
}
