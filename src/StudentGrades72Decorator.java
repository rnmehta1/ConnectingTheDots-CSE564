/*
Author: Anurag Mishra
File Version: 1.0
Time required: 3 hours
*/
import java.util.LinkedList;

public class StudentGrades72Decorator extends Student72Decorator {
	
	public Grades72 gradeValue = new Grades72();
	public static LinkedList<Grades72> grades;
	
	public StudentGrades72Decorator(String quizName,int quizResult,int max) {
		this.gradeValue.setQuizName(quizName);
		this.gradeValue.setResult(quizResult);
		this.gradeValue.setMaxMarks(max);
		if (this.grades == null) {
			this.grades = new LinkedList<Grades72>();
		}
	}
	
	@Override
    public void printValue(){
		super.printValue();
	    addStudentGrades();
    }
	
	public void addStudentGrades() {
		this.grades.add(this.gradeValue);
		for (Grades72 gradeObject : this.grades ) {
			System.out.println("Quiz Name: " + gradeObject.getQuizName() + " and result: " + gradeObject.getResult() +
                    " Out of total: " + gradeObject.getMaxMarks());
			
		}
		
	}

}
