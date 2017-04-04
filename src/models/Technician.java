package models;

import utilities.*;

public class Technician extends Employee {
	
	//Class fields
	private int nServersFixed;
	private int nServerCrashes;
	
	//Class constructor
	public Technician(String name, int age, Contact contact, GenderType gender, Profession profession, int startDate, double salary,
			double bonus, int absentDays, boolean inCompany, int serversFixed, int nServerCrashes) {
		
		super(name, age, contact, gender, profession, startDate, salary, bonus, absentDays, inCompany);
		this.nServersFixed += serversFixed;
		this.nServerCrashes += nServerCrashes;
	}
	
	//Class methods
	public void fixServer() {
		nServersFixed += 1;
	}
	
	public void crashServer() {
		nServerCrashes += 1;
	}
	
	public double calculateBonus() {
		double bonus = getBonus() + (nServersFixed * 50) - (nServerCrashes * 3) - (absentDays * 5);
		return bonus;
	}
	public void printInfo() {
		System.out.println("Number of Server Fixed is: " + nServersFixed + " Number of serves Crashes: " + nServerCrashes + " Absent days: " + absentDays + " Bonus: €" + calculateBonus());
	}

	public int getnServersFixed() {
		return nServersFixed;
	}

	public int getnServerCrashes() {
		return nServerCrashes;
	}
	
	
}
