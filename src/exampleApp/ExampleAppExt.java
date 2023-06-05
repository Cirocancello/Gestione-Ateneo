package GestioneAteneo.src.exampleApp;

import GestioneAteneo.src.university.UniversityExt;

public class ExampleAppExt {

	public static void main(String[] args) {
		
		String universityName = "Federico II";
		
		UniversityExt poli = new UniversityExt(universityName);
		
		poli.setRector("Guido", "Saracco");

		System.out.println("Rector of " + poli.getName() + " : " + poli.getRector());
		
		int s1 = poli.enroll("Mario", "Rossi");
		int s2 = poli.enroll("Giuseppe", "Verdi");
		
		System.out.println("Enrolled students " + s1 + ", " + s2);
		System.out.println("s1 = " + poli.student(s1));
		System.out.println("s2 = " + poli.student(s2));
		
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		
		System.out.println("Actived courses " + macro + " and " + oop);
		System.out.println(poli.course(macro));
		System.out.println(poli.course(oop));
		
		poli.register(s1,macro);
		poli.register(s2,macro);
		poli.register(s1,oop);
		
		
		System.out.println(poli.listattendees(macro));
		// 10000 Mario Rossi
		// 10001 Giuseppe Verdi
		
		System.out.println(poli.studyPlan(s2));
		System.out.println(poli.studyPlan(s1));
		// 10 Macro Economies, Paul Krugman
		// 11 Object Oriented Programming, James Gosling
				
		poli.exam(s1, macro, 27);
		poli.exam(s2, macro, 30);
		poli.exam(s2, oop, 28);
		
		System.out.println(poli.studentAvg(s2)); // 29.0
		System.out.println(poli.courseAvg(macro)); // 28.5
		
		System.out.println("Best students:\n"+ poli.topThreeStudents());

	}

}
