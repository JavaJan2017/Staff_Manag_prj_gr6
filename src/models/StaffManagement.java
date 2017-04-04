package models;

import ui.*;
import utilities.*;

public class StaffManagement {
	
	
	// **********************************************
	// 	  ADDING, UPDATING AND REMOVING EMPLOYEE
	//***********************************************
		
		
	public static void viewEmployee(Employee e) {
		Ui.printHeader();
		Ui.printEmployee(e);
		}
	
	public static void updateContact(Contact c, String adr, String email, String phone) {
		c.setAdress(adr);
		c.setEmail(email);
		c.setPhone(phone);
	}

	public static void hireEmployee(Employee e) {
		Main.empList.add(e);
	}
	
	public static void fireEmployee(Employee e) {
		boolean exists = false;

		if(e == null) {
			System.out.println("Employee does not exist");
		}

		else {

			for(Employee emp : Main.empList) {
				if(e.equals(emp)) {
					exists = true;
					System.out.println("exists = true");
					break;
				}
				else {
					exists = false;
					System.out.println("exists = false");
				}
			}
			if (exists) {
				Main.empList.remove(e);
				e.setInCompany(false);
			}
			else
				System.out.println("Employee does not exist");
		}
	}
	
//	public static void updateEmployee(Employee e, String name, int age, Contact contact, GenderType gender, Profession profession, double salary,
//			double bonus, int absentDays) {
//		
//		e.setName(name);
//		e.setAge(age);
//		//e.contact = contact;
//		e.setGender(gender);
//		e.setProfession(profession);
//		e.setSalary(salary);
//		e.setBonus(bonus);
//		e.setAbsentDays(absentDays);
//		
//	}
	
	public static void updateEmployee(Employee e, String name, Contact contact, GenderType gender, int startYear) {
		e.setName(name);
		e.setContact(contact);
		e.setGender(gender);
		e.setStartDate(startYear);
	}
}
