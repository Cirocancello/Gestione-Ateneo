package university;

import java.util.Arrays;
import java.util.Comparator;

public class University {
	
	private static final int FIRST_COURSE_CODE = 10;
	private static final int MAX_COURSES = 50;
	private static final int MAX_STUDENTS = 1000;
	private static final int FIRST_STUDENT = 10000;
	
	private String name; //nome dell' università
	private String rector; // rettore dell' università
	
	private Student[] students = new Student[MAX_STUDENTS];
	private int nextStudentId = FIRST_STUDENT;	
	
	private Course[] courses = new Course[MAX_COURSES];
	private int nextCourseCode = FIRST_COURSE_CODE;	
	
	/**
	 * metodo costruttore che riceve in input il nome dell' ateneo
	 * @param name : nome dell' ateneo
	 */
	public University(String name) {		
		this.name = name;
	}
	
	/**
	 * restituisce il nome dell' universita
	 * @return
	 */	
	public String getName() {
		return this.name;
	}
	
	/**
	 * definisce informazioni del Rettore dell' università
	 * 
	 * @param first : nome del Rettore
	 * @param last  : cognome del Rettore
	 */	
	public void setRector(String first, String last) {
		this.rector = first + " " + last;
	}
	
	/**
	 * restituisce le informazioni sul Rettore
	 * @return
	 */
	public String getRector() {
		return this.rector;
	}
	
	/**
	 *  inserisce uno studente in una università
	 *  
	 * @param first : nome dello studente
	 * @param last  : cognome dello studente
	 * @return il metodo restituisce il numero di matricola che è stato assegnato allo studente
	 */
	public int enroll(String first, String last) {
		Student s = new Student(nextStudentId, first, last);
		students[nextStudentId - FIRST_STUDENT] = s;		
		return nextStudentId++;
	}
	
	/**
	 * Ritrova le informazioni di uno studente
	 * 
	 * @param id : la matricola dello studente 
	 * 
	 * @return restituisce una sringa composta da numero di matricola, nome e cognome 
	 *         separati da spazi e da una virgola.
	 */
	public String student(int id) {				
		return getStudent(id).toString();		
	}
	
	protected Student getStudent(int id) {
		return students[id - FIRST_STUDENT];
	}
	
// in alternativa si può usare questo metodo che fa esattamente la stessa operazione
	
//	public String student(int id) {
//	Student s = students[id - FIRST_STUDENT];
//	return s.toString();
//}
	
	
	/**
	 * Attiva un nuovo corso con il docente titolare
	 * 
	 * @param title    : titolo del corso
	 * @param teacher  : docente del corso
	 * 
	 * @return restituisce il codice assegnato al corso attivato
	 */
	public int activate(String title, String teacher) {
		Course c = new Course(nextCourseCode, title, teacher);
		courses[nextCourseCode - FIRST_COURSE_CODE] = c;
		return nextCourseCode++;
	}
	
	/**
	 * Ritrova le informazioni di un corso
	 * 
	 * @param cod : codice del corso
	 * 
	 * @return restituisce le informazioni del corso trovato
	 */
	public String course(int code) {		
		return getCourse(code).toString();
	}
	
	protected Course getCourse(int code) {
		return courses[code - FIRST_COURSE_CODE];
	}
	
	/**
	 * Registra uno studente al corso
	 * 
	 * @param studentID   : matricola dello studente
	 * @param courseCode  : codice del corso
	 */
	public void register(int studentID, int courseCode) {
		Student s = getStudent(studentID);
		Course c =  getCourse(courseCode);
		s.addStudyPlan(c);
		c.enrollStudent(s);
	}
	
	/**
	 * Ritrova una lista di attendees
	 * 
	 * @param courseCode id del corso
	 * @return ritorna la lista di attendees separati da "\n"
	 */
	public String listattendees(int courseCode) {
		return getCourse(courseCode).getEnrolledStudent();
	}
	
	/**
	 * Ritrova il piano di studi di uno studente
	 * 
	 * @param studentID
	 * @return
	 */
	public String studyPlan(int studentID) {
		return getStudent(studentID).getStudyPlan();
	}
	
	protected Student[] top(int n, Comparator<Student> cmp) {
		int numStudents =  nextStudentId - FIRST_STUDENT;
		n = Math.min(n, numStudents);
		Student[] sorted = Arrays.copyOf(students,  numStudents);
		Arrays.sort(sorted, cmp.reversed());
		return Arrays.copyOf(sorted, n);
	}
}
