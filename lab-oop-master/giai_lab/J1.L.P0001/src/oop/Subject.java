package oop;

public class Subject {
	String subID, subName;
	int credit;
	boolean canDelete = true;
	//get set
	public String getSubID() {
		return subID;
	}
	public void setSubID(String subID) {
		this.subID = subID;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public boolean isCanDelete() {
		return canDelete;
	}
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	//constructor
	public Subject(String subID, String subName, int credit, boolean canDelete) {
		super();
		this.subID = subID;
		this.subName = subName;
		this.credit = credit;
		this.canDelete = canDelete;
	}
	
	public void printSubject() {
		System.out.println("Subject's id:\t\t"+subID.toUpperCase());
		System.out.println("Subject's name:\t\t"+subName.toUpperCase());
		System.out.println("Subject's credit:\t"+credit);
	}
}
