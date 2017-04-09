# Fișa cerințelor

## Modulul Middleware

## Grupa B1, Anul II

### Cuprins
1.  Descriere
2.  Actori
3.  Funcționalități
4.  Scenarii de utilizare

### 1.   Descriere

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;În contextul implementării modelului MVC, în calitate de Controller trebuie să punem la dispoziție un API prin intermediul căruia se face legătura dintre componenta View și Model, și pentru a putea controla structura View-ului în funcție datele trimise și primite.

### 2.   Actori

-   View-ul: va apela funcțiile Controller-ului și va fi modificat de acesta în conformitate cu datele trimise
-   Model-ul: va valida datele primite și va trimite un răspuns de confirmare sau infirmare propagat către View, și va stoca aceste date dacă este necesar 

### 3.   Funcționalități

-   Introducerea unui utilizator nou în baza de date
-   Introducerea informațiilor de logare ale unui utilizator
-   Introducerea informațiilor de candidatură pentru admitere
-   Validarea candidaturii unui student
-   Alcătuirea unei repartiții pentru examen
-   Crearea unui clasament al studenților
-   Modificarea informațiilor relative la un student

### 4.   Scenarii de utilizare

**I. View-ul dorește introducerea unui nou utilizator în baza de date, așadar apelează funcția de validare a informațiilor pentru acesta**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**I.1** Datele sunt în format valid și sunt trimise către baza de date:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**I.1.1** Datele trimise sunt valide în baza de date, deci aceasta stocheaza datele și trimite un mesaj de succes, iar View-ul este modificat pentru a reflecta acest lucru.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**I.1.2** Datele trimise nu sunt valide în baza de date, deci aceasta trimite un mesaj de eroare, iar View-ul este modificat ca atare.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**I.2** Datele nu sunt în format valid, deci este trimis un mesaj de eroare, iar View-ul este modificat ca atare.

**II.   View-ul dorește introducerea informațiilor de autentificare ale unui utilizator, așadar apelează funcția de validare a acestora**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**II.1** Datele sunt trimise către baza de date și sunt valide, autentificarea este facută cu succes și se trimite un mesaj de succes, iar View-ul este modificat corespunzător.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**II.2** Datele sunt trimise către baza de date și nu sunt valide, autentificarea eșuează, și se trimite un mesaj de eroare pentru a modifica View-ul în acest sens.

**III.  View-ul dorește introducerea informațiilor de candidatură ale unui student și este apelată funcția necesară**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**III.1** Datele sunt în format valid și sunt trimise către baza de date:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**III.1.1** Datele trimise sunt valide în baza de date, deci aceasta stocheaza datele și trimite un mesaj de succes, iar View-ul este modificat pentru a reflecta acest lucru.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**III.1.2** Datele trimise nu sunt valide în baza de date, deci aceasta trimite un mesaj de eroare, iar View-ul este modificat ca atare.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**III.2** Datele nu sunt în format valid, deci este trimis un mesaj de eroare pentru a face modificarea corespunzătoare în View.

**IV.   View-ul dorește crearea unei repartizări pentru un examen și apelează funcția corespunzătoare**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Datele necesare sunt preluate din baza de date, se alcătuiește repartizarea dorită și se modifică View-ul pentru a o afișa.

**V.    View-ul dorește crearea unui clasament cu studenții ce au susținut examenul**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Datele necesare sunt preluate din baza de date, se alcătuiește clasamentul dorit și se modifică View-ul pentru a o afișa.

**VI.   View-ul dorește modificarea informațiilor relative la un student**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**VI.1** Datele sunt în format valid și sunt trimise către baza de date:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**VI.1.1** Datele trimise sunt valide în baza de date, deci aceasta stocheaza datele și trimite un mesaj de succes propagat, iar View-ul este modificat în acest sens.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**VI.1.2** Datele trimise nu sunt valide în baza de date, deci aceasta trimite un mesaj de eroare și se modifică View-ul ca atare.
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**VI.2** Datele nu sunt în format valid, deci este trimis un mesaj de eroare pentru a face modificarea corespunzătoare în View.
