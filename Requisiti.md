GESTIONE ATENEO
===============
Progettare ed implementare un programma che possa gestire corsi, docenti e studenti di un ateneo.
Tutte le classi devono appartenere al Pacakge university.											  
Il programma interagisce con i propri clienti attraverso la classe University.
_______________________________________________________________________________________________________											 
R1. Ateneo
-----------
La classe principale è Uniersity che riceve, come parametro del costruttore, il nome dell' ateneo.
Il nome dell' ateneo è leggibile tramite il metodo getName().
E' possibile definire il nome del rettore di un ateneo tramite il metodo setRector() che riceve come parametri nome e cognome del rettore.
Il metodo getRector() restituisce nome e cognome del rettore concatenati e separati da uno spazio(" ").
_______________________________________________________________________________________________________
R2. Studenti
-------------
E' possibile inserire le informazioni relative ad un nuovo studente tramite il metodo enRoll() della classe University, che riceve come parametri il nome ed il cognome dello studente; il metodo restituisce il numero di matricola che è stato assegnato allo studente.
I numeri di matricola vengono assegnati in maniera progressiva per ciascun ateneo a partire dal numero 10000. Quindi il primo studente iscritto ad ogni ateneo avrà matricola 10000.
Per ottenere le informazioni relative ad uno studente si utilizza il metodo student() che riceve come parametro la matricola e restituisce una sringa composta da numero di matricola, nome e cognome separati da spazi e da una virgola.
es. "1000, Giuseppe, Verdi"

(( si assuma che ciascun ateneo non possa contenere più di 100 studenti. ))
_______________________________________________________________________________________________________
R3. Insegnamenti
-----------------
Per definire un nuovo insegnamento si utilizza il metodo activate() che riceve come parametri il titolo del corso e il nome del docente titolare. Il metodo restituisce un intero che corrisponde al codice del corso. I codici vengono assegnati progressivamente a partire da 10.
Per conoscere le informazioni relative ad un corso si usa il metodo course() che riceve come parametro il codice del corso e restituisce una stringa contenente codice, titolo, e titolare del corso, separati da virgola.
es. "210, Programmazione a oggetti, James Gosling".

(( si assume che ogni ateneo non possa attivare più di 50 insegnamenti. ))
_______________________________________________________________________________________________________
R4. Iscritti agli insegnamenti
------------------------------
Gli studenti possono essere iscritti agli insegnamenti tramite il metodo register() che riceve come parametro la matricola dello studente ed il codice del corso dell' insegnamento.
Per ottenere l' elenco degli iscritti ad un insegnamento è disponibile il metodo listattendees() che riceve come parametro il codice dell' insegnamento e restituisce una stringa contenente l'elenco degli studenti iscritti.
Gli studenti compaiono uno per riga ( le righe sono terminate da un a-capo "\n" ) secondo il formato descritto al punto R2.
Data la matricola di uno studente, tramite il metodo studyPlan(), è possibile conoscere l' elenco degli insegnamenti a cui è iscritto, gli insegnamenti sono descritti come al punto precedente.

(( si assuma che ciascuno studente non possa assere iscritto a più di 25 insegnamenti e che un insegnamento non possa avere più di 100 studenti. ))


