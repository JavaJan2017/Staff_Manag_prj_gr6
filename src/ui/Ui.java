package ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.*;
import utilities.*;

public class Ui {
	
 	//Create an ArrayList of existing employees
	public static ArrayList<Employee> empList = new ArrayList<>();
	
	
	
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
		System.out.println("Employee ID  Employee name        Age   Gender  Profession   Salary   Bonus   Startdate");
		System.out.println("--------------------------------------------------------------------------------------");
	}
	
	public static void printEmployee(Employee e) {
	System.out.println(fixLengthString(e.getId(), 12) +  " " + fixLengthString(e.getName(), 18) + "   " + fixLengthString(e.getAge(), 3) 
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
	// 	  ADDING, UPDATING AND REMOVING EMPLOYEE
	//***********************************************
		
	
	public static void hireEmployee(Employee e) {
		empList.add(e);
	}
	
	public static void fireEmployee(Employee e) {
		empList.remove(e);
		e.setInCompany(false);
	}
	
	public static void updateEmployee(Employee e, String name, int age, Contact contact, GenderType gender, Profession profession, double salary,
			double bonus, int absentDays) {
		
		e.setName(name);
		e.setAge(age);
		//e.contact = contact;
		e.setGender(gender);
		e.setProfession(profession);
		e.setSalary(salary);
		e.setBonus(bonus);
		e.setAbsentDays(absentDays);
		
	}
	
	public static void updateContact(Contact c, String adr, String email, String phone) {
		c.setAdress(adr);
		c.setEmail(email);
		c.setPhone(phone);
	}
	
	public static Contact generateContact(String adr, String email, String phone) {
		Contact c = new Contact(adr, email, phone);
		return c;
	}
	
	
	
	// **********************************************
	// 			        USER INPUT
	//***********************************************	
	
	public static String askProfession() {
		
		final String[] professions = { "Secretary", "Technician", "Programmer", "Manager" };
		JFrame frame = new JFrame("Staff Management v 1.2");
		    String selectedProfession = (String) JOptionPane.showInputDialog(frame, 
		        "Select Profession",
		        "Profession type",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        professions, 
		        professions[0]);

		    // selectedProfession will be null if the user clicks Cancel
		    return selectedProfession;
		
	}
	
	public static GenderType askGender() {
		
		final String[] gender = { "Male", "Female"};
		JFrame frame = new JFrame("Staff Management v 1.2");
		    String selectedGender = (String) JOptionPane.showInputDialog(frame, 
		        "Select Gender",
		        "Gender type",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        gender, 
		        gender[0]);
		    
		    switch (selectedGender) {
		    case "Male" :  	return GenderType.MALE;
		    case "Female" : return GenderType.FEMALE;
		    default : return null;
		    }
		    // selectedGender will be null if the user clicks Cancel
		
	}
	
	
	//Ask for user input to hire new Employees
	public static void enterNewEmployees() {
		
			String selectedProfession = askProfession();
		 
		    switch (selectedProfession) {
		    case "Secretary" : {
		    	String name = JOptionPane.showInputDialog("Enter name");
		    	String stringAge = JOptionPane.showInputDialog("Enter age");
		    	int age = Integer.parseInt(stringAge);
		    	String adr = JOptionPane.showInputDialog("Enter adress");
		    	String email = JOptionPane.showInputDialog("Enter e-mail");
		    	String phone = JOptionPane.showInputDialog("Enter phone");
		    	GenderType gndr = askGender();
		    	
		    	Employee e = new Secretary(name, age, generateContact(adr, email, phone), gndr, Profession.SECRETARY, 2017, 25000, 1000, 1, true, 100);
		    	hireEmployee(e);
		    	break;
		    }
		    case "Technician" : {
		    	String name = JOptionPane.showInputDialog("Enter name");
		    	String stringAge = JOptionPane.showInputDialog("Enter age");
		    	int age = Integer.parseInt(stringAge);
		    	String adr = JOptionPane.showInputDialog("Enter adress");
		    	String email = JOptionPane.showInputDialog("Enter e-mail");
		    	String phone = JOptionPane.showInputDialog("Enter phone");
		    	GenderType gndr = askGender();
		    	
		    	Employee e = new Technician(name, age, generateContact(adr, email, phone), gndr, Profession.TECHNICIAN, 2017, 25000, 1000, 1, true, 100, 3);
		    	hireEmployee(e);
		    	break;
		    }
		    case "Programmer" : {
		    	String name = JOptionPane.showInputDialog("Enter name");
		    	String stringAge = JOptionPane.showInputDialog("Enter age");
		    	int age = Integer.parseInt(stringAge);
		    	String adr = JOptionPane.showInputDialog("Enter adress");
		    	String email = JOptionPane.showInputDialog("Enter e-mail");
		    	String phone = JOptionPane.showInputDialog("Enter phone");
		    	GenderType gndr = askGender();
		    	
		    	Employee e = new Programmer(name, age, generateContact(adr, email, phone), gndr, Profession.PROGRAMMER, 2017, 25000, 1000, 1, true, 100, 3);
		    	hireEmployee(e);
		    	break;
		    }
		    case "Manager" : {
		    	String name = JOptionPane.showInputDialog("Enter name");
		    	String stringAge = JOptionPane.showInputDialog("Enter age");
		    	int age = Integer.parseInt(stringAge);
		    	String adr = JOptionPane.showInputDialog("Enter adress");
		    	String email = JOptionPane.showInputDialog("Enter e-mail");
		    	String phone = JOptionPane.showInputDialog("Enter phone");
		    	GenderType gndr = askGender();
		    	
		    	Employee e = new Manager(name, age, generateContact(adr, email, phone), gndr, Profession.MANAGER, 2017, 25000, 1000, 1, true, 100, 3);
		    	hireEmployee(e);
		    	break;
		    }
		    default :
		    	break;
		    }
	}
	


	//Testing
	
		
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
