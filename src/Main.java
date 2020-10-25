/*
Author: Ria Mehta
File Version: 1.2
Time required: 3 hours
Description: Driver class for the project. Project starts and ends here. Iterator Pattern is implemented.
Output: Student Information
*/
public class Main {

    public static void main(String[] args) {

//        Student ria= new Student("roster-x.csv");
        StudentRepository studentRepository = new StudentRepository("roster-x.csv");

        StudentSubject studentSubject = new StudentSubject();
        for(Iterator iter = studentRepository.getIterator(); iter.hasNext();){
            Student student = (Student)iter.next();
            System.out.println("ID: "+ student.getId());
            System.out.println("Name: " + student.getFirst_name()+ " "+ student.getLast_name());
            System.out.println("Program and Plan: " + student.getProgramPlan());
            System.out.println("Academic Level: " + student.getAcademic_level());
            System.out.println("Asurite: " + student.getAsurite());
            studentSubject.register(student);
        }

        //Observer Pattern
        //An example of adding a new student
        Student newStudent= new Student("1230321,Ria,Mehta,Software Engineering MS,Graduate,rnmehta1");
        studentSubject.register(newStudent);
        studentSubject.setState(1);  //Add student
        studentRepository.addStudent(newStudent);
        //Print all students
        for(Iterator iter = studentRepository.getIterator(); iter.hasNext();){
            Student student = (Student)iter.next();
            System.out.println("ID: "+ student.getId());
            System.out.println("Name: " + student.getFirst_name()+ " "+ student.getLast_name());
            System.out.println("Program and Plan: " + student.getProgramPlan());
            System.out.println("Academic Level: " + student.getAcademic_level());
            System.out.println("Asurite: " + student.getAsurite());
        }

    }
}

