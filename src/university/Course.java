package university;

public class Course {
 
	private static final int MAX_ENROLLED = 100;
	private Integer code;
	private String title;
	private String teacher;
	
	private Student[] enrolled = new Student[MAX_ENROLLED];
	private int nextStudentIndex = 0;
	
	private Exam[] exams = new Exam[MAX_ENROLLED];
	private int nextExamIndex = 0;
	
	public Course(Integer code, String title, String teacher) {
		this.code = code;
		this.title = title;
		this.teacher = teacher;
	}


	public Integer getCode() {
		return code;
	}


	public String getTitle() {
		return title;
	}


	public String getTeacher() {
		return teacher;
	}

	public int enrollStudent(Student s) {
		enrolled[nextStudentIndex] = s;
		return nextStudentIndex++;
	}

	public String getEnrolledStudent() {
		String result = "";
		
		for(int i = 0; i < nextStudentIndex; i++) {
			Student s = enrolled[i];
			result += s.toString() + "\n";
		}
		
		return result.trim();
	}
	
	public int addExam(Exam e) {
		exams[nextExamIndex] = e;
		return nextExamIndex++;
	}
	
	public double average() {
		if (nextExamIndex == 0) {
			return Double.NaN;
		}
		double sum = 0.0;
		for (Exam e : exams) {
			if (e == null) {
				break;
			}
			sum += e.getGrade();
		}
		return sum / nextExamIndex;
	}
	
	@Override
	public String toString() {
		return code + ", " + title + ", " + teacher ;
	}
	
	
	
	
}
