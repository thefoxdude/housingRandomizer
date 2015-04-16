package Interface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportFromExcel {
	
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
	
	public void grabHosts(ArrayList<String[]> students) throws FileNotFoundException {
		String fName = ("hosts.csv");
		File F = new File(fName);
		Scanner S = new Scanner(F);
		S.useDelimiter(",");
		String host, info[];
		while (S.hasNextLine()) {
			host = S.nextLine();
			info = host.split(",");
			students.add(info);
		}
		S.close();
	}
}
