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
	StudentGrades72Decorator gradesCard = new StudentGrades72Decorator ("Quiz 1", 72, 100); //72%
	StudentGrades72Decorator gradesCard2 = new StudentGrades72Decorator ("Quiz 2", 75, 100); //75%
	/* each decorator object corresponds to one row in either the grades csv or attendance csv. every new row, create an object ,
	add in the data and add it an already **existing decorator** object. If none exist, add the student whose info this is related to the decorator.
	Use the very 1st decorator object's printVlaue method to obtain all info about the student.*/
	gradesCard2.add(gradesCard);
	gradesCard.add(attendanceCard);
    attendanceCard.add(newStudent);
    gradesCard2.printValue();
    }
}
