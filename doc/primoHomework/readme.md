# Documentazione Progetto  
## 📑 Indice della Documentazione

* [1. Traccia](Traccia2.pdf)
* [2. Analisi Delle Classi](#analisi-delle-classi)
  * [2.1 Domande/Ambiguità](#domande-ambiguita)
* [3. Breakdown Delle Classi](#breakdown-delle-classi)
  * [3.1 Gerarchia Utenti](#gerarchia-utenti)
  * [3.2 Gestione Tirocini e Tesi](#34-gestione-tirocini-e-tesi)
  * [3.3 Gestione Laurea](#35-gestione-laurea)
* [4. Progettazione UML](#progettazione-uml)
* [5. Triple T Tribute](#triple-t-tribute)

### 3.1 Gerarchia Utenti
* [3.1.1 Utente (Superclasse)](#-utente-superclasse)
* [3.1.2 Studente](#-studente-specializzazione-di-utente)
* [3.1.3 Docente](#--docente-specializzazione-di-utente)

### 3.2 Gestione Tirocini e Tesi
* [3.2.1 Tirocinio](#-tirocinio-unifica-argomento-e-tirocinio)
* [3.2.2 Tirocinio Esterno](#-tirocinio-esterno-specializzazione-di-tirocinio)
* [3.2.3 Richiesta Tirocinio](#-richiesta-tirocinio)
* [3.2.4 Tesi](#-tesi)

### 3.3 Gestione Laurea
* [3.3.1 Seduta di Laurea](#-seduta-di-laurea)
* [3.3.2 Prenotazione Seduta](#-prenotazione-seduta)

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

##### 3.1.1 Attributi (Utente)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `nome` | String |  | Nome dell'utente |
| `cognome` | String |  | Cognome dell'utente |
| `dataDiNascita` | LocalDate |  | Data di nascita dell'utente |
| `email` | String |  | Email dell'utente |
| `login` | String |  | Nominativo per l'accesso al sistema |
| `password` | String |  | Password per l'autenticazione |

##### 3.1.2 Metodi (Utente)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `effettuaLogin(password)` | String password | boolean | Verifica se la password inserita è corretta |
| `modificaPassword(nuovaPassword)` | String nuovaPassword | void | Modifica la password dell'utente |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |


#### 🎓 Studente (Specializzazione di Utente)

##### 3.2.1 Attributi (Studente)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `matricola` | String | true | Identificativo univoco dello studente |
| `corsoDiLaurea` | String | false | Denominazione del corso di laurea |
| `cfuMaturati` | Integer | false | Crediti formativi universitari acquisiti |
| `cfuDaMaturare` | Integer | false | Crediti formativi universitari rimanenti |
| `annoImmatricolazione` | Year | false | Anno di iscrizione al corso |

##### 3.2.2 Metodi (Studente)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `richiediTirocinio(tirocinio)` | Tirocinio t | RichiestaTirocinio | Crea una nuova richiesta di tirocinio |
| `caricaTesi(tesi)` | Tesi t | void | Carica una tesi nel sistema |
| `prenotaSedutaLaurea(seduta)` | SedutaLaurea s | PrenotazioneSeduta | Crea una prenotazione per una seduta di laurea |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |

#### 👨‍🏫 Docente (Specializzazione di Utente)
Include anche il ruolo di Relatore per i tirocini seguiti.

##### 3.3.1 Attributi (Docente)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `idDocente` | String | true | Identificativo univoco del docente |
| `isCoordinatore` | Boolean | false | Indica se il docente è coordinatore di corso |

##### 3.3.2 Metodi (Docente)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `pubblicaArgomentoTirocinio(tirocinio)` | Tirocinio t | void | Pubblica un nuovo argomento di tirocinio |
| `valutaRichiestaTirocinio(richiesta, esito)` | RichiestaTirocinio r, boolean esito | void | Valuta l'approvazione/rifiuto di una richiesta |
| `valutaTesi(tesi, approvata)` | Tesi t, boolean approvata | void | Valuta l'approvazione di una tesi |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |

---

### 3.4 Gestione Tirocini e Tesi

#### 💼 Tirocinio (Unifica "Argomento" e "Tirocinio")

##### 3.4.1.1 Attributi (Tirocinio)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `idTirocinio` | String | true | Identificativo univoco del tirocinio |
| `argomento` | String | false | Tema/argomento del tirocinio |
| `totaleOre` | Integer | false | Numero totale di ore previste |
| `docenteProponente` | Docente | false | Docente che propone il tirocinio |

##### 3.4.1.2 Metodi (Tirocinio)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `getDettagliTirocinio()` | - | String | Restituisce i dettagli formattati del tirocinio |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |

#### 🏢 Tirocinio Esterno (Specializzazione di Tirocinio)

##### 3.4.2.1 Attributi (Tirocinio Esterno)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `aziendaSeguita` | String | false | Nome dell'azienda ospitante |
| `referenteAziendale` | String | false | Nominativo della persona di riferimento in azienda |

##### 3.4.2.2 Metodi (Tirocinio Esterno)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi specifici |

#### 📝 Richiesta Tirocinio
Classe che gestisce la candidatura di uno studente per un determinato tirocinio.

##### 3.4.3.1 Attributi (Richiesta Tirocinio)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `idRichiesta` | String | true | Identificativo univoco della richiesta (formato: REQ-timestamp) |
| `studenteRichiedente` | Studente | false | Riferimento allo studente che presenta la richiesta |
| `tirocinioRichiesto` | Tirocinio | false | Riferimento al tirocinio richiesto |
| `dataInizio` | LocalDate | false | Data in cui è stata creata la richiesta |
| `statoRichiesta` | String | false | Stato della richiesta: "In Attesa", "Approvata", "Respinta" |

##### 3.4.3.2 Metodi (Richiesta Tirocinio)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `aggiornaStato(nuovoStato)` | String nuovoStato | void | Aggiorna lo stato della richiesta se il valore è valido |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |

#### 📚 Tesi
Rappresenta il lavoro finale caricato dallo studente.

##### 3.4.4.1 Attributi (Tesi)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `idTesi` | String | true | Identificativo univoco della tesi |
| `titolo` | String | false | Titolo della tesi |
| `percorsoFile` | String | false | Percorso o URL al file della tesi (PDF/documento) |
| `autore` | Studente | false | Riferimento allo studente autore |
| `relatore` | Docente | false | Riferimento al docente relatore |
| `statoApprovazione` | String | false | Stato: "Bozza", "Revisione", "Approvata" |

##### 3.4.4.2 Metodi (Tesi)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `richiediRevisione()` | - | void | Cambia lo stato da "Bozza" a "Revisione" |
| `approvaTesi()` | - | void | Approva la tesi impostando lo stato a "Approvata" |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |

---

### 3.5 Gestione Laurea

#### 🎓 Seduta di Laurea
Rappresenta l'evento in cui avvengono le discussioni delle tesi.

##### 3.5.1.1 Attributi (Seduta di Laurea)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `idSeduta` | String | true | Identificativo univoco della seduta |
| `dataSeduta` | LocalDate | false | Data della seduta di laurea |
| `orarioInizio` | LocalTime | false | Orario di inizio della seduta |
| `aula` | String | false | Denominazione dell'aula in cui si svolge |
| `postiDisponibili` | Integer | false | Numero di posti disponibili nella seduta |

##### 3.5.1.2 Metodi (Seduta di Laurea)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `verificaDisponibilita()` | - | boolean | Verifica se ci sono posti disponibili |
| `decrementaPosti()` | - | void | Decrementa il numero di posti disponibili |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |

#### 📅 Prenotazione Seduta
Gestisce l'inserimento dello studente all'interno di una seduta disponibile.

##### 3.5.2.1 Attributi (Prenotazione Seduta)

| Attributo | Tipo | Chiave Primaria | Descrizione |
|-----------|------|----------|-------------|
| `idPrenotazione` | String | true | Identificativo univoco della prenotazione (formato: PREN-timestamp) |
| `studente` | Studente | false | Riferimento allo studente che prenota |
| `seduta` | SedutaLaurea | false | Riferimento alla seduta di laurea |
| `dataPrenotazione` | LocalDate | false | Data in cui è stata effettuata la prenotazione |

##### 3.5.2.2 Metodi (Prenotazione Seduta)

| Metodo | Parametri | Ritorno | Descrizione |
|--------|-----------|---------|-------------|
| `confermaPrenotazione()` | - | boolean | Conferma la prenotazione e decrementa i posti se disponibili |
| Getter e Setter | - | - | Metodi per accedere e modificare gli attributi |


# PROGETTAZIONE UML

> **⚠️ IMPORTANTE**: questa sezione è un template ed è da completare.

La documentazione della progettazione dello schema UML è disponibile nel file di progetto:

![DIAGRAM.svg](imgs/DIAGRAM.svg)

## Note sulla progettazione UML

- **Modello di dominio puro**: Il diagramma deve contenere solo le entità di dominio (nessuna classe architetturale/controller)
- **Classi da includere**:
  - Utente (classe astratta)
  - Studente
  - Docente
  - Tirocinio
  - TirocinioEsterno
  - RichiestaTirocinio
  - Tesi
  - SedutaLaurea
  - PrenotazioneSeduta
- **Relazioni principali**: Le entità sono collegate attraverso associazioni rappresentate nel modello