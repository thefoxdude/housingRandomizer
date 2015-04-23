package Interface2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Algorithm.HostHome;
import Algorithm.Student;

public class ImportFromExcel2 {
	
	// grab all the students
	public ArrayList<Student> grabStudentList(ArrayList<Student> student) throws FileNotFoundException {
		String fName = ("students.csv");
		File F = new File(fName);
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
	public ArrayList<HostHome> grabHostList(ArrayList<HostHome> hostHome) throws FileNotFoundException {
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
			numberTaking = Integer.parseInt(info[3]);
			alergies = info[2];
			hostHome.add(new HostHome(nameL, numberTaking, alergies, gender));
		}
		S.close();
		return hostHome;
	}
}