# Documentazione Progetto  
## 📑 Indice della Documentazione

* [1. Traccia](Traccia2.pdf)
* [2. Analisi Delle Classi](#analisi-delle-classi)
  * [2.1 Domande/Ambiguità](#domande-ambiguita)
* [3. Breakdown Delle Classi](#breakdown-delle-classi)
  * [3.1 Utente (Superclasse)](#-utente-superclasse)
  * [3.2 Studente](#-studente-specializzazione-di-utente)
  * [3.3 Docente](#--docente-specializzazione-di-utente)
  * [3.4 Gestione Tirocini e Tesi](#34-gestione-tirocini-e-tesi)
    * [3.4.1 Tirocinio](#-tirocinio-unifica-argomento-e-tirocinio)
    * [3.4.2 Tirocinio Esterno](#-tirocinio-esterno-specializzazione-di-tirocinio)
    * [3.4.3 Richiesta Tirocinio](#-richiesta-tirocinio)
    * [3.4.4 Tesi](#-tesi)
  * [3.5 Gestione Laurea](#35-gestione-laurea)
    * [3.5.1 Seduta di Laurea](#-seduta-di-laurea)
    * [3.5.2 Prenotazione Seduta](#-prenotazione-seduta)
* [4. Progettazione UML](#progettazione-uml)
* [5. Triple T Tribute](#triple-t-tribute)

---

# Analisi Delle Classi
I principali utilizzatori sono:
Studenti, Docenti.   

ogni studente deve avere:
Un Nome.
Un Cognome.
Una E-Mail.
Una Matricola [che ci servirà come identificativo].
Login.
Password.

in oltre lo studente può vedere l'elenco dei docenti con annessi argomenti disponibili. 
può effettuare una richiesta di tirocinio 
controllare se la proria richiesta è accettata o respinta.
può effettuarne una nuova nel caso fosse stata respinta.
caricare/richiesta della tesi nel caso fosse stata approvata.
e in caso di rifiuto può chiederne la revisione.


ogni Docente in maniera praticamente analoga deve avere:
Un Nome.
Un Cognome.
Una E-Mail.
ID_Doc [che ci servirà come identificativo].
Login.
Password.
Tirocinio (possibile tabella esterna dotata di argomenti di tirocinio che può possedere: [I tirocini possono essere interni o esterni. I tirocini esterni sono in collaborazione con aziende e per essi viene indicato anche il nominativo di referenza aziend.])

Ritroviamo che il docente può avere la possibilità  di essere coordinatore, risolvibile con un attributo es. is_coo di tipologia booleana(1 per vero 0 per falso).

## Domande/Ambiguita

| Quesito | Stato |
|---------|-------|
| tutti i docenti sono relattori? | [Risolto](#1-tutti-i-docenti-sono-relattori) |
| Il docente ha una matricola/anno immatricolazione  | [Risolto](#2-il-docente-ha-una-matricola) |
| Cosa si intende con "login"? | [Risolto](#3-cosa-si-intende-con-login) |


### 1. Tutti i docenti sono relattori?

Sì non esiste alcuna differenza tra un relattori e docenti sono una cosa unica. 

### 2. Il docente ha una matricola?

il docente ha un suo identificativo univoco non collegato alla matricola del comune studente, di conseguenza non può avere un'anno di immatricolazione. 

### 3. cosa si intende con login

Possiamo definire il login non come il termine reale (l'azione di inserire mail e password o id su un sito per accedere) ma bensì si come un'attributo singolo e atomico (ovvero non composto; perchè lo intendiamo come nominativo per l'accesso). 

# BREAKDOWN DELLE CLASSI

#### 👤 Utente (Superclasse)
La classe principale da cui derivano le due specializzazioni **Studente** e **Docente**.

| Attributo | Tipo | Chiave Primaria |
|-----------|------|----------|
| `Nome` | String |  |
| `Cognome` | String |  |
| `Data di nascita` | Date |  |
| `Email` | String |  |
| `Login` | String |  |
| `Password` | String |  |

#### 🎓 Studente (Specializzazione di Utente)

| Attributo | Tipo | Chiave Primaria |
|-----------|------|----------|
| `Matricola` | String | true |
| `Corso di laurea` | String | false |
| `CFU maturati` | Integer | false |
| `CFU da maturare` | Integer | false |
| `Anno di immatricolazione` | Year | false |

#### 👨‍🏫 Docente (Specializzazione di Utente)
Include anche il ruolo di Relatore per i tirocini seguiti.

| Attributo | Tipo | Chiave Primaria |
|-----------|------|----------|
| `ID_Doc` | String | true |
| `Corsi di insegnamento` | List | false |
| `Argomenti di tirocinio` | List | false |
| `is_coordinatore` | Boolean | false |

---

### 3.4 Gestione Tirocini e Tesi

#### 💼 Tirocinio (Unifica "Argomento" e "Tirocinio")

| Attributo | Tipo | Chiave Primaria |
|-----------|------|----------|
| `ID tirocinio` | String | true|
| `Argomento tirocinio` | String |  |
| `Data di inizio` | Date |  |
| `Totale ore` | Integer |  |
| `Stato Richiesta` | String |  |

#### 🏢 Tirocinio Esterno (Specializzazione di Tirocinio)

| Attributo | Tipo | Chiave Primaria |
|-----------|------|----------|
| `Referente aziendale` | String |  |
| `Azienda seguita` | String |  |

#### 📝 Richiesta Tirocinio
Classe che gestisce la candidatura di uno studente per un determinato tirocinio.
*(DA DEF)*

#### 📚 Tesi
Rappresenta il lavoro finale caricato dallo studente.
*(DA DEF)*

---

### 3.5 Gestione Laurea

#### 🎓 Seduta di Laurea
Rappresenta l'evento in cui avvengono le discussioni delle tesi.
*(DA DEF)*

#### 📅 Prenotazione Seduta
Gestisce l'inserimento dello studente all'interno di una seduta disponibile.
*(DA DEF)*


# PROGETTAZIONE UML
 link alla documentazione della progettazione dello schema UML
![DRAWIO DA FINIRE](imgs/DIAGRAM.svg)