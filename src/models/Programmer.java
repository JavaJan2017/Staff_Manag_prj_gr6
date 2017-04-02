
public class Programmer extends Employee {

		//Class variables
		int nPrograms;
		int nTotalBugs;
		
		
		//Constructor
		public Programmer(String name, int age, Contact contact, GenderType gender, int startDate, double salary,
				double bonus, int absentDays, boolean inCompany, int nPrograms, int nTotalBugs) {
			super(name, age, contact, gender, startDate, salary, bonus, absentDays, inCompany);
			this.nPrograms = nPrograms;
			this.nTotalBugs = nTotalBugs;
		}

		//Class methods
		@Override
		public void calculateBonus() {
			double bonus = (nPrograms * 15) - (nTotalBugs * 7) - (absentDays * 5);
			setBonus(bonus);
		}
		
		public void writeProgram() {
			nPrograms += 1;
		}

		public int getnPrograms() {
			return nPrograms;
		}

		public int getnTotalBugs() {
			return nTotalBugs;
		}

		
}
