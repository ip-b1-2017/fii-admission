# **Fisa cerintelor**

## Modulul FrontEnd

###### Grupa:B1  Anul:2

## Cuprins:
1. Descriere
2. Module
3. Actori
4. Scenarii de utilizare

## 1. Descriere
Aceasta aplicatie doreste sa faca din admiterea la Facultatea de Informatica o experienta atat pentru noii studenti cat si pentru administratori. 

Un student va interactiona cu o interfata prietenoasa si isi va putea depune candidatura pentru admitere fara a mai fi nevoit sa se deplaseze pana la facultate, in cativa pasi simpli si intuitivi. Pentru a-si putea completa dosarul pentru admitere fiecare student va trebui sa isi creeze un cont si sa se autentifice cu el la intrarea in aplicatie. La incheierea sesiunii de admitere aplicatia va pune la dispozitie studentilor listele cu persoanele admise.

Aplicatia pune la dispozitie si administratorilor o interfata intuitiva si usor de folosit in managmentul sesiunilor de admitere. Acestia vor putea sa modifice cu usurinta structura formularului de inscriere, sa verifice candidaturi si sa le valideze prin doar cativa pasi simpli. De asemenea prin introducerea catorva date precum numarul salilor disponibile si numarul candidatilor la admitere administratorii pot genera cu usurinta repartizarea candidatilor in sali.

## 2. Module
### 2.1 Partea de utilizator normal
#### 2.1.1 Sign up
Fiecare student care vrea sa aplice pentru admitere va trebui sa isi creeze un cont cu cateva detalii despre el.
#### 2.1.2 Log in
La intrarea in aplicatie studentul trebuie sa se autentifice pentru a putea beneficia de serviciile puse la dispozitie de aplicatie.
#### 2.1.3 Settings
Aceasta optiune ii va permite utilizatorului sa isi modifice datele de cont.
#### 2.1.4 Dashboard
Acesta este modulul care il va ajuta pe student sa urmeze pasii necesari inscrierii la admitere si sa vizualizeze informatii cu privire la evolutia aplicatiei sale, la cateva zile mai sunt pana la examen, pana la afisarea rezultatelor, respectiv alte statistici.De asemenea va contine o sectiune cu anunturi de unde va putea afla noi informatii transmise de catre administratori.
#### 2.1.5 Application Form 
Este formularul care va contine toate datele necesare inscrierii la admitere, iar studentul il va putea modifica daca un administrator semnaleaza nereguli.
#### 2.1.6 Diconnect
Deconecteaza utilizatorul.
### 2.2 Partea de administrator
#### 2.2.1 Log in
La intrarea in aplicatie administartoru se va autentifica cu un cont special.
#### 2.2.1 Dashboard 
Acest modul va ajuta la managmentul verificarilor aplicatiilor studentilor. Va contine o lista cu noile aplicatii depuse de studenti pe care le va putea verifica si va semnala erori in caz ca este nevoie. Aplicatiile verificate si aprobate vor fi mutate in alta lista. Administratorul va putea accesa din acest modul si alte informatii cu privire la statistici precum numarul studentilor inscrisi, numarul aplicatiilor depuse sau validate.
#### 2.2.2 Add news
Aceasta optiune ii va permite administratorului sa adauge anunturi cu informatii noi care vor aparea in Dashboard-ul studentului.
#### 2.2.3 Diconnect
Deconecteaza utilizatorul.

## 3. Actori

Actorii din aplicatie sunt :

1. Aplicantul este cel care isi va crea un cont in aplicatie pentru a se inscrie la studii de licente, de masterat sau de doctorat.
2. Administratorul poate fi fie un profesor, fie o seretara, iar el se ocupa cu gestionarea bazei de date, verificarea aplicatiilor studentilor, repartizarea candidatilor pe sali, publicarea anunturilor, etc.
3. Baza de date va retine datele introduse de catre aplicanti in aplicatie.
4. Mail Server este cel care proceseaza cererile aplicatilor si realizeaza verificarea adresei de e-mail la inscriere.


## 4. Scenarii de utilizare

Atunci cand un utilizator acceseaza pagina in browser vor putea fi vizualizate cateva informatii despre facultate si vor fi disponibile doua butoane pentru Sign up, respectiv Log in.

Daca utilizatorul apasa pe butonul Log in va fi directionat pe o pagina cu un formular unde va trebui sa introduca un nume de cont si o parola. Dupa completarea campurilor va apasa butonul Log in. 

Daca utilizatorul nu are cont, dar a apasat pe butonul de Log in, va apasa pe optiunea de Sign up.

Daca utilizatorul introduce un nume de utilizator si/sau parola gresite va primi un mesaj de atentionare, altfel va fi directionat spre pagina principala a aplicatiei.

Daca utilizatorul alege optiunea de Sign in se va incarca un formular unde acesta va trebui sa introduca datele necesare crearii unui cont. Dupa introducerea datelor va apasa butonul de Submit. Daca datele respecta cerintele specificate va fi afisat un mesaj de succes si instructiuni pentru validarea contului, altfel se vor semnala campurile care nu respecta regulile si dupa modificare utlizatorul poate apasa din nou Submit. 

Daca operatiunea de creare a contului a fost cu succes noul utilizator va trebui sa intre pe email unde va primi un link ce trebuie accesat pentru validarea contului. La accesarea linkului se va afisa o pagina cu un mesaj de succes precum si un formular pentru Log in.

Dupa logarea cu succes utilizatorul va avea la dispozitie un meniu pentru a naviga prin aplicatie. Daca utilizatorul este un student optiunile vor fi: Dashboard, Settings, Application Form si Diconnect. Daca utilizatorul este un administrator va avea la dispozitie urmatoarele optiuni: Dashboard,Add News si Diconnect.

Pe parcursul completarii formularului, utilizatorul va avea in josul paginii pasii pana la terminarea procesului. Odata cu teminarea unui pas, se va incrementa lista de pasi efectuati. Aceasta lista de pasi din josul paginii coordoneaza utilizatorul corect prin toti pasii. Daca utilizatorul nu a realizat corect un pas, i se va specifica acest lucru si nu va putea sa treaca la urmatorul.

Utilizatorul poate schimba limba dorită, din romana in engleza sau invers in functie de preferinta fiecaruia.

Atunci cand administratorul va verifica aplicatiile, daca o aplicatie contine erori atunci administratorul va semnala acea aplicatie iar studentului ii va aparea la status cum ca aplicatia lui trebuie modificata. Daca aplicatia nu contine nici o eroare, atunci studentui ii va aparea in Dashboard, la status cum ca aplicatia lui a fost verificata si este corecta.


