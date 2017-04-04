package ui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import static ui.Ui.*;

import models.*;
import utilities.*;

public class Main {
	
	public static ArrayList<Employee> empList = new ArrayList<>();
	
	public static Employee findEmployeeByID(int id) {
		for (int i = 0; i < empList.size(); i++) {
			if(empList.get(i).getId() == id) {
				return empList.get(i);
			}
			else
				System.out.print("");
		}
		return null;
	}

	public static void initiateEmployeeList() {
		
	    Contact contactS1 = new Contact("Main road 1", "siri@a.com", "074938832");
	    Contact contactS2 = new Contact("Main road 2", "susan@a.com", "074938832");
	    Contact contactT1 = new Contact("Park Ave 1", "tom@a.com", "072934532");
	    Contact contactP1 = new Contact("44th Street", "peter@a.com", "07439499");
	    Contact contactP2 = new Contact("55th Street", "patricia@a.com", "07439576");
	    Contact contactM1 = new Contact("Wall Str.1", "michael@a.com", "0784324581");    

	    Secretary s1 = new Secretary("Siri", 25, contactS1, GenderType.FEMALE, Profession.SECRETARY, 2016, 2000, 100, 1, true, 100);
	    Secretary s2 = new Secretary("Susan", 25, contactS2, GenderType.MALE, Profession.SECRETARY, 2016, 2587, 320, 1, true, 100);
	    Technician t1 = new Technician("Tom", 25, contactT1, GenderType.MALE, Profession.TECHNICIAN, 2013, 5000, 300, 1, true, 50, 10);
	    Programmer p1 = new Programmer("Peter", 30, contactP1, GenderType.MALE, Profession.PROGRAMMER, 2011, 1000, 500, 1, true, 500, 77);
	    Programmer p2 = new Programmer("Patricia", 30, contactP2, GenderType.FEMALE, Profession.PROGRAMMER, 2011, 2000, 50, 1, true, 400, 64);		
	    Manager m1 = new Manager("Michael", 52, contactM1, GenderType.MALE, Profession.MANAGER, 2000, 6500, 700, 10, true, 0, 0);

	    StaffManagement.hireEmployee(s1);
	    StaffManagement.hireEmployee(s2);
	    StaffManagement.hireEmployee(t1);
	    StaffManagement.hireEmployee(p1);
	    StaffManagement.hireEmployee(p2);
	    StaffManagement.hireEmployee(m1);
		
	}
	
	//Testing the Data
public static void testData() {
		
		initiateEmployeeList();
		
		String enterNew = JOptionPane.showInputDialog("Do you want to enter a new employee?");
		while(enterNew.equals("yes")) {
			enterNewEmployees();
			enterNew = JOptionPane.showInputDialog("Do you want to enter a new employee?");
		}
		
	
		printAllEmployees();
		Statistics.calculateSalary();
		Statistics.calculateAllBonus();
		printAllEmployees();
		Statistics.calculateFtoMProfession();
		
		System.out.println("Women make up " + (int)Statistics.calcFtoM() + "% of all employees\n");
		System.out.println("Lowest salary is €" + Statistics.calcMinSalary());
		System.out.println("Highest salary is €" + Statistics.calcMaxSalary());
		
		System.out.println("");
		System.out.println("Avgerage salary by profession: ");
		Statistics.calcAvgSalaryProfessions();	
		
		
		}

	public static void main(String[] args) {
			
				testData();
				StaffManagement.viewEmployee(findEmployeeByID(4));
				
				Secretary siri = (Secretary)findEmployeeByID(1);
				Technician tom = (Technician)findEmployeeByID(3); 
				Programmer peter = (Programmer)findEmployeeByID(4);
				Manager michael = (Manager)findEmployeeByID(6);
				
				System.out.println("\n");
		
				//Testing Employee methods
				
				System.out.println("\n");
				StaffManagement.viewEmployee(siri);
				System.out.println("");
				siri.printInfo();
				System.out.println("");				
				System.out.println("Secretary makes telephonecalls");
				siri.makeTelephoneCall(58);
				siri.printInfo();		
						

				System.out.println("\n");
				StaffManagement.viewEmployee(tom);
				System.out.println("");
				tom.printInfo();
				System.out.println("");				
				System.out.println("Technician fixes server");
				tom.fixServer();
				tom.printInfo();		
				System.out.println("");
				System.out.println("Technician crashes server");
				tom.crashServer();
				tom.printInfo();

				
				
				

				System.out.println("\n");
				StaffManagement.viewEmployee(peter);
				System.out.println("");
				peter.printInfo();
				System.out.println("");				
				System.out.println("Programmer writes programms");
				peter.writeProgram();
				peter.printInfo();		
				System.out.println("");
				System.out.println("Programmer makes some bugs");
				peter.makeBugs();
				peter.makeBugs();
				peter.makeBugs();
				peter.printInfo();

				
				System.out.println("\n");
				StaffManagement.viewEmployee(michael);
				System.out.println("");
				michael.printInfo();
				System.out.println("");				
				System.out.println("Manager increases production a little");
				michael.increaseProduction();
				michael.printInfo();
				System.out.println("");
				System.out.println("Manager receives some complaints");
				michael.receiveComplaints();
				michael.receiveComplaints();
				michael.receiveComplaints();
				michael.receiveComplaints();
				michael.printInfo();
				
				System.exit(0);
	
				

				
				
		
		

	}

}
