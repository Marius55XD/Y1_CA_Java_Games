# Y1 CA Java Games

A collection of two text-based console games written in Java as part of a Year 1 Continuous Assessment.

---

## Games

### 1. Hangman City Game (`Marius_Stuopelis_Hangman.java`)

A twist on the classic Hangman game where you guess the name of a **city** instead of a word.

**How to play:**
1. Enter your name.
2. Choose a country (e.g. `Ireland`, `France`).
3. A random city from that country is selected from the data file.
4. Guess one letter at a time to reveal the city name.
5. Correctly guessed letters are shown in their positions (e.g. `D u _ _ _ _`).
6. You have **7 lives**. Each wrong letter costs 1 life.
7. Type `hint` at any time to reveal the city's population — but it costs **3 lives**.
8. Win by guessing all letters before running out of lives.

**Requirements:**
- `WorldCities2024v5.txt` — a data file with city names, countries, and populations. This file must be present in the working directory when the program is run. Each line contains: `CityName CountryName Population`

---

### 2. Gladiator's Last Stand (`Marius_Stuopelis_Gladiator_game.java`)

A turn-based combat game where you play as a **Gladiator** fighting a **Giant Goblin** in the Colosseum arena.

**How to play:**
1. Enter your gladiator's name.
2. Each round, choose an attack:
   - **1 — Light Attack:** deals 2–5% damage (reliable)
   - **2 — Medium Attack:** deals 1–25% damage (moderate risk)
   - **3 — Heavy Attack:** deals 0–50% damage (50% chance to miss entirely)
3. After your attack, the Giant Goblin counter-attacks with a randomly chosen attack of the same three types.
4. Both you and the goblin start with **100% health**.
5. The game ends when either side reaches 0% health.
6. After each game you can choose to **play again**.

**Win condition:** Reduce the Giant Goblin's health to 0%.  
**Lose condition:** Your own health reaches 0%.

---

## Running the Games

Both games run from the command line. Make sure you have the [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) installed.

```bash
# Compile
javac Marius_Stuopelis_Hangman.java
javac Marius_Stuopelis_Gladiator_game.java

# Run Hangman (WorldCities2024v5.txt must be in the same directory)
java Games.Marius_Stuopelis_Hangman

# Run Gladiator Game
java Games.Marius_Stuopelis_Gladiator_game
```

---

## Project Structure

```
Y1_CA_Java_Games/
├── Marius_Stuopelis_Hangman.java         # Hangman City Game source
├── Marius_Stuopelis_Gladiator_game.java  # Gladiator's Last Stand source
├── HangmanGame_TestSheet.xlsx            # Test cases for Hangman game
├── GladiatorGame_TestProjectv.xlsx       # Test cases for Gladiator game
└── README.md
```

---

## Author

**Marius Stuopelis** — Year 1 Java Games CA