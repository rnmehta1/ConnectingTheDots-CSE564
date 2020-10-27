import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**

 *
 * @author Arunima Mookherjee
 * @version 1.0
 * @time-required 5
 */

public class Grader73 {

    public int gradeStudents(String filePath) {
        BufferedReader br = null;
        String nextLine = null;
        List<String> columns = new ArrayList<>();
        Map<String, String> gradeMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((nextLine = br.readLine()) != null) {
                String[] colNames = nextLine.split(",");
                for(String colName : colNames)
                    columns.add(colName);
            }
            while((nextLine = br.readLine()) != null) {
                String[] parts = nextLine.split(",", 2);
                gradeMap.put(parts[0], parts[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentRepo71Iterator studentRepo = StudentRepo71Iterator.getInstance();
        int unknown = 0;
        //Added
        List<Grade72Decorator> gradeLst = new ArrayList<>();
        //

        for(Iterator<?> iter = studentRepo.getIterator(); iter.hasNext();) {
            Student72Model student = (Student72CoreData) iter.next();
            //Added
            Grade72Decorator gStudent = new Grade72Decorator(student);

            String gradeCard = gradeMap.get(student.getStudentAsurite());
            if(gradeCard != null) {
                List<Grade72Model> gradesList = new ArrayList<>();
                String[] grades = gradeCard.split(",");
                for(int i = 0; i < grades.length; i++) {
                    Grade72Model grade = new Grade72Model(columns.get(i + 1), grades[i], "100");
                    gradesList.add(grade);
                }
                gStudent.add(gradesList);
                //Added
                gradeLst.add(gStudent);
            }
            else
                unknown++;
        }
        //Added
        for(Grade72Decorator g:gradeLst){
            studentRepo.add(g);
        }
        return unknown;
    }

}
