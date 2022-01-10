Gestione Ateneo - Estensione
============================
Estendere all' interno della classe UniversityExt le funzionalità già implementate nella classe University.
La nuova classe UniversityExt estende la classe University.
______________________________________________________________________________________________________________
R5 Esami
--------
Gli studenti possono sostenere gli esami degli insegnamenti a cui sono iscritti. Il voto di un esame può essere registrato tramite il metodo exam() che riceve come parametri l' ID dello studente, il codice del corso ed il voto ( un intero in 0-30 ).
Per ottenere la media dei voti di uno studente si usa il metodo studentAvg() che accetta come parametro l' ID dello studente. Se lo studente ha sostenuto almeno un esame il metodo restituisce una stringa con il seguente formato " Student STUDENT_ID : AVG_GRADE", altrimenti restituisce " Student STUDENT_ID hasn't taken any exams".
E' possibile ottenere la media dei voti di tutti gli studenti che hanno sostenuto l' esame di un dato insegnamento tramite il metodo courseAvg(), che accetta come parametro il codice del corso.
Il formato è il seguente " The average for the course COURSE_TITLE is : COURSE_AVG", se almeno uno studente ha sostenuto l' esame per l' insegnamento dato. Altrimenti il metodo restituisce " No student has taken the exame in COURSE_TITLE".

!! si può assumere che se uno studente sostiene un esame sia stato precedentemente iscritto all' insegnamento
_______________________________________________________________________________________________________________
R6. Premi per gli studenti
---------------------------
L' ateneo ha deciso di premiare i migliori studenti per il loro lavoro. Il metodo topThreeStudent() è utilizzato per reperire le informazioni che aiutino la commissione che dovrà prendere la decisione.
Il punteggio degli studenti è valutato sulla base della media degli esami sostenuti. Per tenere in considerazione anche degli esami sostenuti e non solo della media, viene assegnato un bonus aggiuntivo alla media: il numero degli esami sostenuti diviso il numero di insegnamenti a cui è iscritto lo studente, mltiplicato per 10 viene sommato alla media.
Il metodo restituisce una stringa con le informazioni relative ai tre studenti con il punteggio più alto.
Gli studenti vengono riportati uno per riga(le righe sono terminate dal "\n" e ciascuna linea è formattata come segue : "STUDENT_FIRSTNAME STUDENT_LASTNAME: SCORE"

!! si assuma che non ci siano parimerito
_______________________________________________________________________________________________________________
R7. Logger
-----------
Si aggiunga un log per le operazioni eseguite tramite la classe di facciata UniversityExt. Tali operazioni includono :
	- Iscrizione di uno studente : es. " New student enrolled: 1000, Mario Rossi"
	- Attivazione di un nuovo insegnamento : es. "New Course actived: 11, Object Programming, James Gosling"
	- Iscrizione di uno studente ad un insegnamento: es. " Student 1004 signed up for course 11"
	- Assegnazione del voto per un esame: es. "Student 10001 took an exam in course 12 with grade 27"
	
!! per eseguire il logging è disponibile un oiggetto logger di classe java.util.logging.logger all' interno della classe UniversityExt.

!! Si usi il metodo info() dell' oggetto logger per generare i messaggi.

!! Si noti che per defoult il logger stampi i messaggi sulla console.