import java.util.ArrayList;

public class Ui {

	//method
	public static String viewEmployee(Employee e) {
		String details = "Name: " + e.getName() + " Age: " + e.getAge() + " Gender: " + e.getGender() + " Salary: " + e.getSalary()
				+ " Bonus: " + e.getBonus()  + " Startdate: " + e.getStartDate();
		return details;
	}

	static ArrayList<Employee> empList = new ArrayList<>();
	
	public static void initiateArrayList() {
		Contact contact1 = new Contact("Main road", "lisa@a.com", "074938832");
		Contact contact2 = new Contact("Park Ave", "tom@a.com", "072934532");
		Contact contact3 = new Contact("44th Street", "peter@a.com", "07439499");
		Contact contact4 = new Contact("Wall Str.", "geoffrey@a.com", "0784324581");

		Secretary s1 = new Secretary("Lisa", 25, contact1, GenderType.FEMALE, 2016, 45000, 3000, 1, true, 100);
		Technician t1 = new Technician("Tom", 25, contact2, GenderType.MALE, 2013, 50000, 3000, 1, true, 50, 10);
		Programmer p1 = new Programmer("Peter", 30, contact3, GenderType.MALE, 2011, 50000, 3000, 1, true, 500, 77);
		Manager m1 = new Manager("Geoffrey", 52, contact4, GenderType.MALE, 2000, 65000, 7000, 10, true, 650, 50);

		
		empList.add(s1);
		empList.add(t1);
		empList.add(p1);
		empList.add(m1);
	}
		
	//Calculate Average salary
	public static void calcAvgSalary() {
		double averageSalary = 0;
		double totalSalary = 0;

		for(Employee currentEmployee:empList){
			totalSalary += currentEmployee.getSalary() + currentEmployee.getBonus();

			averageSalary = totalSalary/empList.size();

		}
		System.out.println("total Salary of Employee is "+ totalSalary);
		System.out.println("average Salary Of all Employees is "+ averageSalary);

	}
		
		//Calculate Female-to-Male ratio
	public static double calcFtoM() {
		int males = 0;
		int females = 0;
		double ratioFtoM = 0;


		for(Employee currentEmployee:empList){
			if (currentEmployee.getGender().equals(GenderType.MALE)){
				males++;
				System.out.println(males);
			}
			else
			{
				females++;
				System.out.println(females);			
			}
			ratioFtoM = ((double)females/(males + females))*100;
		}
		return ratioFtoM;
	}

	
	public static void testData() {
		
		initiateArrayList();
	
		System.out.println("Ratio of Female to Male is " + calcFtoM());
		
		System.out.println(viewEmployee(empList.get(0)));
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
	
}







