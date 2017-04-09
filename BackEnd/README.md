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

## Baza de date pentru admiterea la studii de licență va conține următoarele entități:
## *Users:*
* CNP(cheia primară) - câmp unic ce ține valori întregi de maxim 13 cifre ce nu poate fi null;
* mail- câmp alfanumeric unic, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;
* telefon- câmp alfanumeric unic, variabil ca dimensiune dar având maxim 16 caractere ce nu poate fi null;
* nume - câmp alfanumeric, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;
* prenume- câmp alfanumeric , variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;
* role- câmp alfanumeric, variabil ca dimensiune dar având maxim 32 caractere ce nu poate fi null;
* adresa- câmp alfanumeric, variabil ca dimensiune dar având maxim 50 caractere ce poate fi null;
* nationalitate- câmp alfanumeric, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;
* adresa_documente- câmp alfanumeric, variabil ca dimensiune dar având maxim 255 caractere ce nu poate fi null;

