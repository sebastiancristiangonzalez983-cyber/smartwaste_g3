# ♻️ SmartWaste – Gestione Intelligente dei Cassonetti

SmartWaste è un progetto sviluppato per simulare la gestione intelligente dei cassonetti dei rifiuti.  
Il sistema permette di creare diversi tipi di cassonetti, aggiornarne il livello di riempimento, registrare le date di installazione e svuotamento, e filtrare quelli che superano una certa percentuale.

---

## 🚀 Funzionalità principali

- Creazione di cassonetti di diversi tipi:
    - Organico
    - Vetro
    - Carta
    - Plastica
    - Indifferenziata
- Calcolo della percentuale di riempimento
- Aggiornamento dei valori (peso, volume, bottiglie…)
- Registrazione automatica delle date di installazione e svuotamento
- Gestione di un elenco di cassonetti
- Filtraggio dei cassonetti con riempimento superiore al 90%

---

## 🛠️ Tecnologie utilizzate

- **Java 15**
- **JavaFX**
- **Maven**
- **IntelliJ IDEA**
- Programmazione orientata agli oggetti (OOP)

---

## 📂 Struttura del progetto

src/main/java/org/divini/smartwaste_g3

│

├── controller/        # Controller JavaFX

├── database/          # (eventuale) gestione dati

├── model/             # Classi del dominio (Cassonetto, Organico, Vetro…)

├── service/           # Servizi dell’applicazione

│

├── HelloApplication   # Avvio JavaFX

├── Launcher           # Compatibilità IDE

└── MainTest           # Test manuale dei cassonetti


---

## ▶️ Come eseguire il progetto

1. Clonare il repository:
   git clone https://github.com/TU-REPO/smartwaste_g3.git
2. Aprire il progetto con IntelliJ IDEA
3. Assicurarsi che il progetto utilizzi **Java 15 o superiore**
4. Eseguire:
- `MainTest` per testare la logica
- `HelloApplication` per avviare l’interfaccia JavaFX

---

## 👤 Autore

**Sebastián Cristian Gonzales Cule**  
SmartWaste – Progetto accademico

---

## 📄 Licenza

Questo progetto è distribuito per scopi didattici.