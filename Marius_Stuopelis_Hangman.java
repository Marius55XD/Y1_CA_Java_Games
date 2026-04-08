package Games;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/*
the hangman game 
It’s a single player game which you have to choose a country and guess the city name , you have 7 lives/guesses to the city. 
each time you guess the city letter right it will display the letter where it belongs but it will remain hidden the other letters for example Dublin 
you guess "u" it will display _u_ _ _ _ . you can use a hint but it will take away 3 lifes the hint will then display the population of the city. win the game by guessing the city 
or lose if you run out of lives
 */
public class Marius_Stuopelis_Hangman {

    public static void main(String[] args) throws IOException {

        //scanner keyboard for the player 
        Scanner keyboard = new Scanner(System.in);
        //randomiser
        Random rand = new Random();

        //Variables
        int lives = 7;
        String playerName;
        String guessCity;
        int randNumber;
        String cityChosen = "";
        int populationChosen=0;
        int countValues = 0;
        int count = 0;
       

        // link File object with a file on disk
        File inputFile = new File("WorldCities2024v5.txt");

        //link Scanner object with the File
        Scanner input = new Scanner(inputFile);

        //Go through file to count the number of values so can set the size of the array
        while (input.hasNext()) {
            String line = input.nextLine();
            countValues++;
        }
        
        //Array size is equal to number of lines in the file
        int lenghtArray = countValues;

        //Setup array with 0's. then Go through file again and put values into array 
        int[] population = new int[lenghtArray];
        String[] cities = new String[lenghtArray];
        String[] countries = new String[lenghtArray];

        Scanner input2 = new Scanner(inputFile); //scan the content of the file again 

       //while loop fpr input2
        while (input2.hasNext()) {
            cities[count] = input2.next(); //read the city name
            countries[count] = input2.next(); // read the country name
            population[count] = input2.nextInt(); // read the population
            count++; //counter
        }
        
        //printing out the game title
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|                Welcome to the Hangman City Game!                 |");
        System.out.println("|__________________________________________________________________|");
       
        //Instructions of the game 
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|  Instrucitons:                                                   |");
        System.out.println("|  1. choose a letter to Guess  from the keyboard                  |");
        System.out.println("|  2. you can only enter one letter!                               |");
        System.out.println("|  3. entering a symbol for example will deduct 1 life             |");
        System.out.println("|  4. you have 7 lifes which you can guess 7 times                 |");
        System.out.println("|  5. if you guess the city write you win the game                 |");
        System.out.println("|  6. if you run out of lifes its game over                        |");
        System.out.println("|                                                                  |");
        System.out.println("|  NOTE!                                                           |");
        System.out.println("|  using a hint will give a population of a city                   |");
        System.out.println("|  but it will deduct 3 lifes                                      |");
        System.out.println("|__________________________________________________________________|");
        
        
        //asking the player for there name and print out on  a new line
        System.out.print("\nWhat is your name?: ");
        playerName = keyboard.nextLine();
        
        //welcoming the player to the game
        System.out.println("Welcome! " + playerName + " to the Hangman City Game!");
        
        
        //asking the player to choose a country
        System.out.print("Choose a country: ");
        String countryChosen = keyboard.nextLine();
        //making the first letter upper case and the second letter to lower case 
        countryChosen = countryChosen.substring(0, 1).toUpperCase() + countryChosen.substring(1).toLowerCase();
        
        

        //its telling that the county isnt found
        boolean foundCountry = false;

        // while the country is not found it goes through a loop until its found
        while (foundCountry == false) {
            randNumber = rand.nextInt(0, lenghtArray); //generates a random index
            if (countries[randNumber].equals(countryChosen)) { //checks if tthe country  matches
                cityChosen = cities[randNumber]; // chooses the corosponding city
                populationChosen = population[randNumber]; //chooses the corosponding population
                foundCountry = true;   //tells that the country is found
            }
        }
        
        
        
        //creating a character array displayProg for the city chosen
        char[] displayProg = new char[cityChosen.length()];
        //loops through every  letter in the displayProg
        for (int i = 0; i < displayProg.length; i++)
        {
            
            displayProg[i] = '_'; //for every letter in the city it displays the underscores
        }
        
        //Game loop
        while (lives > 0) {
            //print out on new line City name: _ _  _
            System.out.print("\nCity name: ");
            //goes through a loop checking each letter
            for(char dis :displayProg)
            {
               //prinitng out the city e.g _ _ _ _ player guess C     C_ _ _
                System.out.print(dis+" ");
            }
            
            //printing out the current lives
            System.out.println("\nLives:" + lives);

            System.out.print("Guess a letter or use a 'hint' for the population of the city: ");
            guessCity = keyboard.nextLine();
            //making the first letter upper case and the second letter to lower case 
            guessCity = guessCity.substring(0, 1).toUpperCase() + guessCity.substring(1).toLowerCase();
         
            //this is when the player types in hint to show the population of the city
            if(guessCity.equals("Hint"))
            {
                System.out.println("The population of the city is: " + populationChosen);
                //calculation of taking away the 3 lifes
                lives = lives-3;
                continue; //continuing to the game
            }
            
            //making sure the player enters only one letter 
            if(guessCity.length() !=1)
            {
                //prints out saying enter one letter please
                System.out.println("Enter one letter please!");
                continue; //Continues the game
            }
            
            //checks if the guessed letter is in the city name
            char guessedLetter = guessCity.charAt(0);
            boolean correctGuess = false;
            
            //loops through each character
            for (int i = 0; i < cityChosen.length(); i++)
            {
                //checks of the current letter in the city matches to the guessed letter
                if(Character.toLowerCase(cityChosen.charAt(i))== Character.toLowerCase(guessedLetter))
                {
                    //reveals the letter if it matches
                    displayProg[i] = cityChosen.charAt(i);
                    //making it to true if it matches
                    correctGuess=true;
                }
            }
            
            //if the its not correctGuess prints out the: You guessed the wrong letter
            if(correctGuess==false)
            {
                System.out.println("You guessed the wrong letter");
                lives = lives - 1; //takes away 1 life if the player guesses wrong
            }
            else
            {
                //prints out that the letter is guess correctly 
                System.out.println("You have guessed the correct letter");
            }
            //checks if the player has guessed the city
             if(new String(displayProg).equals(cityChosen))
            {
                //prints out saying congratulations with the players name and the city name
                System.out.println("\nCongratulations! " + playerName + ", you have guessed the city " + cityChosen);
                //print saying thank you for playing
                System.out.println("Thank you for playing Hangman City Game");
                break; // ends the game
            } 
        }
         
            //if the player runs out of lives, it will say game over and revealing the city name and saying thank you for playing
            if(lives == 0)
            {
                //prints outs
                System.out.println("Game over! The city was " + cityChosen);
                System.out.println("Thank you for playing Hangman City Game");
            }
    }
}
/*kevin, the game works but the only issue is when player types in the wrong country it  doesnt display:)*/

