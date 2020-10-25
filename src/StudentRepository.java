/*
Author: Ria Mehta
File Version: 1.0
Time required: 3 hours
Description: Stores arrayList of objects.
Input: File name from main
Output: iterator for objects
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepository implements Container{
        protected ArrayList<Student> students = new ArrayList<>();

        public StudentRepository(String filePath){
            try{
                File myObj = new File(filePath);
                Scanner myReader = new Scanner(myObj);
                int countLine=0;

                //Skip first 2 lines from file roster-x.csv
                while (myReader.hasNextLine()) {
                    String data=myReader.nextLine();
                    countLine++;
                    if(countLine==2)
                        break;
                }

                // Start reading data from 3rd line
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    Student student= new Student(data);
                    students.add(student);
//                    System.out.println(data);
                }
                myReader.close();
            } catch(FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }


        public void addStudent(Student s){
            students.add(s);
        }

        @Override
        public Iterator getIterator() {
            return new StudentIterator();
        }

        private class StudentIterator implements Iterator {

            int index;

            @Override
            public boolean hasNext() {

                if(index < students.size()){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {

                if(this.hasNext()){
                    return students.get(index++);
                }
                return null;
            }
        }
}
