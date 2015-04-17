package Algorithm;

public class Student {
	
	private String firstName;
	private String lastName;
	private int yearsInChoir;
	private boolean isAllergicToCats;
	private boolean isAllergicToDogs;
	private char gender;
	private char uncompatible;
	
	public Student(String firstName, String lastName, int yearsInChoir, 
			char gender, String allergies, char uncompatible)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsInChoir = yearsInChoir;
		this.gender = gender;
		this.uncompatible = uncompatible;
		
		switch(allergies.toUpperCase())
		{
		case "NO":
			isAllergicToCats = false;
			isAllergicToDogs = false;
			break;
		case "DOG":
			isAllergicToCats = false;
			isAllergicToDogs = true;
			break;
		case "CAT":
			isAllergicToCats = true;
			isAllergicToDogs = false;
			break;
		case "BOTH":
			isAllergicToCats = true;
			isAllergicToDogs = true;
			break;
		}
	}
	
	public Student(String firstName, String lastName, int yearsInChoir, 
			char gender, String allergies)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsInChoir = yearsInChoir;
		this.gender = gender;
		this.uncompatible = ' ';
		
		switch(allergies.toUpperCase())
		{
		case "NO":
			isAllergicToCats = false;
			isAllergicToDogs = false;
			break;
		case "DOG":
			isAllergicToCats = false;
			isAllergicToDogs = true;
			break;
		case "CAT":
			isAllergicToCats = true;
			isAllergicToDogs = false;
			break;
		case "BOTH":
			isAllergicToCats = true;
			isAllergicToDogs = true;
			break;
		}
	}
	
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
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getUncompatible() {
		return uncompatible;
	}

	public void setUncompatible(char uncompatible) {
		this.uncompatible = uncompatible;
	}
}
