import java.util.Date;

public class Secretary extends Employee {
	
	//Class variable
	private int nTelephoneCalls;
	
	public Secretary(String name, int age, Contact contact, GenderType gender, int startDate, double salary,
			double bonus, int absentDays, boolean inCompany, int calls) {
		super(name, age, contact, gender, startDate, salary, bonus, absentDays, inCompany);
		nTelephoneCalls = calls;
	}
	//Class methods
	public void calculateBonus() {
		double bonus = (nTelephoneCalls * 10) - (absentDays * 5);
		setBonus(bonus);
	}
	
	public void makeTelephoneCall(int n) {
		nTelephoneCalls += n;
	}
	
	public int getNTelephoneCalls() {
		return nTelephoneCalls;
	}
}
