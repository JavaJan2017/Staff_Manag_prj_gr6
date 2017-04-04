package ui;

import static ui.Ui.printAllEmployees;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("ID   Name         Age   Gender  Profession   Adress        e-mail          Phone  Startyear");
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
	public static void printEmployee(Employee e) {
	System.out.println(fixLengthString(e.getId(), 4) +  " " + fixLengthString(e.getName(), 10) + "   " + fixLengthString(e.getAge(), 3) 
						+ "   " +toString(e.getGender()) + "  " +toString( e.getProfession()) + "   " + fixLengthString(e.getContact().getAdress(), 13) 
						+ " " + fixLengthString( e.getContact().getEmail(),15)  + " " + fixLengthString(e.getContact().getPhone(), 5)
						+ "  " + fixLengthString(e.getStartDate(), 5));		
	}
	

		
	public static void printAllEmployees() {
		printHeader();
		for(Employee e : Main.empList) {
			printEmployee(e);
		}
		System.out.println("");
	}
	
	
	
	// **********************************************
	// 			        USER INPUT
	//***********************************************	
	
	public static Contact generateContact(String adr, String email, String phone) {
		Contact c = new Contact(adr, email, phone);
		return c;
	}
	
	public static String askAction() {
		
		final String[] action = { "Add Employee", "Update Employee", "Remove Employee", "Show Employee", 
									"Calculate Salary and Bonus", "Show Salary Statistics", "Show Gender Statistics", "Extra Data" };
		JFrame frame = new JFrame("Staff Management v 1.2");
		    String selectedAction = (String) JOptionPane.showInputDialog(frame, 
		        "Select Action",
		        "Action type",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        action, 
		        action[0]);

		    // selectedProfession will be null if the user clicks Cancel
		    return selectedAction;
		
	}
	
	public static void getUserInput() {
		String selectedAction = askAction();

		switch(selectedAction) {

		case  "Add Employee" : {
			enterNewEmployees();
			printAllEmployees();
			break;
		}
		case "Update Employee" : {
			String stringID = JOptionPane.showInputDialog("Enter Employee ID");
			int id = Integer.parseInt(stringID);
			Employee e = Main.findEmployeeByID(id);
			String name = JOptionPane.showInputDialog("Enter new name");
			String adr = JOptionPane.showInputDialog("Enter new adress");
	    	String email = JOptionPane.showInputDialog("Enter new e-mail");
	    	String phone = JOptionPane.showInputDialog("Enter new phone");
	    	GenderType gndr = askGender();
	    	String stringStartYear = JOptionPane.showInputDialog("Enter new start year");
	    	int startYear = Integer.parseInt(stringStartYear);
			StaffManagement.updateEmployee(e, name, generateContact(adr, email, phone), gndr, startYear);
			printAllEmployees();
			break;

		}
		case "Remove Employee" : {
			String stringID = JOptionPane.showInputDialog("Enter Employee ID");
			int id = Integer.parseInt(stringID);
			Employee e = Main.findEmployeeByID(id);
			StaffManagement.fireEmployee(e);
			printAllEmployees();
			break;
		}
		case "Show Employee" : {
			String stringID = JOptionPane.showInputDialog("Enter Employee ID");
			int id = Integer.parseInt(stringID);
			Employee e = Main.findEmployeeByID(id);
			printHeader();
			printEmployee(e);
			break;
		}
		case "Calculate Salary and Bonus" : {
			String stringID = JOptionPane.showInputDialog("Enter Employee ID");
			int id = Integer.parseInt(stringID);
			Employee e = Main.findEmployeeByID(id);
			printHeader();
			printEmployee(e);
			System.out.println("Salary: €" + (int)e.calculateSalary());
			System.out.println("Bonus: €" + (int)e.calculateBonus());
			break;
			
		}
		case "Show Salary Statistics" : {
			System.out.println("Lowest Salary is: €" + Statistics.calcMinSalary());
			System.out.println("Highest Salary is: €" + Statistics.calcMaxSalary());
			System.out.println("Average Overall Salary is: €" + Statistics.calcAvgSalary());
			Statistics.calcAvgSalaryProfessions();
			break;
		}
		case "Show Gender Statistics" : {
			System.out.println("The percentage of women in the company is: " + (int)Statistics.calcFtoM() + "%");
			Statistics.calculateFtoMProfession();
			break;
		}

		case "Extra Data" : {
			Main.extraData();
			break;
		}

		default :
			System.out.println("Error in Ui.getUserInput()");
			System.exit(0);
			break;

		}
		//System.exit(0);
	}

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
	
	public static void removeEmployee(int id) {
		Employee e = Main.findEmployeeByID(id);
		StaffManagement.fireEmployee(e);
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
		    	StaffManagement.hireEmployee(e);
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
		    	StaffManagement.hireEmployee(e);
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
		    	StaffManagement.hireEmployee(e);
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
		    	StaffManagement.hireEmployee(e);
		    	break;
		    }
		    default :
		    	break;
		    }
	}
	
	
}
