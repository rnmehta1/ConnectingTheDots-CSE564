import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Harshita Paila
 * @since 10/26/2020
 */
public class Main77 extends JFrame {

    /***
     * Creates the frame, file chooser and necessary buttons to generate reports
     */
    public void createFrame(){
        AtomicReference<StudentRepository71> studentRepository = null;
        // Grade class
        Grader73 grader = new Grader73();
        // Attendance class
        AttendanceDecorator74 attendance = new AttendanceDecorator74();

        JButton openRoster = new JButton("Open Roster");
        JButton openGrades = new JButton("Open Grades");
        JButton openAttendance = new JButton("Open Attendance");
        openRoster.addActionListener(e -> studentRepository.set(new StudentRepository71(openFile())));
        openGrades.addActionListener(e -> grader.gradeStudents(studentRepository, openFile()));
        openAttendance.addActionListener(e -> attendance.decorateStudentsWithAttendance(openFile()));

        // Observer for plots and table
        ObserverPlotter76 graphObserver = new ObserverPlotter76();
        Table75Observer tableObserver = new Table75Observer();

        // Attach the observers to the student subject
        StudentSubject71 studentSubject71 = new StudentSubject71();
        studentSubject71.register(graphObserver);
        studentSubject71.register(tableObserver);
        add(graphObserver);
        add(tableObserver);

        JPanel topPanel = new JPanel();
        topPanel.add(openRoster);
        topPanel.add(openGrades);
        topPanel.add(openAttendance);
        add(topPanel, BorderLayout.NORTH);
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);

        setVisible(true);
    }

    /***
     * File opener to get path of selected file
     * @return path of file as String
     */
    public static String openFile(){
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getPath();
        }
        return null;
    }

    /***
     * Main71 class to begin the application
     * @param args null
     */
    public static void main(String[] args) {
        Main77 main = new Main77();
        main.createFrame();
    }
}