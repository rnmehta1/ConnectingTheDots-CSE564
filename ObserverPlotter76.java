/*
@author Kanti Nizampatnam
Time required: 6 hours
Description: Observer Plotter class which plots grades retrieved from the table
when there is some change in the student class (grader.x.csv)
Challenges faced: Though the assignment has a straight forward solution and could be implemented easily but due
to coordination issues with the team and reliance on others deliverables the whole implementation could not be done on time.

NOTE:
Before the execution make sure jcommon and jfree jar files are included in the library.
*/



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.io.*;
import java.util.ArrayList;

public class ObserverPlotter76 extends ApplicationFrame implements Observer{

    @Override
    public void update(Observable o, Object arg) {

        Iterator iterator = (Iterator) getStudentIterator(o);
        ArrayList<String> column_Names = new ArrayList<>();

    public ObserverPlotter76( String applicationTitle , String chartTitle ) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Exam Type",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private CategoryDataset createDataset() {

        InputStream in = new FileInputStream( new File( "C:\\Users\\Kanti Nizampatnam\\Downloads\\grades.x.csv" ) );
        BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
        StringBuilder out = new StringBuilder();
        String line;
        final CategoryDataset dataset = createDataset(in);

        dataset.addChangeListener(new DatasetChangeListener() {

            @Override
            public void datasetChanged(DatasetChangeEvent arg0) {
                // TODO Auto-generated method stub
                repaint();
            }
        });



        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );


        return dataset;
    }

    public static void main( String[ ] args ) {
        ObserverPlotter76 chart = new ObserverPlotter76("Score,
                "student scores");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

        public StudentRepository71 getStudentIterator(Observable o) {
            return (StudentRepository71) ((StudentRepository71) o).getIterator();
        }

        public static ArrayList<ArrayList<String>> findData(Iterator iterator) {

                LinkedList<Grades72> grades_List = StudentGrades72Decorator.grades;
                if (grades_List.size() > 0) {
                    for (Grades72 gList : grades_List) {
                        student.add(String.valueOf(gList.result));
                    }
                }

                data_List.add(student);
            }
            return data_List;
        }
}
