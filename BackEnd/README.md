# **Fisa cerintelor**
## Modulul BackEnd
###### Grupa:B1  Anul:2
## Cuprins:
1. Descriere
2. Entitati
3. Descrierea entitatilor
4. Scenarii de utilizare

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
<li> **(sala_id, împreună cu examen_id formează cheia primară a tabelei Orar)** </li>
</ul>

**Note:**
<ul>
• UserCNP(cheie străină) - câmp ce ține valori întregi de maxim 13 cifre ce nu poate fi null;
• Examenid(cheie străină) - câmp ce ține valori întregi de maxim 10 cifre ce nu poate fi null;
• valoare - câmp numeric, ce ține valori întregi de maxim două cifre ce nu poate fi null;
</ul>

**(UserCNP, împreună cu Examenid formează cheia primară a tabelei Note)**

**Pentru rezolvarea relațiilor many-to-many dintre tabela Users și tabela Orar, am introdus tabela user_orar cu următoarea componență:
user_orar:**
<ul>
<li>CNP(cheie străină) - câmp ce ține valori întregi de maxim 13 cifre ce nu poate fi null;</li>
<li>sala_id(cheie străină) -câmp alfanumeric variabil ca dimensiune dar având maxim 5 caractere ce nu poate fi null;</li>
<li>examen_id(cheie străină) - câmp ce ține valori întregi de maxim 10 cifre ce nu poate fi null;</li>
</ul>

**(CNP, împreună cu sala_id și examen_id formează cheia primară a tabelei user_orar)**
