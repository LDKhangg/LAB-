package oop;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String>{
	Scanner sc = new Scanner(System.in);
	public void AddItemMenu(String item) {
		this.add(item);
	}
	public int GetUserChoice() {
		int count = 1;
		for(String str:this) {
			System.out.println(count+". "+str);
			count++;
		}
		System.out.print("Your choice: ");
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
}
