package Algorithm;

import java.util.ArrayList;

public class HostHome {
	private ArrayList<Student> studentsTaking;
	private String lastName;
	private int maxStudents;
	private int numStudentsAvailable;
	private boolean hasCats;
	private boolean hasDogs;
	private char genderTaking;
	private boolean hasUpperClassman;
	
	public HostHome(String lastName, int maxStudents, char allergies, char gender)
	{
		studentsTaking = new ArrayList<Student>();
		this.maxStudents = maxStudents;
		this.numStudentsAvailable = maxStudents;
		this.genderTaking = gender;
		hasUpperClassman = false;
		this.lastName = lastName;
		
		switch(Character.toUpperCase(allergies))
		{
		case 'N':
			hasCats = false;
			hasDogs = false;
			break;
		case 'D':
			hasCats = false;
			hasDogs = true;
			break;
		case 'C':
			hasCats = true;
			hasDogs = false;
			break;
		case 'B':
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

	public int getNumStudentsAvailable() {
		return numStudentsAvailable;
	}

	public void setNumStudentsAvailable(int numStudentsAvailable) {
		this.numStudentsAvailable = numStudentsAvailable;
	}
}
