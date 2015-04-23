package Interface2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Algorithm.Algorithm;
import Algorithm.HostHome;
import Algorithm.Student;

public class ImportFromExcel2 {
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	ArrayList<HostHome> hostHomeList = new ArrayList<HostHome>();
	
	// grab all the students
	public ArrayList<Student> grabStudentList(ArrayList<Student> student, String fileName) throws FileNotFoundException {
		File F = new File(fileName);
		Scanner S = new Scanner(F);
		S.useDelimiter(",");
		String info[], line;
		String nameF, nameL, alergies, compatibility;
		char gender;
		int years;
		while (S.hasNextLine()) {
			line = S.nextLine();
			info = line.split(",");
			nameF = info[0];
			nameL = info[1];
			gender = info[2].charAt(0);
			years = Integer.parseInt(info[3]);
			alergies = info[4];
			try {
				compatibility = info[5];
				student.add(new Student(nameF, nameL, years, gender, alergies, compatibility));
			} catch (Exception e) {
				student.add(new Student(nameF, nameL, years, gender, alergies));
			}
		}
		S.close();
		return student;
	}
	
	// grab all the hosts
	public ArrayList<HostHome> grabHostList(ArrayList<HostHome> hostHome, String fileName) throws FileNotFoundException {
		File F = new File(fileName);
		Scanner S = new Scanner(F);
		S.useDelimiter(",");
		String line, info[];
		String nameL, alergies;
		char gender;
		int numberTaking;
		while (S.hasNextLine()) {
			line = S.nextLine();
			info = line.split(",");
			nameL = info[0];
			gender = info[1].charAt(0);
			numberTaking = Integer.parseInt(info[3]);
			alergies = info[2];
			hostHome.add(new HostHome(nameL, numberTaking, alergies, gender));
		}
		S.close();
		return hostHome;
	}
	
	public void runAlgorithm(String group, String studentLocation, String hostLocation) {
		try {
			this.studentList = grabStudentList(studentList, studentLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.hostHomeList = grabHostList(hostHomeList, hostLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Student> unscheduledStudents = new ArrayList<Student>();
		if (group.equals("UCO")) {
			unscheduledStudents = Algorithm.scheduleUCO(this.studentList, this.hostHomeList);
			printOutput(this.hostHomeList, unscheduledStudents);
		}
		if (group.equals("Women's Choir")) {
			
		}
		if (group.equals("New Song")) {
			
		}
		if (group.equals("Male Choral")) {
			
		}
	}
	
	public void printOutput(ArrayList<HostHome> hostHomeList, ArrayList<Student> unscheduledStudents) {
		try {
			FileWriter writer = new FileWriter("Output.csv");
			writer.append("Scheduled Students");
			writer.append('\n');
			writer.append("Host Family Name");
			writer.append(' ');
			writer.append("Student Names");
			writer.append('\n');
			for (HostHome currentHome : hostHomeList) {
				writer.append(currentHome.getLastName());
				writer.append(' ');
				for (Student currentStudent : currentHome.getStudentsTaking()) {
					writer.append(currentStudent.getName());
					writer.append(",");
				}
				writer.append('\n');
			}
			writer.flush();
			writer.close();
			
			FileWriter writer2 = new FileWriter("UnscheduledStudents.csv");
			writer2.append("First Name");
			writer2.append(",");
			writer2.append("Last Name");
			writer2.append(",");
			writer2.append("Gender");
			writer2.append(",");
			writer2.append("Years in Choir");
			writer2.append(",");
			writer2.append("Alergies");
			writer2.append('\n');
			for (Student currentStudent : unscheduledStudents) {
				writer2.append(currentStudent.getFirstName());
				writer2.append(currentStudent.getLastName());
				writer2.append(",");
				writer2.append(Integer.toString(currentStudent.getYearsInChoir()));
				writer2.append(",");
				writer2.append(currentStudent.getGender());
				writer2.append(",");
				writer2.append(currentStudent.getAlergies());
				writer2.append('\n');
			}
			writer2.flush();
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
