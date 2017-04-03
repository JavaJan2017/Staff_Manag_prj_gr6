package ui;

import java.util.ArrayList;
import models.*;
import utilities.*;

public class Ui {
	
	//toString() method for GenderType
	public static String toString(GenderType gt) {
		return (gt == GenderType.MALE) ? "MALE  " : "FEMALE";
			}
	//toString() method for Profession
	public static String toString(Profession p) {
		switch (p){
		case SECRETARY :
			return "SECRETARY ";			
		case TECHNICIAN :
			return "TECNICIAN ";
		case PROGRAMMER :
			return "PROGRAMMER";
		case MANAGER :
			return "MANAGER   ";
		default :
			return "NULL";
		}		
	}
	
	// **********************************************
	// 			        PRINTING
	//***********************************************
		
	
	//Help function for printing
	private static String fixLengthString(String start, int length) {
		//TODO. fix string padding problem
		if (start.length() >= length) {
			return start.substring(0, length);
		}
		else {
			while (start.length() < length) {
				start += " ";
			}
			return start;
		}
	}
	
	//Help function for printing
	private static String fixLengthString(int start, int length) {
		String startString = String.valueOf(start);
		return fixLengthString(startString, length);
	}
	//Help function for printing
	private static String fixLengthString(double start, int length) {
		String startString = String.valueOf(start);
		return fixLengthString(startString, length);
	}
	
	public static void printHeader() {
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Employee ID  Employee name        Age  Gender  Profession   Salary   Bonus   Startdate");
		System.out.println("--------------------------------------------------------------------------------------");
	}
	
	public static void printEmployee(Employee e) {
	System.out.println(fixLengthString(e.getId(), 12) +  " " + fixLengthString(e.getName(), 18) + "   " + fixLengthString(e.getAge(), 2) 
						+ "   " +toString(e.getGender()) + "  " +toString( e.getProfession()) + "   " + fixLengthString(e.getSalary(), 8) 
						+ " " +fixLengthString( e.getBonus(),6)  + "  " + fixLengthString(e.getStartDate(), 5));		
	}
	
	public static void viewEmployee(Employee e) {
		printHeader();
		printEmployee(e);
		}
		
	public static void printAllEmployees() {
		printHeader();
		for(Employee e : empList) {
			printEmployee(e);
		}
		System.out.println("");
	}
	
	
	// **********************************************
	// 			        STATISTICS
	//***********************************************
			
	
	//Calculate Average salary
	public static double calcAvgSalary() {
		double averageSalary = 0;
		double totalSalary = 0;

		for(Employee currentEmployee:empList){
			totalSalary += currentEmployee.getSalary() + currentEmployee.getBonus();

			averageSalary = totalSalary/empList.size();

		}
		return averageSalary;
	}
	
	//Calculate Average Salary by Profession
	public static void calcAvgSalaryProfessions() {
		double totalSalarySecretary = 0;
		double avgSalarySecretary = 0;
		int nSecretaries = 0;
		
		double totalSalaryTechnician = 0;
		double avgSalaryTechnician = 0;
		int nTechnicians = 0;
		
		double avgSalaryProgrammer = 0;
		double totalSalaryProgrammer = 0;
		int nProgrammers = 0;
		
		double avgSalaryManager = 0;
		double totalSalaryManager = 0;
		int nManagers = 0;
		
		for(Employee e : empList) {
			
			switch (e.getProfession()) {
			case SECRETARY: 
				nSecretaries++;
				totalSalarySecretary += e.getSalary() + e.getBonus();
				avgSalarySecretary = totalSalarySecretary / nSecretaries;				
				break;
				
			case TECHNICIAN: calcAvgSalary();
				nTechnicians++;
				totalSalaryTechnician += e.getSalary() + e.getBonus();
				avgSalaryTechnician = totalSalaryTechnician / nTechnicians;				
				break;
				
			case PROGRAMMER: calcAvgSalary();
				nProgrammers++;
				totalSalaryProgrammer += e.getSalary() + e.getBonus();
				avgSalaryProgrammer = totalSalaryProgrammer / nProgrammers;
				break;
				
			case MANAGER: calcAvgSalary();
				nManagers++;
				totalSalaryManager += e.getSalary() + e.getBonus();
				avgSalaryManager = totalSalaryManager / nManagers;
				break;
			default:
				break;			
			}			
		}
		
		System.out.println("Average salary Secr: " + avgSalarySecretary);
		System.out.println("Average Salary Tech: " + avgSalaryTechnician);
		System.out.println("Average salary Prgr: " + avgSalaryProgrammer);
		System.out.println("Average salary Mngr: " + avgSalaryManager);		
	}
		
		//Calculate Female-to-Male ratio
	public static double calcFtoM() {
		int males = 0;
		int females = 0;
		double ratioFtoM = 0;

		for(Employee currentEmployee:empList){
			if (currentEmployee.getGender().equals(GenderType.MALE)){
				males++;
			}
			else
			{
				females++;
			}
			ratioFtoM = ((double)females/(males + females))*100;
		}
		return ratioFtoM;
	}
	
	public static double calcMinSalary() {
		double min = empList.get(0).getSalary();
		
		for(Employee e : empList) {
			if(e.getSalary() < min)
				min = e.getSalary();
		}
		return min;
	}
	
	public static double calcMaxSalary() {
		double max = empList.get(0).getSalary();
		
		for(Employee e : empList) {
			if(e.getSalary() > max)
				max = e.getSalary();
		}
		return max;
	}
	
	
	// **********************************************
	// 			INITIATING AND TESTING DATA
	//***********************************************
			
		
	//Create our ArrayList of employees
	static ArrayList<Employee> empList = new ArrayList<>();
	
