import java.util.Date;


abstract public class Employee {

		//Class variables
		private String name;
		private int age;
		private Contact contact;
		private GenderType gender;
		private int startDate;
		private double salary;
		private double bonus;
		protected int absentDays;
		private boolean inCompany;
		
		//Constructor
		public Employee(String name, int age, Contact contact, GenderType gender, int startDate, double salary,
				double bonus, int absentDays, boolean inCompany) {
			//super(name, age, contact, gender, startDate, salary, bonus, absentDays, inCompany);
			this.name = name;
			this.age = age;
			this.contact = contact;
			this.gender = gender;
			this.startDate = startDate;
			this.salary = salary;
			this.bonus = bonus;
			this.absentDays = absentDays;
			this.inCompany = true;
		}
		
		//Class methods
		abstract public void calculateBonus();
		
		public void callInAbsence(int days) {
			absentDays += days;
		}
		
		public void resign() {
			inCompany = false;
		}
		
		public String getName() {
			return name;
		}
		
		public double getBonus() {
			return bonus;
		}
		
		public void setBonus(double bonus) {
			this.bonus = bonus;
		}
		
		public int getAbsentDays() {
			return absentDays;
		}
		
		public int yearsInCompany() {
			return (2017 - startDate);
		}
}
