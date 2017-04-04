package ui;

import models.Employee;
import static ui.Main.empList;
import utilities.GenderType;

public class Statistics {
	
	static double[] avgSalaryProfession = new double[4];

	//Calculate Average salary
	public static double calcAvgSalary() {
		
	//	empList.size();
		
		double averageSalary = 0;
		double totalSalary = 0;

		for(Employee e : empList){
			totalSalary += e.getSalary() + e.getBonus();

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
				totalSalarySecretary += e.getSalary();
				avgSalarySecretary = totalSalarySecretary / nSecretaries;				
				break;
				
			case TECHNICIAN: 
				nTechnicians++;
				totalSalaryTechnician += e.getSalary();
				avgSalaryTechnician = totalSalaryTechnician / nTechnicians;				
				break;
				
			case PROGRAMMER: 
				nProgrammers++;
				totalSalaryProgrammer += e.getSalary();
				avgSalaryProgrammer = totalSalaryProgrammer / nProgrammers;
				break;
				
			case MANAGER: 
				nManagers++;
				totalSalaryManager += e.getSalary();
				avgSalaryManager = totalSalaryManager / nManagers;
				break;
			default:
				break;			
			}			
		}
		avgSalaryProfession[0] = avgSalarySecretary;
		avgSalaryProfession[1] = avgSalaryTechnician;
		avgSalaryProfession[2] = avgSalaryProgrammer;
		avgSalaryProfession[3] = avgSalaryManager;
		System.out.println("Average salary for Secretary is €" + avgSalarySecretary);
		System.out.println("Average Salary for Technician is €" + avgSalaryTechnician);
		System.out.println("Average salary for Prgrammer is €" + avgSalaryProgrammer);
		System.out.println("Average salary for Manager is €" + avgSalaryManager);		
	}
		
		//Calculate Female-to-Male ratio
	public static double calcFtoM() {
		int males = 0;
		int females = 0;
		double ratioFtoM = 0;

		for(Employee e : empList){
			if (e.getGender().equals(GenderType.MALE)) {
				males++;
			}
			else
			{
				females++;
			}
			ratioFtoM = ((double)females / (males + females)) * 100;
		}
		return ratioFtoM;
	}

	public static void calculateFtoMProfession(){

		int malesSecretary  = 0;
		int malesTechnician  = 0;
		int malesProgrammer  = 0;
		int malesManager  = 0;
		int femalesSecretary = 0;
		int femalesTechnician = 0;
		int femalesProgrammer = 0;
		int femalesManager = 0;
		double ratioFtoMSecretary = 0;
		double ratioFtoMTechnician = 0;
		double ratioFtoMProgrammer = 0;
		double ratioFtoMManager = 0;

		for(Employee e : empList) {

			switch (e.getProfession()) {
			case SECRETARY: 
				if (e.getGender().equals(GenderType.MALE)) {
					malesSecretary++;
				}
				else
				{
					femalesSecretary++;
				}
				ratioFtoMSecretary = ((double)femalesSecretary / (malesSecretary + femalesSecretary)) * 100;



				break;

			case TECHNICIAN: 
				if (e.getGender().equals(GenderType.MALE)) {
					malesTechnician++;
				}
				else
				{
					femalesTechnician++;
				}
				ratioFtoMTechnician = ((double)femalesTechnician / (malesTechnician + femalesTechnician)) * 100;	

				break;

			case PROGRAMMER: 
				if (e.getGender().equals(GenderType.MALE)) {
					malesProgrammer++;
				}
				else
				{
					femalesProgrammer++;
				}
				ratioFtoMProgrammer = ((double)femalesProgrammer / (malesProgrammer + femalesProgrammer)) * 100;

				break;

			case MANAGER: 
				if (e.getGender().equals(GenderType.MALE)) {
					malesManager++;
				}
				else
				{
					femalesManager++;
				}
				ratioFtoMManager = ((double)femalesManager / (malesManager + femalesManager)) * 100;

				break;
			default:
				break;			
			}			
		}

		System.out.println("Ratio F to M in Profession Secretary is: "+ratioFtoMSecretary);
		System.out.println("Ratio F to M in Profession Technician is: "+ratioFtoMTechnician);
		System.out.println("Ratio F to M in Profession Programmer is: "+ratioFtoMProgrammer);
		System.out.println("Ratio F to M in Profession Manager is: "+ratioFtoMManager);

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
	
	
	public static void calculateAllBonus() {
		for(Employee e : empList) {
			e.calculateBonus();
		}
	}

}
