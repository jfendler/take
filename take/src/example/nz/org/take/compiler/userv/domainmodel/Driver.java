package example.nz.org.take.compiler.userv.domainmodel;

/**
 * Bean class that is part of the example domain model.
 * http://www.businessrulesforum.com/2005_Product_Derby.pdf 
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class Driver {
	private boolean isMale = true;
	private int age = 18;
	private boolean hasDriversTrainingFromSchool = false;
	private boolean  hasDriversTrainingFromLicensedDriverTrainingCompany = false;
	private boolean hasTakenASeniorCitizenDriversRefresherCourse = false;
	private boolean hasBeenConvictedOfaDUI = false;
	private int numberOfAccidentsInvolvedIn = 0;
	private int numberOfMovingViolationsInLastTwoYears = 0;
	private int numberOfYearsWithUServ = 0;
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public boolean hasDriversTrainingFromSchool() {
		return hasDriversTrainingFromSchool;
	}
	public void setHasDriversTrainingFromSchool(boolean hasDriversTrainingFromSchool) {
		this.hasDriversTrainingFromSchool = hasDriversTrainingFromSchool;
	}
	public boolean hasDriversTrainingFromLicensedDriverTrainingCompany() {
		return hasDriversTrainingFromLicensedDriverTrainingCompany;
	}
	public void setHasDriversTrainingFromLicensedDriverTrainingCompany(
			boolean hasDriversTrainingFromLicensedDriverTrainingCompany) {
		this.hasDriversTrainingFromLicensedDriverTrainingCompany = hasDriversTrainingFromLicensedDriverTrainingCompany;
	}
	public boolean hasTakenASeniorCitizenDriversRefresherCourse() {
		return hasTakenASeniorCitizenDriversRefresherCourse;
	}
	public void setHasTakenASeniorCitizenDriversRefresherCourse(
			boolean hasTakenASeniorCitizenDriversRefresherCourse) {
		this.hasTakenASeniorCitizenDriversRefresherCourse = hasTakenASeniorCitizenDriversRefresherCourse;
	}
	public boolean hasBeenConvictedOfaDUI() {
		return hasBeenConvictedOfaDUI;
	}
	public void setHasBeenConvictedOfaDUI(boolean hasBeenConvictedOfaDUI) {
		this.hasBeenConvictedOfaDUI = hasBeenConvictedOfaDUI;
	}
	public int getNumberOfAccidentsInvolvedIn() {
		return numberOfAccidentsInvolvedIn;
	}
	public void setNumberOfAccidentsInvolvedIn(int numberOfAccidentsInvolvedIn) {
		this.numberOfAccidentsInvolvedIn = numberOfAccidentsInvolvedIn;
	}
	public int getNumberOfMovingViolationsInLastTwoYears() {
		return numberOfMovingViolationsInLastTwoYears;
	}
	public void setNumberOfMovingViolationsInLastTwoYears(
			int numberOfMovingViolationsInLastTwoYears) {
		this.numberOfMovingViolationsInLastTwoYears = numberOfMovingViolationsInLastTwoYears;
	}
	public int getNumberOfYearsWithUServ() {
		return numberOfYearsWithUServ;
	}
	public void setNumberOfYearsWithUServ(int numberOfYearsWithUServ) {
		this.numberOfYearsWithUServ = numberOfYearsWithUServ;
	}
	
	

}
