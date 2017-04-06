package ui;

import static ui.Ui.printAllEmployees;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.*;
import utilities.*;

public class Ui {

	// toString() method for GenderType
	public static String toString(GenderType gt) {
		return (gt == GenderType.MALE) ? "MALE  " : "FEMALE";
	}

	// toString() method for Profession
	public static String toString(Profession p) {
		switch (p) {
		case SECRETARY:
			return "SECRETARY ";
		case TECHNICIAN:
			return "TECHNICIAN";
		case PROGRAMMER:
			return "PROGRAMMER";
		case MANAGER:
			return "MANAGER   ";
		default:
			return "NULL";
		}
	}

	// **********************************************
	// PRINTING
	// ***********************************************

	// Help function for printing
	private static String fixLengthString(String start, int length) {
		// TODO. fix string padding problem
		if (start.length() >= length) {
			return start.substring(0, length);
		} else {
			while (start.length() < length) {
				start += " ";
			}
			return start;
		}
	}

	// Help function for printing
	private static String fixLengthString(int start, int length) {
		String startString = String.valueOf(start);
		return fixLengthString(startString, length);
	}

	// Help function for printing
	private static String fixLengthString(double start, int length) {
		String startString = String.valueOf(start);
		return fixLengthString(startString, length);
	}

	public static void printHeader() {
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"ID   Name         Age   Gender  Profession   Adress        e-mail          Phone      Salary    Bonus    Startyear");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
	}

	public static void printEmployee(Employee e) {
		System.out.println(fixLengthString(e.getId(), 4) + " " + fixLengthString(e.getName(), 10) + "   "
				+ fixLengthString(e.getAge(), 3) + "   " + toString(e.getGender()) + "  " + toString(e.getProfession())
				+ "   " + fixLengthString(e.getContact().getAdress(), 13) + " "
				+ fixLengthString(e.getContact().getEmail(), 15) + " " + fixLengthString(e.getContact().getPhone(), 9)
				+ "  " +fixLengthString(e.calculateSalary(),8) + "  " + fixLengthString(e.calculateBonus(),7) + "  " + fixLengthString(e.getStartDate(), 5));
		
	}

	public static void printAllEmployees() {
		printHeader();
		for (Employee e : Main.empList) {
			printEmployee(e);
		}
		System.out.println("");
	}

	// **********************************************
	// USER INPUT
	// ***********************************************

	public static void updateEmployee() {
		String stringID = JOptionPane.showInputDialog("Enter Employee ID");
		int id = Integer.parseInt(stringID);
		Employee e = Main.findEmployeeByID(id);
		String name = JOptionPane.showInputDialog("Enter new name");
		String adr = JOptionPane.showInputDialog("Enter new adress");
		
		String email = "";
				//Check that user inputs correct e-mail format
		boolean emailCorrectFormat = false;
		while(!emailCorrectFormat) {

			email = JOptionPane.showInputDialog("Enter e-mail");
			if (email.contains("@")) {
				emailCorrectFormat = true;
			}
			else {
				JFrame frame = new JFrame("Staff Management v 1.2");
				JOptionPane.showMessageDialog(frame, "Wrong e-mail format");
				System.out.println("Wrong email format");
			}

		}
		
		String phone = JOptionPane.showInputDialog("Enter new phone");
		GenderType gndr = askGender();
		String stringSalary = JOptionPane.showInputDialog("Enter salary");
		double salary = Double.parseDouble(stringSalary);
		String stringStartYear = JOptionPane.showInputDialog("Enter new start year");
		int startYear = Integer.parseInt(stringStartYear);
		StaffManagement.updateEmployee(e, name, generateContact(adr, email, phone), gndr,salary, startYear);
	}
	
	public static void showEmployee() {
		String stringID = JOptionPane.showInputDialog("Enter Employee ID");
		int id = Integer.parseInt(stringID);
		if (id <= Main.empList.size()) {
			Employee e = Main.findEmployeeByID(id);
			printHeader();
			printEmployee(e);
		
		JFrame frame = new JFrame("Staff Management v 1.2");
		JOptionPane.showMessageDialog(frame,
				"Information about employee ID " + id + "\nName: " + e.getName() + " \nAge: " + e.getAge()
						+ "   \nEmployee is a " + toString(e.getGender()) + "\nProfession: "
						+ toString(e.getProfession()) + "\nAdress: " + e.getContact().getAdress() + "\nE-mail: "
						+ e.getContact().getEmail() + "\nPhone: " + e.getContact().getPhone() + "\nStart year: "
						+ e.getStartDate(),
				"Staff manager version 1.2", JOptionPane.INFORMATION_MESSAGE);
		}
		else
				System.out.println("Employee does not exist");
	}
	
	public static void showSalaryStatistics() {
		System.out.println("Lowest Salary is: €" +  (float)Statistics.calcMinSalary());
		System.out.println("Highest Salary is: €" + (float)Statistics.calcMaxSalary());
		System.out.println("Average Overall Salary is: €" + (float)Statistics.calcAvgSalary());
		Statistics.calcAvgSalaryProfessions();
		double avgSalaryProf[] = Statistics.calcAvgSalaryProfessions();
		System.out.println("Average salary for Secretary is €" + (float)avgSalaryProf[0]);
		System.out.println("Average Salary for Technician is €" + (float)avgSalaryProf[1]);
		System.out.println("Average salary for Prgrammer is €" + (float)avgSalaryProf[2]);
		System.out.println("Average salary for Manager is €" + (float)avgSalaryProf[3]);
		JFrame frame = new JFrame("Staff Management v 1.2");
		JOptionPane.showMessageDialog(frame,
				"SALARY STATISTICS" + "\nLowest Salary is: €" + (float)Statistics.calcMinSalary()
						+ "\nHighest Salary is: €" + (float)Statistics.calcMaxSalary() + "\nAverage Overall Salary is: €"
						+ (float)Statistics.calcAvgSalary() + "\nAverage salary for Secretary is €" + (float)avgSalaryProf[0]
						+ "\nAverage Salary for Technician is €" + (float)avgSalaryProf[1]
						+ "\nAverage salary for Prgrammer is €" + (float)avgSalaryProf[2]
						+ "\nAverage salary for Manager is €" + (float)avgSalaryProf[3],
				"Staff manager version 1.2", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void calculateSalaryAndBonus() {
		String stringID = JOptionPane.showInputDialog("Enter Employee ID");
		int id = Integer.parseInt(stringID);
		Employee e = Main.findEmployeeByID(id);
		printHeader();
		printEmployee(e);
		System.out.println("Salary: €" + (int) e.calculateSalary());
		System.out.println("Bonus: €" + (int) e.calculateBonus());
		JFrame frame = new JFrame("Staff Management v 1.2");
		JOptionPane.showMessageDialog(frame,
				"Employee " + e.getName() + "s Calculated Salary is " + (int) e.calculateSalary() + " € "
						+ " \n and Calculated Bonus is " + (int) e.calculateBonus() + " € ",
				"Staff manager version 1.2", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showGenderStatistics() {
		System.out.println("The percentage of women in the company is: " + (int) Statistics.calcFtoM() + "%");
		JFrame frame = new JFrame("Staff Management v 1.2");
		double ratioFtoMProf[] = Statistics.calculateFtoMProfession();
		JOptionPane.showMessageDialog(frame,
				"Gender Statistics" + "\nThe percentage of women in the company is: " + (int) Statistics.calcFtoM()
						+ "%" + "\nThe percentage of women among Secretaries is: " + (int)ratioFtoMProf[0] + "%"
						+ "\nThe percentage of women among Technicians is: " + (int)ratioFtoMProf[1] + "%"
						+ "\nThe percentage of women among Programmers is: " + (int)ratioFtoMProf[2] + "%"
						+ "\nThe percentage of women among Managers is: " + (int)ratioFtoMProf[3] + "%",
				"Staff manager version 1.2", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void removeEmployee() {
		String stringID = JOptionPane.showInputDialog("Enter Employee ID");
		int id = Integer.parseInt(stringID);
		Employee e = Main.findEmployeeByID(id);
		StaffManagement.fireEmployee(e);
		JFrame frame = new JFrame("Staff Management v 1.2");
		JOptionPane.showMessageDialog(frame, "Employee " + e.getName() + " has been removed");
		printAllEmployees();
	}
	
	public static Contact generateContact(String adr, String email, String phone) {
		Contact c = new Contact(adr, email, phone);
		return c;
	}

	public static String askAction() {

		final String[] action = { "Add Employee", "Update Employee", "Remove Employee", "Show Employee",
				"Calculate Salary and Bonus", "Show Salary Statistics", "Show Gender Statistics", "Bonus Details" };
		JFrame frame = new JFrame("Staff Management v 1.2");
		String selectedAction = (String) JOptionPane.showInputDialog(frame, "Select Action", "Action type",
				JOptionPane.QUESTION_MESSAGE, null, action, action[0]);

		// selectedProfession will be null if the user clicks Cancel
		if (selectedAction == null)
			System.exit(0);
		return selectedAction;

	}

	public static void getUserInput() {
		String selectedAction = askAction();

		switch (selectedAction) {

		case "Add Employee": {
			enterNewEmployees();
			printAllEmployees();
			break;
		}
		case "Update Employee": {
			updateEmployee();
			printAllEmployees();
			break;

		}
		case "Remove Employee": {
			removeEmployee();
			break;
		}
		case "Show Employee": {
			showEmployee();
			break;
		}
		case "Calculate Salary and Bonus": {
			calculateSalaryAndBonus();
			break;

		}
		case "Show Salary Statistics": {
			showSalaryStatistics();
			break;
		}
		case "Show Gender Statistics": {
			showGenderStatistics();
			break;
		}

		case "Bonus Details": {
			Main.bonusDetails();
			break;
		}

		default:
			System.out.println("Error in Ui.getUserInput()");
			System.exit(0);
			break;

		}
	}

	public static String askProfession() {

		final String[] professions = { "Secretary", "Technician", "Programmer", "Manager" };
		JFrame frame = new JFrame("Staff Management v 1.2");
		String selectedProfession = (String) JOptionPane.showInputDialog(frame, "Select Profession", "Profession type",
				JOptionPane.QUESTION_MESSAGE, null, professions, professions[0]);

		// selectedProfession will be null if the user clicks Cancel
		return selectedProfession;

	}

	public static void removeEmployee(int id) {
		Employee e = Main.findEmployeeByID(id);
		StaffManagement.fireEmployee(e);
	}

	public static GenderType askGender() {

		final String[] gender = { "Male", "Female" };
		JFrame frame = new JFrame("Staff Management v 1.2");
		String selectedGender = (String) JOptionPane.showInputDialog(frame, "Select Gender", "Gender type",
				JOptionPane.QUESTION_MESSAGE, null, gender, gender[0]);

		switch (selectedGender) {
		case "Male":
			return GenderType.MALE;
		case "Female":
			return GenderType.FEMALE;
		default:
			return null;
		}
		// selectedGender will be null if the user clicks Cancel

	}

	// Ask for user input to hire new Employees
	public static void enterNewEmployees() {

		String selectedProfession = askProfession();

		String name = JOptionPane.showInputDialog("Enter name");
		int age = 0;
		//Check that user inputs integer for age
		boolean ageCorrectFormat = false;
		while (!ageCorrectFormat) {
			try {
				String stringAge = JOptionPane.showInputDialog("Enter age");
				age = Integer.parseInt(stringAge);
				ageCorrectFormat = true;
			} catch (Exception e) {
				JFrame frame = new JFrame("Staff Manager v 1.2");
				JOptionPane.showMessageDialog(frame, "Age must be a number");
				System.out.println("Must be an integer");
			} 
		}
		String adr = JOptionPane.showInputDialog("Enter adress");
		
		String email = "";
		//Check that user inputs correct e-mail format
		boolean emailCorrectFormat = false;
		while(!emailCorrectFormat) {

			email = JOptionPane.showInputDialog("Enter e-mail");
			if (email.contains("@")) {
				emailCorrectFormat = true;
			}
			else {
				JFrame frame = new JFrame("Staff Management v 1.2");
				JOptionPane.showMessageDialog(frame, "Wrong e-mail format");
				System.out.println("Wrong email format");
			}

		}

		
		String phone = JOptionPane.showInputDialog("Enter phone");
		GenderType gndr = askGender();
		String stringSalary = JOptionPane.showInputDialog("Enter Salary");
		double salary = Double.parseDouble(stringSalary);
		
		switch (selectedProfession) {
		case "Secretary": {
			
			Employee e = new Secretary(name, age, generateContact(adr, email, phone), gndr, Profession.SECRETARY, 2017,
					salary, 1000, 1, true, 100);
			StaffManagement.hireEmployee(e);
			break;
		}
		case "Technician": {
			
			Employee e = new Technician(name, age, generateContact(adr, email, phone), gndr, Profession.TECHNICIAN,
					2017, salary, 1000, 1, true, 100, 3);
			StaffManagement.hireEmployee(e);
			break;
		}
		case "Programmer": {
			
			Employee e = new Programmer(name, age, generateContact(adr, email, phone), gndr, Profession.PROGRAMMER,
					2017, salary, 1000, 1, true, 100, 3);
			StaffManagement.hireEmployee(e);
			break;
		}
		case "Manager": {
			
			Employee e = new Manager(name, age, generateContact(adr, email, phone), gndr, Profession.MANAGER, 2017,
					salary, 1000, 1, true, 100, 3);
			StaffManagement.hireEmployee(e);
			break;
		}
		default:
			break;
		}
	}

}
