/*
Author: Ria Mehta
File Version: 1.2
Time required: 3 hours
Description: Driver class for the project. Project starts and ends here. Iterator Pattern is implemented.
Output: Student Information
*/
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
//        Student ria= new Student("roster-x.csv");
        StudentRepository studentRepository = new StudentRepository("roster-x.csv");

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

