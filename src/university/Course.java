package university;

public class Course {
 
	private static final int MAX_ENROLLED = 100;
	private Integer code;
	private String title;
	private String teacher;
	
	private Student[] enrolled = new Student[MAX_ENROLLED];
	private int nextStudentIndex = 0;
	
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
	
	@Override
	public String toString() {
		return code + ", " + title + ", " + teacher ;
	}
	
	
	
	
}
