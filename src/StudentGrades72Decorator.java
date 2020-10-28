/*
Author: Anurag Mishra
File Version: 1.0
Time required: 3 hours
*/
import java.util.LinkedList;

public class StudentGrades72Decorator extends Student72Decorator {
	
	public Grades72 gradeValue = new Grades72();
	
	public StudentGrades72Decorator(String quizName,int quizResult,int max) {
		this.gradeValue.setQuizName(quizName);
		this.gradeValue.setResult(quizResult);
		this.gradeValue.setMaxMarks(max);
		addStudentGrades();
	}
	
	@Override
    public void printValue(){
		super.printValue();
	    printStudentGrades();
    }
	
	public void addStudentGrades() {
		
		LinkedList<Grades72> grades = super.getGrades();
		grades.add(this.gradeValue);
	}
	
	public void printStudentGrades() {
			
		for (Grades72 gradeObject : super.getGrades() ) {
			System.out.println("Quiz Name: " + gradeObject.getQuizName() + " and result: " + gradeObject.getResult() +
	                " Out of total: " + gradeObject.getMaxMarks());				
		}	
	}

}
