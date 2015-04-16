package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

//The class that sorts out students into homestays.  It sorts by randomly assigning students
//to homes as long as they set the list of criteria.
public class Algorithm {
	
	//Sorts a given list of students into a list of host homes.  THe students are placed
	//inside of the arraylist within each host home, so a return type is not needed as the 
	//host homes are modified.
	
	//Should think about a way to handle a student not being able to be scheduled into any home
	public static ArrayList<Student> sortStudents(ArrayList<Student> students, ArrayList<HostHome> hosts)
	{
		boolean studentScheduled;
		boolean schedule;
		int homeCount;
		HostHome currentHome;
		ArrayList<Student> unscheduledStudents = new ArrayList<Student>();
		
		for(int x = 0; x < 100; x++)
		{
			//Randomizes the students for a different result each time
			Collections.shuffle(students);
			
			for(Student student : students)
			{
				studentScheduled = false;
				
				while(!studentScheduled)
				{
					schedule = true;
					homeCount = 0;
					currentHome = hosts.get(homeCount);
					
					//Do not scheduled if the home is already full
					if(currentHome.getStudentsTaking().size() == currentHome.getMaxStudents())
						schedule = false;
					
					//Do not schedule if there is not an upper classman and it will fill the home
					if(currentHome.getStudentsTaking().size() == currentHome.getMaxStudents() - 1 && 
							!currentHome.isHasUpperClassman() && student.getYearsInChoir() == 1)
						schedule = false;
					
					//Do not schedule if there is an allergy conflict
					if(student.isAllergicToCats() == currentHome.isHasCats())
						schedule = false;
					if(student.isAllergicToDogs() == currentHome.isHasDogs())
						schedule = false;
					
					
					//Do not schedule if the gender does not match
					if(student.getGender() != currentHome.getGenderTaking())
						schedule = false;
					
					if(schedule) {
						currentHome.getStudentsTaking().add(student);
						studentScheduled = true;
					}
					
					homeCount++;
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
}
