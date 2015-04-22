package Algorithm;

import java.util.ArrayList;

public class HostHome {
	private ArrayList<Student> studentsTaking;
	private String lastName;
	private int maxStudents;
	private boolean hasCats;
	private boolean hasDogs;
	private char genderTaking;
	private boolean hasUpperClassman;
	
	public HostHome(String lastName, int maxStudents, String allergies, char gender)
	{
		studentsTaking = new ArrayList<Student>();
		this.maxStudents = maxStudents;
		this.genderTaking = gender;
		hasUpperClassman = false;
		this.lastName = lastName;
		
		switch(allergies.toUpperCase())
		{
		case "NO":
			hasCats = false;
			hasDogs = false;
			break;
		case "DOG":
			hasCats = false;
			hasDogs = true;
			break;
		case "CAT":
			hasCats = true;
			hasDogs = false;
			break;
		case "BOTH":
			hasCats = true;
			hasDogs = true;
			break;
		}
	}
	
	public ArrayList<Student> getStudentsTaking() {
		return studentsTaking;
	}

	public void setStudentsTaking(ArrayList<Student> studentsTaking) {
		this.studentsTaking = studentsTaking;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public boolean isHasCats() {
		return hasCats;
	}

	public void setHasCats(boolean hasCats) {
		this.hasCats = hasCats;
	}

	public boolean isHasDogs() {
		return hasDogs;
	}

	public void setHasDogs(boolean hasDogs) {
		this.hasDogs = hasDogs;
	}

	public char getGenderTaking() {
		return genderTaking;
	}

	public void setGenderTaking(char genderTaking) {
		this.genderTaking = genderTaking;
	};
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isHasUpperClassman() {
		return hasUpperClassman;
	}

	public void setHasUpperClassman(boolean hasUpperClassman) {
		this.hasUpperClassman = hasUpperClassman;
	}
}
