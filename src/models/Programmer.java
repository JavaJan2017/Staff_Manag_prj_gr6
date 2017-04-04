package models;
import utilities.*;

public class Programmer extends Employee {

		//Class fields
		int nPrograms;
		int nTotalBugs;
		
		
		//Constructor
		public Programmer(String name, int age, Contact contact, GenderType gender, Profession profession, int startDate, double salary,
				double bonus, int absentDays, boolean inCompany, int nPrograms, int nTotalBugs) {
			
			super(name, age, contact, gender, profession, startDate, salary, bonus, absentDays, inCompany);
			this.nPrograms = nPrograms;
			this.nTotalBugs = nTotalBugs;
		}

		//Class methods
		@Override
		public double calculateBonus() {
			double bonus = getBonus() + (nPrograms * 15) - (nTotalBugs * 7) - (absentDays * 5);
			return bonus;
		}
		
		public void writeProgram() {
			nPrograms += 1;
		}
		public void makeBugs() {
			nTotalBugs+= 1;
		}

		public int getnPrograms() {
			return nPrograms;
		}

		public int getnTotalBugs() {
			return nTotalBugs;
		}

		public void printInfo() {
			System.out.println("Number of programs: " + nPrograms + "  Total Bugs: " + nTotalBugs + "  Absent days: " + absentDays + "  Bonus: €" + calculateBonus());
		}
		
}
