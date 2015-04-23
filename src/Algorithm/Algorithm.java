package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

//The class that sorts out students into homestays.  It sorts by randomly assigning students
//to homes as long as they set the list of criteria.
public class Algorithm {
	
	//Sorts a given list of students into a list of host homes.  The students are placed
	//inside of the arraylist within each host home, so the arraylist that is returned is
	//a list of all the students that are unabled to be scheduled.
	
	public static ArrayList<Student> scheduleUCO(ArrayList<Student> students, ArrayList<HostHome> hosts)
	{
		boolean studentScheduled;
		boolean schedule;
		int homeCount;
		HostHome currentHome;
		ArrayList<Student> unscheduledStudents = new ArrayList<Student>();
		int testCount = 0;

		for(int x = 0; x < 100; x++)
		{
			//Randomizes the students for a different result each time
			Collections.shuffle(students);
			unscheduledStudents.clear();
			for(HostHome home : hosts)
				home.getStudentsTaking().clear();
			
			for(Student student : students)
			{
				studentScheduled = false;
				homeCount = 0;
				
				while(!studentScheduled)
				{
					schedule = true;
					currentHome = hosts.get(homeCount);
					
					//Do not scheduled if the home is already full
					if(currentHome.getStudentsTaking().size() == currentHome.getMaxStudents())
						schedule = false;
					
					//Do not schedule if there is an incompatible person in the room already
					for(Student otherStudent : currentHome.getStudentsTaking())
					{
						if(student.getUncompatible().length() > 0 && otherStudent.getUncompatible().length() > 0)
						{
							for(int i = 0; i < student.getUncompatible().length(); i++)
							{
								for(int j = 0; j < otherStudent.getUncompatible().length(); j++)
								{
									if(student.getUncompatible().charAt(i) == otherStudent.getUncompatible().charAt(j))
										schedule = false;
								}
							}
						}
					}
					
					//Do not schedule if there is not an upper classman and it will fill the home
					if(currentHome.getStudentsTaking().size() == currentHome.getMaxStudents() - 1 && 
							!currentHome.isHasUpperClassman() && student.getYearsInChoir() == 1)
						schedule = false;
					
					//Do not schedule if there is an allergy conflict
					if(student.isAlergicToCats() && currentHome.isHasCats())
						schedule = false;
					if(student.isAlergicToDogs() && currentHome.isHasDogs())
						schedule = false;
					
					
					//Do not schedule if the gender does not match
					if(student.getGender() != currentHome.getGenderTaking())
						schedule = false;
					
					if(schedule) {
						currentHome.getStudentsTaking().add(student);
						studentScheduled = true;
					}
					
					homeCount++;
					
					//If a student still has not been scheduled at the end of the list of homes,
					//then they are sent to the list of unscheduled students
					if(homeCount == hosts.size() && studentScheduled == false)
					{
						studentScheduled = true;
						unscheduledStudents.add(student);
					}
				}
			}
			
			//If the algorithm is done and there is an optimal schedule, return because we are done
			if(unscheduledStudents.size() == 0)
				return unscheduledStudents;
		}
		//If the loop completes and cannot find a result after 100 attempts, then return the students
		//that could not be scheudled
		return unscheduledStudents;
	}
	
	//Right now just outputs the results to the console
	public static void print(ArrayList<HostHome> hosts, ArrayList<Student> unscheduledStudents)
	{
		for(HostHome host : hosts)
		{
			System.out.println(host.getLastName());
			
			for(Student student : host.getStudentsTaking())
			{
				System.out.println(student.getFirstName() + " " + student.getLastName());
			}
			System.out.println("");
		}
		System.out.println("\nStudents that were unable to be scheduled:");
		for(Student student : unscheduledStudents)
		{
			System.out.println(student.getFirstName() + " " + student.getLastName());
		}
	}
}