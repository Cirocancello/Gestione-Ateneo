package university;

public class Student {
	private static final int MAX_STUDY_PLAN = 25;
	private Integer id;
	private String first;
	private String last;
	
	private Course[] studyPlan = new Course[MAX_STUDY_PLAN];
	private int nextCourseCode = 0;
	
	private Exam[] exams = new Exam[MAX_STUDY_PLAN];
	private int nextExamIndex = 0;
	
	/**
	 * metodo costruttore
	 * @param id    matricola dello studente
	 * @param first nome dello studente
	 * @param last  cognome dello studente
	 */
	public Student(Integer id, String first, String last) {
		this.id = id;
		this.first = first;
		this.last = last;
	}

	public Integer getId() {
		return id;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}
	
	public int addStudyPlan(Course c) {
		studyPlan[nextCourseCode] = c;
		return nextCourseCode++;
	}
	
//	public String getStudyPlan() {
//		String result = "";
//		for(int i = 0; i < nextCourseCode; i++) {			
//				Course c = studyPlan[i];
//				if(c!=null) {
//				   result += c.toString() + "\n";
//			}
//		}
//		return result.trim();
//	}
	
	public String getStudyPlan() {
		StringBuffer bf = new StringBuffer();
		
		for(Course c : studyPlan) {
			if (c!=null) {
				bf.append(c.toString()).append("\n");
			}			
		}
		
		return bf.toString().trim();// trim toglie i caratteri speciali
									// l' ultimo torno a capo
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
			if (e == null ) {
				break;
			}
			sum += e.getGrade();
		}
		return sum / nextExamIndex;
	}

    public double getScore(){
    	double avg = average();
    	if (Double.isNaN(avg)) {
    		return Double.NEGATIVE_INFINITY;
    	} else {
    		avg += nextExamIndex / nextCourseCode * 10;
    	}
    	return avg;
    }
	
	@Override
	public String toString() {
		return  id + ", " + first + ", " + last ;
	}
	
	
	
	

}
