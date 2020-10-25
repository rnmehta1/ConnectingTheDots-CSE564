/*
Author: Ria Mehta
File Version: 1.0
Time required: 3 hours
Description: Student Class stores information about students.
Input: Data from StudentRepository
Output: Gives Information through Public methods.
*/


public class Student implements Observer {
    private String id;
    private String first_name;
    private String last_name;
    private String programPlan;
    private String academic_level;
    private String asurite;
    private String[] data;

    public Student(String studentData){
        data=studentData.split(",");
        this.id=data[0];
        this.first_name=data[1];
        this.last_name=data[2];
        this.programPlan=data[3];
        this.academic_level=data[4];
        this.asurite=data[5];
    }

    // Getter functions for student Info
    public String getId(){
        return this.id;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public String getLast_name(){
        return this.last_name;
    }

    public String getProgramPlan(){
        return this.programPlan;
    }

    public String getAcademic_level(){
        return this.academic_level;
    }

    public String getAsurite(){
        return this.asurite;
    }

    public void printValue(){
        System.out.println("ID: "+ getId());
        System.out.println("Name: " + getFirst_name()+ " "+ getLast_name());
        System.out.println("Program and Plan: " + getProgramPlan());
        System.out.println("Academic Level: " + getAcademic_level());
        System.out.println("Asurite: " + getAsurite());
    }
    @Override
    public void update() {

        System.out.println("Student " + this.id + " is updated.");

    }
}
