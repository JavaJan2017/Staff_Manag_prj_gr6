package models;

import java.util.Date;
import utilities.*;


public class Secretary extends Employee {
	
	//Class fields
	private int nTelephoneCalls;
	
	public Secretary(String name, int age, Contact contact, GenderType gender, Profession profession, int startDate, double salary,
			double bonus, int absentDays, boolean inCompany, int calls) {
		
		super(name, age, contact, gender, profession, startDate, salary, bonus, absentDays, inCompany);
		nTelephoneCalls = calls;
	}
	//Class methods
	public double calculateBonus() {
		double bonus = getBonus() + (nTelephoneCalls * 10) - (absentDays * 5);
		return bonus;
	}
	public void printInfo() {
		System.out.println("Number of telephone calls: " + nTelephoneCalls + "  Absent days: " + absentDays + "  Bonus: €" + calculateBonus());
	}
	
	public void makeTelephoneCall(int n) {
		nTelephoneCalls += n;
	}
	
	public int getNTelephoneCalls() {
		return nTelephoneCalls;
	}
}
