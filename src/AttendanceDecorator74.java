import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Nilesh Mutyam
 * @since 10/24/2020
 * @File Version: 1.0
 * @Time required: 3 hours
 * @Description: This class is to decorate student object with attendance.
 * @Input: File name to read the attendance data.
 * @Output: Returns the number of unknowns.
 */

public class AttendanceDecorator74 {
	StudentRepository71 studentRepo;
	
	AttendanceDecorator74() {
		this.studentRepo = new StudentRepository71(); 
	}
	
	public int decorateStudentsWithAttendance(String fileName) {
		Iterator<StudentCoreData72> studentRepoIterator = this.studentRepo.getIterator(); 
		
		
		List<String[]> attList = new ArrayList<>();
		try {
			File fileObj = new File(fileName);
			Scanner sc = new Scanner(fileObj);
			while (sc.hasNextLine()) {
				String line[] = sc.nextLine().split(",");
				attList.add(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int flag=1;
		Map<String, List<Attendance72>> attendanceMap = new HashMap<>();
		List<Attendance72> dateList = new ArrayList<>();

		for (int r = 0; r < attList.size(); r++) {
			String row[] = (attList.get(r));
			for (int c = 0; c < row.length; c++) {
				row[c] = row[c].trim();
				if (flag==0) {
					try {
						if (c == 0) {
							List<Attendance72> attendanceList = new ArrayList<>();
							row[c] = row[c].split("@")[0];
							if (row[c].length() != 0) {
								attendanceMap.put(row[c], attendanceList);
							}
						} else {
							for (Attendance72 date : dateList) {
								Attendance72 attendance = (Attendance72) date.clone();
								attendance.setMinutes(Integer.valueOf(row[c]));
								if (attendanceMap.containsKey(row[0])) {
									attendanceMap.get(row[0]).add(attendance);
								}
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				} else {
					
					if (c != 0) {
						Attendance72 attendance = new Attendance72();
						attendance.setDate(row[c]);
						dateList.add(attendance);
					}

				}
			}
			flag=0;
		}

		
		
		int unknown = 0;
		List<StudentAttendance72Decorator> studentsAttendanceDecoratorBeanList = new ArrayList<>();
		while (studentRepoIterator.hasNext()) {
			StudentCoreData72 student = studentRepoIterator.next();
			if (attendanceMap.containsKey(student.getAsurite())) {

				List<Attendance72> attendanceList = attendanceMap.get(student.getAsurite());
				StudentAttendance72Decorator studentAttendanceDecorator = new StudentAttendance72Decorator(student);

				for (Attendance72 attend : attendanceList) {
//					studentAttendanceDecorator.addStudentAttendance(attend);
					studentAttendanceDecorator.attendValue=attend;		///////// 
					studentAttendanceDecorator.addStudentAttendance();
				}

				studentRepoIterator.remove();
				studentsAttendanceDecoratorBeanList.add(studentAttendanceDecorator);

			} else {
				unknown += 1;
			}

		}

		for (StudentAttendance72Decorator studentAttendancedecorator : studentsAttendanceDecoratorBeanList) {
			this.studentRepo.addStudent(studentAttendancedecorator);
		}

		return unknown;

	}

}
