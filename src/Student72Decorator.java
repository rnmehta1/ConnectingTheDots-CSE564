/*
Author: Anurag Mishra
File Version: 1.0
Time required: 3 hours
*/
import java.util.LinkedList;
public class Student72Decorator extends Student71 {
	
	protected Student71 student;
	protected LinkedList<Grades72> grades = new LinkedList<Grades72>();
	protected LinkedList<Attendance72> attendanceList = new LinkedList<Attendance72>();
	
	public void add(Student71 student) {
		this.student = student;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.student.getId();
	}

	@Override
	public String getFirst_name() {
		// TODO Auto-generated method stub
		return this.student.getFirst_name();
	}

	@Override
	public String getLast_name() {
		// TODO Auto-generated method stub
		return this.student.getLast_name();
	}

	@Override
	public String getProgramPlan() {
		// TODO Auto-generated method stub
		return this.student.getProgramPlan();
	}

	@Override
	public String getAcademic_level() {
		// TODO Auto-generated method stub
		return this.student.getAcademic_level();
	}

	@Override
	public String getAsurite() {
		// TODO Auto-generated method stub
		return this.student.getAsurite();
	}
	
	@Override
    public void printValue(){
		if (student != null) {
			this.student.printValue();
		}       
    }
	
	public LinkedList<Grades72> getGrades() {
		return this.grades;
	}
	
	public LinkedList<Attendance72> getAttendanceList() {
		return this.attendanceList;
	}
	
	public void setGrades(Grades72 grade) {
		this.grades.add(grade);
	}
	
	public void setAttendanceList(Attendance72 attendance) {
		this.attendanceList.add(attendance);
	}

}
