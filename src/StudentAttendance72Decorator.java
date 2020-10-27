/*
Author: Anurag Mishra
File Version: 1.0
Time required: 3 hours
*/
import java.util.LinkedList;
import java.util.ListIterator;

public class StudentAttendance72Decorator extends Student72Decorator {
	
	public Attendance72 attendValue = new Attendance72();
	public static LinkedList<Attendance72> attendance;
	
	public StudentAttendance72Decorator(String date,int minutes) {
		this.attendValue.setDate(date);
		this.attendValue.setMinutes(minutes);
		if (attendance == null) {
			attendance = new LinkedList<Attendance72>();
		}
	}
	
	@Override
    public void printValue(){
		super.printValue();
	    addStudentAttendance();
    }
	
	public void addStudentAttendance() {
		attendance.add(attendValue);
		for (Attendance72 attendObject : this.attendance ) {
			System.out.println("Date: " + attendObject.getDate() + " and minutes attended: " + attendObject.getMinutes());
			
		}
		
	}

}
