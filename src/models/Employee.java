package models;

import static ui.Main.empList;

import java.util.Date;

import utilities.*;


abstract public class Employee {

		//Class fields
		private int id;
		private static int idCounter = 0;
		private String name;
		private int age;
		private Contact contact;
		private GenderType gender;
		private Profession profession;
		private int startDate;
		private double salary;
		private double bonus;
		protected int absentDays;
		private boolean inCompany;
		
		//Constructor
		public Employee(String name, int age, Contact contact, GenderType gender, Profession profession, int startDate, double salary,
				double bonus, int absentDays, boolean inCompany) {

			this.id = ++idCounter;
			this.name = name;
			this.age = age;
			this.contact = contact;
			this.gender = gender;
			this.profession = profession;
			this.startDate = startDate;
			this.salary = salary;
			this.bonus = bonus;
			this.absentDays = absentDays;
			this.inCompany = true;
		}
		
		//Class methods
		abstract public double calculateBonus();
		
		public  double calculateSalary() {
			double newSalary = 0;
			for(Employee e : empList) {
				if((e.yearsInCompany() > 2 )) {
					newSalary = e.getSalary() * 1.10 ;
					}
				else if ((e.yearsInCompany() > 5)) {
					newSalary = e.getSalary() * 1.25;
				}
				else if ((e.yearsInCompany() > 10)) {
					newSalary = e.getSalary() * 1.35 ;
				}
				else {
					newSalary = e.getSalary();
				}
			}
			return newSalary;
			
		}
		
				
		public void callInAbsence(int days) {
			absentDays += days;
		}
		
		public void resign() {
			inCompany = false;
		}
		
		public int getId(){
			return id;
		}
		
		public void setId(int id){
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		
		public GenderType getGender() {
			return gender;
		}
		
		public Profession getProfession() {
			return profession;
		}
		
		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public double getBonus() {
			return bonus;
		}
		
		public void setBonus(double bonus) {
			this.bonus = bonus;
		}
		
		public int getAbsentDays() {
			return absentDays;
		}
		
		public int yearsInCompany() {
			return (2017 - startDate);
		}

		public int getAge() {
			return age;
		}
		

		public void setAge(int age) {
			this.age = age;
		}

		public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		public boolean isInCompany() {
			return inCompany;
		}

		public void setInCompany(boolean inCompany) {
			this.inCompany = inCompany;
		}

		public int getStartDate() {
			return startDate;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setGender(GenderType gender) {
			this.gender = gender;
		}
		
		public void setProfession(Profession profession) {
			this.profession = profession;
		}

		public void setAbsentDays(int absentDays) {
			this.absentDays = absentDays;
		}
		
		public void setStartDate(int startDate) {
			this.startDate = startDate;
		}
}
