package com.revature;

public interface Game {
<<<<<<< HEAD
    
	int getNumber();
=======
	
    int getNumber();
>>>>>>> main

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

<<<<<<< HEAD
    void reset(); // reset the number by calling next()
=======
    void reset(); // reset the number by calling next() on the Random obj
>>>>>>> main

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();


}
