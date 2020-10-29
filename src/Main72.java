import java.util.LinkedList;

/*
Author: Anurag Mishra
File Version: 1.0
Time required: 3 hours
*/
public class Main72 {
    public static void main(String[] args) {
	Student71 newStudent= new StudentCoreData72("1230321,Ria,Mehta,Software Engineering MS,Graduate,rnmehta1");
	//adding decorator pattern objects
	StudentAttendance72Decorator attendanceCard = new StudentAttendance72Decorator ("10/26", 72);
	StudentGrades72Decorator gradesCard = new StudentGrades72Decorator ("Quiz 1", 75, 100); //75%

	//StudentGrades72Decorator gradesCard2 = new StudentGrades72Decorator ("Quiz 2", 75, 100); //75%
	/* each decorator object corresponds to one row in either the grades csv or attendance csv. every new row, create an object ,
	add in the data and add it an already **existing decorator** object. If none exist, add the student whose info this is related to the decorator.
	Use the very 1st decorator object's printVlaue method to obtain all info about the student.*/
	gradesCard.add(attendanceCard);
    attendanceCard.add(newStudent);
    gradesCard.printValue();
    
    //======================================================
    LinkedList<Grades72> grades_List = StudentGrades72Decorator.grades;
	System.out.println(grades_List.size());
	if (grades_List.size() > 0) {
		for (Grades72 gList : grades_List) {
			System.out.println(gList.getResult());
		}
	}//------------------------------------------------------
	LinkedList<Attendance72> attendance_List = StudentAttendance72Decorator.attendanceList;
	System.out.println("attendance size- " + attendance_List.size());
	if (attendance_List.size() > 0) {
		for (Attendance72 attList : attendance_List) {
			System.out.println(attList.getMinutes());
		}
	}
	
	 newStudent.setGrades(gradesCard.getGrades());// storing student wise
	 System.out.println(newStudent.getGrades());
	 
	 StudentGrades72Decorator.grades.clear();
	 StudentAttendance72Decorator.attendanceList.clear();
	 LinkedList<Grades72> grades_List2 = StudentGrades72Decorator.grades;
		System.out.println(grades_List.size());
		if (grades_List2.size() > 0) {
			for (Grades72 gList : grades_List) {
				System.out.println(gList.getResult());
			}
		}else {
			System.out.println("grade list clear");
		}
		//------------------------------------------------------
		LinkedList<Attendance72> attendance_List2 = StudentAttendance72Decorator.attendanceList;
		System.out.println("attendance size- " + attendance_List.size());
		if (attendance_List2.size() > 0) {
			for (Attendance72 attList : attendance_List) {
				System.out.println(attList.getMinutes());
			}
		}else {
			System.out.println("attendance list clear");
		}
		
		System.out.println("new student grades are " +newStudent.getGrades());
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ stored for a student, now we remove instantiated decorator
	
    
    
	/*Student71 newStudent2= new StudentCoreData72("1230322,Anurag,Mishra,Software Engineering MS,Graduate,amishr57");
    StudentAttendance72Decorator attendanceCard2 = new StudentAttendance72Decorator ("10/28", 78);
	StudentGrades72Decorator gradesCard2 = new StudentGrades72Decorator ("Quiz 2", 72, 100); //72%
	StudentGrades72Decorator gradesCard3 = new StudentGrades72Decorator ("Quiz 3", 70, 100); //72% */
	
	
	
	
	
	
	
	
	
    System.out.println("==================================================");
    


    }
}
