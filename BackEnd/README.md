# **Fisa cerintelor**
## Modulul BackEnd
###### Grupa:B1  Anul:2
## Cuprins:
1. Descriere
2. Entitati
3. Descrierea entitatilor
4. Actori & obiective
5. Scenarii de utilizare

## 1. Descriere
Primind diverse cerințe de la modulul Middleware, întrun
format JSON, se dorește transformarea acestor cerințe în
interogări asupra bazei de date, precum și trimiterea înapoi
către modul a răspunsurilor dorite, tot în format JSON.
## 2. Domenii
Se vor descrie scenariile de utilizare ale modulului.
## 3. Acționari/Interese
Modulul Middleware: trimite cerințele ce trebuie transformate
în interogări asupra bazei de date; primește rezultatele dorite
în urma interogării bazei de date.
## 4. Actori & obiective
Bazele de date: să stocheze și să ofere informațiile necesare
funcționării cu succes a aplicației.
Modulul conține cinci baze de date corespunzătoare
funcționalităților dorite. Respectiv baza de date pentru
admiterea la studii de licență, cea pentru admiterea la studii de
master, cea pentru preadmitere, cea pentru profesori și cea
pentru sălile necesare la examen.
## 5. Scenarii de utilizare
#### 1. Se dorește introducerea informațiilor unui utilizator în baza de date pentru admiterea la studiile de licență. 
Se vor prelua datele primite de la modulul Middleware și
vor fi transformate în interogări asupra tabelei Users și,
eventual, asupra tabelei Diploma_Bac. La efectuarea
operațiilor cu succes se va returna modulului Middleware un
răspuns de succes, în caz contrar se va trimite un mesaj de
eșec, eventual explicând eroarea întâlnită.  
#### 2. Se dorește repartizarea pe săli a candidaților ce doresc să susțină examenul de admitere la studiile de licență.
Se va interoga baza de date specifică admiterii la studiile
de licență și se va verifica dacă avem săli disponibile conform
orarului nostru, iar dacă da cât este capacitatea sălii alese,
precum și concurenții ce pot fi asignați sălii respective.
Informațiile vor fi salvate în formatul unor liste din care
reies informații despre concurenți, săli, intervalul orar necesar
susținerii examenului, precum și despre profesorii
supraveghetori.
Din nou, în cazul unui eșec, se va transmite modulului
Middleware un mesaj de eșec/eroare.
#### 3. Se dorește verificarea informațiilor introduse de utilizatori de către un administrator.
###### 3.1. Informațiile introduse sunt în regulă.
În acest caz, se poate merge mai departe și utilizatorul
poate fi luat în calcul pentru programarea examenului de
admitere.
Eventual, utilizatorul poate primi un mesaj din care sa
reiasă faptul că informațiile introduse sunt în regulă și că se
poate pregăti pentru examenul de admitere.
###### 3.2. Informațiile introduse nu sunt în regulă.
În acest caz, nu se merge mai departe, utilizatorul nu este
luat în calcul în vederea examinării.Eventual, utilizatorul poate primi un mesaj din care sa
reiasă faptul că informațiile introduse nu sunt în regulă și că ar
trebui să modifice ceva sau pur și simplu nu poate susține
examenul de admitere.

<p> Baza de date pentru admiterea la studii de licență va conține următoarele entități: </p>

**Users:**
<ul>
  <li> CNP(cheia primară) - câmp  unic ce ține valori întregi de maxim 13 cifre ce nu poate fi null; </li>
  <li> mail- câmp alfanumeric unic, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null; </li>
  <li> telefon- câmp alfanumeric unic, variabil ca dimensiune dar având maxim 16 caractere ce nu poate fi null; </li>
  <li> nume - câmp alfanumeric, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null; </li>
  <li> prenume-  câmp alfanumeric , variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null; </li>
  <li> role- câmp alfanumeric, variabil ca dimensiune dar având maxim 32 caractere ce nu poate fi null; </li> 
  <li> adresa- câmp alfanumeric, variabil ca dimensiune dar având maxim 50 caractere ce poate fi null; </li>
  <li> nationalitate- câmp alfanumeric, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null; </li> 
  <li> adresa_documente- câmp  alfanumeric, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null; </li>
