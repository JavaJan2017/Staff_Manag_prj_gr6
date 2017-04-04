package ui;

import java.util.ArrayList;
import static ui.Ui.*;
import java.util.Date;

import models.Employee;
import models.Manager;
import models.Programmer;
import models.Secretary;
import models.Technician;
import utilities.Contact;
import utilities.GenderType;
import utilities.Profession;

public class Main {

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
	    Manager m1 = new Manager("Michael", 52, contactM1, GenderType.MALE, Profession.MANAGER, 2000, 6500, 700, 10, true, 650, 50);

	    Ui.hireEmployee(s1);
	    Ui.hireEmployee(s2);
	    Ui.hireEmployee(t1);
	    Ui.hireEmployee(p1);
	    Ui.hireEmployee(p2);
	    Ui.hireEmployee(m1);
		
	}
	
	//Testing the Data
public static void testData() {
		
		initiateEmployeeList();
		enterNewEmployees();
	
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
		
				//Create an ArrayList of existing employees
				

				
				
		
		

	}

}
