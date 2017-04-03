package models;

import utilities.*;

public class Technician extends Employee {
	//Class variables
	private int nServersFixed;
	private int nServerCrashes;
	
	//Class constructor
	public Technician(String name, int age, Contact contact, GenderType gender, int startDate, double salary,
			double bonus, int absentDays, boolean inCompany, int serversFixed, int nServerCrashes) {
		super(name, age, contact, gender, startDate, salary, bonus, absentDays, inCompany);
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
	
	public void calculateBonus() {
		double bonus = (nServersFixed * 50) - (nServerCrashes * 3) - (absentDays * 5);
		setBonus(bonus);
	}

	public int getnServersFixed() {
		return nServersFixed;
	}

	public int getnServerCrashes() {
		return nServerCrashes;
	}
	
	
}