</ul>

**Diploma_Bac:**
<ul>
  <li> UserCNP(cheia străină) - câmp  unic ce ține valori întregi de maxim 13 cifre ce nu poate fi null; </li>
  <li> proba_Ea - câmp numeric ce ține valori reale de maxim doua cifre ce nu poate fi null; </li>
  <li> proba_Eb - câmp numeric ce ține valori reale de maxim doua cifre ce  poate fi null; </li>
  <li> proba_Ec - câmp numeric ce ține valori reale de maxim doua cifre ce nu poate fi null; </li>
  <li> proba_Ed - câmp numeric ce ține valori reale de maxim doua cifre ce nu poate fi null; </li>
</ul>

**Medie:**
<ul>
  <li>UserCNP(cheia străină) - câmp ce ține valori întregi de maxim 13 cifre ce nu poate fi null;</li>
  <li>valoare - câmp numeric ce ține valori întregi de maxim doua cifre ce poate fi null;</li>
</ul>

**Săli:**
<ul>
  <li>id(cheia primară) - câmp alfanumeric unic, variabil ca dimensiune dar având maxim 5 caractere ce nu poate fi null;</li>
  <li>locatie - câmp alfanumeric unic, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;</li>
  <li>locuri - câmp ce ține valori întregi de maxim 3 cifre ce nu poate fi null;</li>
  <li>nr_prof - câmp ce ține valori întregi de maxim 2 cifre ce nu poate fi null;</li>
</ul>

**Examen:**
<ul>
  <li>id(cheia primară) - câmp unic, ce ține valori întregi de maxim 10 cifre ce nu poate fi null;</li>
  <li>nr_proba - câmp ce ține valori întregi de maxim 10 cifre ce nu poate fi null;</li>
  <li>start_date - câmp de tip timestamp ce reține formatul data ce nu poate fi null;</li>
  <li>end_date - câmp de tip timestamp ce reține formatul data ce nu poate fi null;</li>
  <li>tip- câmp alfanumeric unic, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;</li>
</ul>

**Orar:**
<ul>
  <li>sala_id(cheie străină) - câmp alfanumeric variabil ca dimensiune dar având maxim 5 caractere ce nu poate fi null;</li>
  <li>examen_id(cheie străină) - câmp numeric, ce ține valori întregi de maxim 10 cifre ce nu poate fi null;</li>
  <li>(sala_id, împreună cu examen_id formează cheia primară a tabelei Orar) </li>
</ul>

**Note:**
<ul>
  <li> UserCNP(cheie străină) - câmp ce ține valori întregi de maxim 13 cifre ce nu poate fi null; </li>
  <li> Examenid(cheie străină) - câmp ce ține valori întregi de maxim 10 cifre ce nu poate fi null; </li>
  <li> valoare - câmp numeric, ce ține valori întregi de maxim două cifre ce nu poate fi null; </li>
</ul>

**(UserCNP, împreună cu Examenid formează cheia primară a tabelei Note)**

**Pentru rezolvarea relațiilor many-to-many dintre tabela Users și tabela , am introdus tabela user_orar cu următoarea componență:
user_orar:**

<ul>
  <li>CNP(cheie străină) - câmp ce ține valori întregi de maxim 13 cifre ce nu poate fi null;</li>
  <li>sala_id(cheie străină) -câmp alfanumeric variabil ca dimensiune dar având maxim 5 caractere ce nu poate fi null;</li>
  <li>examen_id(cheie străină) - câmp ce ține valori întregi de maxim 10 cifre ce nu poate fi null;</li>
</ul>

**(CNP, împreună cu sala_id și examen_id formează cheia primară a tabelei user_orar)**
