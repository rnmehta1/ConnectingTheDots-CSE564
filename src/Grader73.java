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
 * time taken : 5 hours
 * @version 1.0
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
        Iterator71 studentRepo = StudentRepository71.getIterator();
        int unknown = 0;


        while (studentRepo.hasNext())
        {
            Student71 temp = studentRepo.next();
            String asurite = temp.getAsurite();
            if(gradeMap.contains(asurite))
            {
                String grades = gradeMap.get(asurite);
                String[] gradesSplit = srades.split(',');
                for(int i = 1; i < columns.size(); ++i)
                {
                    temp.add(new StudentGrades72Decorator(columns.get(i), gradesSplit.get(i - 1)));
                }
            }
            else
            {
                unknown++;
            }
        }
        return unknown;
    }

}
