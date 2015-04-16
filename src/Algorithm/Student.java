package Algorithm;

public class Student {
	
	private String firstName;
	private String lastName;
	private int yearsInChoir;
	private boolean isAllergicToCats;
	private boolean isAllergicToDogs;
	private String gender;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getYearsInChoir() {
		return yearsInChoir;
	}
	
	public void setYearsInChoir(int yearsInChoir) {
		this.yearsInChoir = yearsInChoir;
	}
	
	public boolean isAllergicToCats() {
		return isAllergicToCats;
	}
	
	public void setAllergicToCats(boolean isAllergicToCats) {
		this.isAllergicToCats = isAllergicToCats;
	}
	
	public boolean isAllergicToDogs() {
		return isAllergicToDogs;
	}
	
	public void setAllergicToDogs(boolean isAllergicToDogs) {
		this.isAllergicToDogs = isAllergicToDogs;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
}
