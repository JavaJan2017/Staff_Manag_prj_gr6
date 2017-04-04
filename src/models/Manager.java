package models;

import utilities.*;

public class Manager extends Employee {

	//Class fields
	private int amntProduction;
	private int complaints;
	
	//Constructor
	public Manager(String name, int age, Contact contact, GenderType gender, Profession profession, int startDate, double salary,
			double bonus, int absentDays, boolean inCompany, int amntProduction, int complaints) {
		
		super(name, age, contact, gender, profession, startDate, salary, bonus, absentDays, inCompany);
		this.amntProduction = amntProduction;
		this.complaints = complaints;
	}
	
	//Class methods
	
	@Override
	public void calculateBonus() {
		double bonus = (amntProduction * 28) - (complaints * 17) - (absentDays * 5);
		setBonus(bonus);

	}
	
	
	
	public void increaseProduction() {
		amntProduction += 10;
	}
	
	public void receiveComplaints() {
		complaints += 1;
	}

	public int getAmntProduction() {
		return amntProduction;
	}

	public int getComplaints() {
		return complaints;
	}
	
	

}
