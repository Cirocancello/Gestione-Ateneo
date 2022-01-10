package university;

import java.util.logging.Logger;
import java.util.Comparator;

public class UniversityExt extends University {
	
	private final static Logger logger = Logger.getLogger("University");

	public UniversityExt(String name) {
		super(name);
		//Example of logging
		logger.info("Creating extended university object");
	}
	
	@Override
	public int enroll(String first, String last) {
		int id = super.enroll(first, last);
		logger.info("New student enrolled: " + id + ", " + first + " " + last);
		return id;
	}
	
	@Override 
	public int activate(String title, String teacher) {
		int id = super.activate(title, teacher);
		logger.info("New course activated: " + id + ", " + title + " " + teacher);
		return id;
	}
	
	@Override
	public void register(int studentId, int courseCode) {
		super.register(studentId, courseCode);
		logger.info("Student " + studentId + " signed up for course " + courseCode);
	}
	
	
	/**
	 * records the grade (integer 0-30) for an exam can
	 * 
	 * @param studentId   the ID of the student
	 * @param courseId    course code
	 * @param grade		  grade (0-30)
	 */
	public void exam(int studentId, int courseId, int grade) {
		Student s = getStudent(studentId);
		Course c = getCourse(courseId);
		Exam e = new Exam(s, c, grade);
		s.addExam(e);
		c.addExam(e);
		logger.info("Student " + studentId + " took an exam in course " + courseId + " with grade " + grade);

	}
	
	/**
	 * Computes the average grade for a student and formats it as a string
	 * using the following format
	 * 
	 * {@code "Student STUDENT_ID : AVG_GRADE"}
	 * 
	 * if the student has no exam recorded the method
	 * returns {@code "Student STUDENT_ID hasn't taken any exames"}
	 * 
	 * @param studentId  the ID of the student
	 * @return           the average grade formatted as a string.
	 */
	public String studentAvg(int studentId) {
		Student s = getStudent(studentId);
		double avg = s.average();
		if (Double.isNaN(avg)) {
			return "Student " + studentId + "hasn't taken any exames";
		} else {
			return "Student " + studentId + " : " + avg;
		}
	}
	
	/**
	 * Computer the average of all students that took the exame for a given course
	 * 
	 * the format is the following:
	 * {@code "The average for the course COURSE_TITLE is : COURSE_AVG"}. 
	 * 
	 * if no student took the exam for that course it returns {@code "No student has taken the exame in COURSE_TITLE"}
	 * 
	 * @param courseId course code
	 * @return the course average formatted as a string
	 */
	public String courseAvg(int courseId) {
		Course c = getCourse(courseId);
		double avg = c.average();
		if (Double.isNaN(avg)) {
			return "No student has taken the exame in " + c.getClass();
		} else {
			return"The average for the course " + c.getTitle() + "is : " + avg;
		}
			
	}
	
	/**
	 * Retrieve information for the best student to award a price.
	 * 
	 * @return info of the best three students.
	 */
	public String topThreeStudents() {
		Student[] top = top(3, Comparator.comparingDouble(Student::getScore));//getScore su tutti gli elementi di Studenti
		String res = "";
		for (Student s : top) {
			if (Double.NEGATIVE_INFINITY == s.getScore()) {
				continue;
			} else {
				res += s.getFirst() + " " + s.getLast() + " : " + s.getScore() + "\n"; 
			}
		}
		return res;
	}
}