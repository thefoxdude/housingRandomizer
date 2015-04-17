package Interface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Algorithm.Student;
import Algorithm.HostHome;

public class ImportFromExcel {
	
	// for filling class Students
	public void grabStudents(ArrayList<String[]> students) throws FileNotFoundException {
		String fName = ("students.csv");
		File F = new File(fName);
		Scanner S = new Scanner(F);
		S.useDelimiter(",");
		String student, info[];
		while (S.hasNextLine()) {
			student = S.nextLine();
			info = student.split(",");
			students.add(info);
		}
		S.close();
	}
	
	// for filling class Student
	public void grabStudent(ArrayList<Student> student) throws FileNotFoundException {
		String fName = ("students.csv");
		File F = new File(fName);
		Scanner S = new Scanner(F);
		S.useDelimiter(",");
		String info[], line;
		String nameF, nameL, alergies;
		char gender, compatibility;
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
				compatibility = info[5].charAt(0);
				student.add(new Student(nameF, nameL, years, gender, alergies, compatibility));
			} catch (Exception e) {
				student.add(new Student(nameF, nameL, years, gender, alergies));
			}
		}
		S.close();
	}
	
	// for filling class Hosts
	public void grabHosts(ArrayList<String[]> hosts) throws FileNotFoundException {
		String fName = ("hosts.csv");
		File F = new File(fName);
		Scanner S = new Scanner(F);
		S.useDelimiter(",");
		String host, info[];
		while (S.hasNextLine()) {
			host = S.nextLine();
			info = host.split(",");
			hosts.add(info);
		}
		S.close();
	}
	
	// for filling class HostHome
	public void grabHost(ArrayList<HostHome> hostHome) throws FileNotFoundException {
		String fName = ("hosts.csv");
		File F = new File(fName);
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
			numberTaking = Integer.parseInt(info[2]);
			alergies = info[3];
//			hostHome.add(new HostHome(nameL, numberTaking, gender, alergies));
		}
	}
	
	
}
