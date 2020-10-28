/*
Author: Ria Mehta
File Version: 1.0
Time required: 5 hours
Description: Stores arrayList of objects.
Input: File name from main
Output: iterator for objects
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Observable;
import java.util.Observer;


public class StudentRepository71 extends Observable implements Container71 {

        protected ArrayList<Student71> student71s = new ArrayList<>();
        //private List<Observer> observers = new LinkedList<>();

        public void initStudentRepository71(String filePath){
            try{
            	System.out.println("Entered student repo");
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
                    Student71 student71 = new StudentCoreData72(data);
                    addStudent(student71);
                    //student71s.add(student71);
                    //setChanged();
                    //notifyObservers(student71s);
                    System.out.println(data);
                }
                myReader.close();
            } catch(FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

		public void addStudent(Student71 s){
			System.out.println("adding student");
            student71s.add(s);
            setChanged();
            notifyObservers(student71s);
            
        }

        @Override
        public Iterator71 getIterator() {
            return new StudentIterator71();
        }

        private class StudentIterator71 implements Iterator71 {

            int index;

            @Override
            public boolean hasNext() {

                if(index < student71s.size()){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {

                if(this.hasNext()){
                    return student71s.get(index++);
                }
                return null;
            }
        }

		/*public void register(Table75Observer tableObserver) {
			observers.add(tableObserver);
			
		}*/
}
