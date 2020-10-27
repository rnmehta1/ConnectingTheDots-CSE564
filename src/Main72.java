
public class Main72 {
    public static void main(String[] args) {
	Student71 newStudent= new StudentCoreData72("1230321,Ria,Mehta,Software Engineering MS,Graduate,rnmehta1");
	StudentAttendance72Decorator attendanceCard = new StudentAttendance72Decorator ("10/26", 72);
	StudentGrades72Decorator gradesCard = new StudentGrades72Decorator ("Quiz 1", 72, 100); //5%
	StudentGrades72Decorator gradesCard2 = new StudentGrades72Decorator ("Quiz 2", 75, 100); //5%
	// more -first, last, program, level, asurite
	gradesCard2.add(gradesCard);
	gradesCard.add(attendanceCard);
    attendanceCard.add(newStudent);
    gradesCard2.printValue();
    }
}
