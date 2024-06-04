package oop;

public class Grade {
	Student std;
	Subject sub;
	double lab,test,fe;
	public double avg() {
		return 0.3*lab + 0.3*test + 0.4*fe;
	}
	public Grade(Student std, Subject sub, double lab, double test, double fe) {
		super();
		this.std = std;
		this.sub = sub;
		this.lab = lab;
		this.test = test;
		this.fe = fe;
	}
	
}