	//Initiate employees
	public static void initiateArrayList() {
		Contact contactS1 = new Contact("Main road 1", "siri@a.com", "074938832");
		Contact contactS2 = new Contact("Main road 2", "susan@a.com", "074938832");
		Contact contactT1 = new Contact("Park Ave 1", "tom@a.com", "072934532");
		Contact contactP1 = new Contact("44th Street", "peter@a.com", "07439499");
		Contact contactP2 = new Contact("55th Street", "patricia@a.com", "07439576");
		Contact contactM1 = new Contact("Wall Str.1", "michael@a.com", "0784324581");

		Secretary s1 = new Secretary("Siri", 25, contactS1, GenderType.FEMALE, Profession.SECRETARY, 2016, 25000, 1000, 1, true, 100);
		Secretary s2 = new Secretary("Susan", 25, contactS2, GenderType.MALE, Profession.SECRETARY, 2016, 25870, 3200, 1, true, 100);
		Technician t1 = new Technician("Tom", 25, contactT1, GenderType.MALE, Profession.TECHNICIAN, 2013, 50000, 3000, 1, true, 50, 10);
		Programmer p1 = new Programmer("Peter", 30, contactP1, GenderType.MALE, Profession.PROGRAMMER, 2011, 10000, 5000, 1, true, 500, 77);
		Programmer p2 = new Programmer("Patricia", 30, contactP2, GenderType.FEMALE, Profession.PROGRAMMER, 2011, 20000, 5, 1, true, 500, 77);		
		Manager m1 = new Manager("Michael", 52, contactM1, GenderType.MALE, Profession.MANAGER, 2000, 65000, 7000, 10, true, 650, 50);

		//Secretary s3 = new Secretary("Susan", 25, contactS2, GenderType.MALE, Profession.SECRETARY, 2016, 25870, 3200, 1, true, 100);
		
		empList.add(s1);
		empList.add(s2);
		empList.add(t1);
		empList.add(p1);
		empList.add(p2);
		empList.add(m1);

	}
	
	//Testing
	public static void testData() {
		
		initiateArrayList();
	
		System.out.println("Ratio of Female to Male is " + calcFtoM());
		
		//Contact contact1 = new Contact("Main road", "lisa@a.com", "074938832");
		//Secretary s2 = new Secretary("Lisa", 25, contact1, GenderType.FEMALE, Profession.SECRETARY, 2016, 45000, 3000, 1, true, 100);
		
		Ui ui = new Ui();
		
		//ui.viewEmployee(s3);
		printAllEmployees();
		System.out.println(calcMinSalary());
		System.out.println(calcMaxSalary());
		
		System.out.println("Avg salary by profession: ");
		calcAvgSalaryProfessions();
//		System.out.println("Secretary number of calls: " + s1.getNTelephoneCalls());
//		System.out.println("absent days: " + s1.getAbsentDays());
//		s1.calculateBonus();
//		System.out.println("Secretary's bonus: " + s1.getBonus());
//
//		s1.makeTelephoneCall(45);
//		s1.callInAbsence(2);
//		System.out.println("We make some telephone calls and call in days of absence");
//
//		System.out.println("Secretary number of calls: " + s1.getNTelephoneCalls());
//		System.out.println("absent days: " + s1.getAbsentDays());
//		s1.calculateBonus();
//		System.out.println("Secretary's bonus: " + s1.getBonus());
//
//		System.out.println(viewEmployee(t1));
//		System.out.println("Technician number of servers fixed: " + t1.getnServersFixed());
//		t1.calculateBonus();
//		System.out.println("Technician'sbonus: " + t1.getBonus());
//
//		t1.fixServer();
//		System.out.println("Technician We fix one server");
//		t1.fixServer();
//		System.out.println("Technician We fix one server");
//
//		System.out.println("serversFixed: " + t1.getnServersFixed());
//		t1.calculateBonus();
//		System.out.println("Technician's bonus: " + t1.getBonus());
//
//		System.out.println(viewEmployee(p1));
//		System.out.println("Programmer number of programs: " + p1.getnPrograms());
//		p1.calculateBonus();
//		System.out.println("Programmer's bonus: " + p1.getBonus());
//
//		System.out.println("We write some programs");
//		p1.writeProgram();
//		p1.writeProgram();
//		p1.writeProgram();
//		System.out.println("Programmer number of programs: " + p1.getnPrograms());
//		p1.calculateBonus();
//		System.out.println("Programmer's bonus: " + p1.getBonus());
//		
//		System.out.println(viewEmployee(m1));
//		System.out.println("Manager amnt of production: " + m1.getAmntProduction());
//		System.out.println("Manager number of complaints: " + m1.getComplaints());
//		m1.calculateBonus();
//		System.out.println("Manager's bonus: " + m1.getBonus());
//		System.out.println("We increase production a little");
//		m1.increaseProduction();
//		System.out.println("Manager receives some complaints");
//		m1.receiveComplaints();
//		m1.receiveComplaints();
//		m1.receiveComplaints();
//		m1.receiveComplaints();
//		System.out.println("Manager amnt of production: " + m1.getAmntProduction());
//		System.out.println("Manager number of complaints: " + m1.getComplaints());
//		m1.calculateBonus();
//		System.out.println("Manager's bonus: " + m1.getBonus());


	}
	
}







