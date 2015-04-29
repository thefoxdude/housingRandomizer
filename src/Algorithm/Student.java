package Algorithm;

public class Student {
	
	private String firstName;
	private String lastName;
	private int yearsInChoir;
	private boolean isAlergicToCats;
	private boolean isAlergicToDogs;
	private char gender;
	private String uncompatible;
	private char alergies;
	
	public Student(String firstName, String lastName, int yearsInChoir, 
			char gender, char alergies, String uncompatible)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsInChoir = yearsInChoir;
		this.gender = gender;
		this.alergies = alergies;
		this.uncompatible = uncompatible;
		
		switch(Character.toUpperCase(alergies))
		{
		case 'N':
			isAlergicToCats = false;
			isAlergicToDogs = false;
			break;
		case 'D':
			isAlergicToCats = false;
			isAlergicToDogs = true;
			break;
		case 'C':
			isAlergicToCats = true;
			isAlergicToDogs = false;
			break;
		case 'B':
			isAlergicToCats = true;
			isAlergicToDogs = true;
			break;
		}
	}
	
	public Student(String firstName, String lastName, int yearsInChoir, 
			char gender, char alergies)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsInChoir = yearsInChoir;
		this.gender = gender;
		this.uncompatible = "";
		this.alergies = alergies;
		
		switch(Character.toUpperCase(alergies))
		{
		case 'N':
			isAlergicToCats = false;
			isAlergicToDogs = false;
			break;
		case 'D':
			isAlergicToCats = false;
			isAlergicToDogs = true;
			break;
		case 'C':
			isAlergicToCats = true;
			isAlergicToDogs = false;
			break;
		case 'B':
			isAlergicToCats = true;
			isAlergicToDogs = true;
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
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getYearsInChoir() {
		return yearsInChoir;
	}
	
	public void setYearsInChoir(int yearsInChoir) {
		this.yearsInChoir = yearsInChoir;
	}
	
	public boolean isAlergicToCats() {
		return isAlergicToCats;
	}
	
	public void setAlergicToCats(boolean isAlergicToCats) {
		this.isAlergicToCats = isAlergicToCats;
	}
	
	public boolean isAlergicToDogs() {
		return isAlergicToDogs;
	}
	
	public void setAlergicToDogs(boolean isAlergicToDogs) {
		this.isAlergicToDogs = isAlergicToDogs;
	}
	
	public void setAlergies(char alergies) {
		this.alergies = alergies;
	}
	
	public char getAlergies() {
		return alergies;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getUncompatible() {
		return uncompatible;
	}

	public void setUncompatible(String uncompatible) {
		this.uncompatible = uncompatible;
	}
}
