
package Games;
import java.util.Random;
import java.util.Scanner;

/*
It’s a single player game which you are the gladiator and must fight a giant goblin(computer) in the arena and to defeat 
it so you can get your freedom back. In the game you will have a weapon which is a sword that you will have to fight with,
the player has 3 options which are light attack, medium attack and a heavy attack to attack the giant goblin.
 */

public class Marius_Stuopelis_Gladiator_game {
    public static void main(String[] args) {
        
          //scanner keyboard for the player 
        Scanner keyboard = new Scanner(System.in);
        //randomiser
        Random rand = new Random();
        boolean playagain=true;
          String playAgainChoice;
//main game loop it will continue until the player chooses not to replay
while(playagain)
{
        //Declaring Variables
        String playerName;
        int playerDamage = 0;
        int goblinsDamage = 0;
        int goblinsAttack ;
        int attackChoice;
        int playersHealth = 100;
        int goblinsHealth = 100;
        int zeroChance;
        int round=1;

        //Game title displaying
        System.out.println(" __________________________________________________________________");
        System.out.println("| Gladiators Last Stand                                            |");
        //Welcoming the player to the game and telling the goal of the game
        System.out.println("| Welcome to the Colosseum arena, Brave Gladiator!                 |");
        System.out.println("| Goal:                                                            |");
        System.out.println("| Your goal is to defeat the Giant Goblin to get your freedom back |");
        System.out.println("| GoodLuck!                                                        |");

        //Instructions on the game Displaying the options & chances of the attacks and letting the player know when it will end and that the player and computer has each turn to attack
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|  Instrucitons:                                                   |");
        System.out.println("|  1.Use your attack Options 1/2/3 but choose wisely!              |");
        System.out.println("|  Attacks & Chances of Damage                                     |");
        System.out.println("|  Option 1: Light attack: deals 2-5% damage                       |");
        System.out.println("|  Option 2: Medium attack: deals 1-25% damage                     |");
        System.out.println("|  Option 3: Heavy attack: deals 0-50% damage                      |");
        System.out.println("|                                                                  |");
        System.out.println("|  NOTE!                                                           |");
        System.out.println("|  Theres a chance of you missing your attack with a heavy attack  |");
        System.out.println("|                                                                  |");
        System.out.println("|  2. Each turn, you and the goblin will attack eachother          |");
        System.out.println("|  3. The game will only end when one of you reaches 0% health     |");
        System.out.println("|__________________________________________________________________|");
        

       
        //Player must enter there name
        System.out.print("\nWhat is your Name Brave Gladiotor? ");
        playerName = keyboard.nextLine();
        
        //Greeting the player
        System.out.println("Hello! " + playerName + " prepare yourself for a battle!");

        //Printing out saying The game has started
        System.out.println("!!The Battle Begins!!");
        
        
      
        //gamee loop : using while if the player health is more than 0
        while(playersHealth > 0 && goblinsHealth > 0 )
        {
            //displaying the rounds
            System.out.println("\n---------------- Round " +round+" ----------------");
            round++;
            //Displaying Health & name, weapon of the gladiotor's and goblins
            //players section displaying Name, weapon and health
            System.out.println(" _________________________________________");
            System.out.println("| Gladiator:                              |");
            System.out.println("| Gladiators Name: " + playerName+"                 |");
            //Displaying the Weapon that the player is starting off
            System.out.println("| Weapon: Sword                           |");
            System.out.println("| Gladiators Health:" + playersHealth + "%                  |");
            System.out.println("|_________________________________________|");
            
            //goblin section displaying Name, weapon and health
            System.out.println("\n _________________________________________");
            System.out.println("| Goblin:                                 |");
            System.out.println("| Name: Giant Goblin                      |");
            System.out.println("| Weapon: Club                            |");
            System.out.println("| Goblins Health:" + goblinsHealth + "%                     |");
            System.out.println("|_________________________________________|");

            //asking the player to choose an attack
            System.out.println("\nChoose an attack:");
            System.out.println("1.Light Attack");
            System.out.println("2.Medium Attack");
            System.out.println("3.Heavy Attack");
            //displaying the attack number
            System.out.print("Attack Chosen: ");
            attackChoice = keyboard.nextInt();
            

            //if player chooses 1 then then generates damage percentage
            if (attackChoice == 1) 
            {
                System.out.println("Light attack");
                playerDamage = rand.nextInt(4)+2;  //randomly generates 2-5% of damage  displays
                System.out.println("You dealt " + playerDamage+ "% damage to the Giant Goblin");
                
            }
            //if player chooses 2 then generates damage percentage
            else if (attackChoice == 2)
            {
                System.out.println("Medium attack");
                playerDamage = rand.nextInt(25)+1;   //randomly generates 1-25% of damage and displays
                System.out.println("You dealt " + playerDamage+ "% damage to the Giant Goblin");

            }
            //if player chooses 3 then generates damage percentage
            else if (attackChoice == 3)
            {
                System.out.println("Heavy attack");
                zeroChance = rand.nextInt(2); //randomly generates 0-50% of damage and displays with a chance to miss
                //if the player get 0% damage 
                if(zeroChance == 0) 
                {
                    playerDamage = 0; //the attack has been missed and no damage has been applied
                    System.out.println("Oh No! You have missed your heavy attack!");
                }
                else
                  {
                     playerDamage = rand.nextInt(50)+1;// randomly generates 1-50% of damage
                     System.out.println("You dealt " + playerDamage+ "% damage to the Giant Goblin");
                  }
            }
                else
                  {
                   //if the player makes a invalid choice the the attack will be missed
                    System.out.println("Invalid option so your attack is missed!");
                  }
            

            
                //damgage calculated
                goblinsHealth = goblinsHealth - playerDamage;
                goblinsHealth = Math.max(goblinsHealth, 0); // Avoid negative health
            
            //goblins attacks randoimsed and gives feedback what type and  what damage is dealt
             goblinsAttack = rand.nextInt(3)+1; //randomises and picks one of the types of attacks
             
            //goblinsDamage = randomises the damage percentage delt to the player
            //attack 1 light attack
            if(goblinsAttack == 1)
               {
                   System.out.print("\nGiant Goblin: ");
                   System.out.println("Light Attack");
                   System.out.println("");
                   goblinsDamage = rand.nextInt(4)+2; //Randomises damage 2-5%
               }
            //attack 2 medium attack
            else if (goblinsAttack == 2)
            {
                System.out.print("\nGiant Goblin: ");
                System.out.println("Medium Attack");
                System.out.println("");
                goblinsDamage = rand.nextInt(25)+1; //Randomises damage 1-25%
            }
            //attack 3 heavy attack
            else if (goblinsAttack == 3)
            {
                System.out.print("\nGiant Goblin: ");
                System.out.println("Heavy Attack");
                System.out.println("");
                zeroChance = rand.nextInt(2); //Randomises  50% to miss or not
            
              //if the goblin get 0% damage 
                if(zeroChance == 0) 
                {
                    System.out.print("\nGiant Goblin:");
                    goblinsDamage = 0; //the attack has been missed and no damage has been applied
                    System.out.println(" Yes! Giant Goblin has missed his heavy attack!");
                }
                else
                  {
                     goblinsDamage = rand.nextInt(50)+1;// randomly generates 1-50% of damage
                    
                  }
            }
              
            
            //calculation for players health when golbin damages the player
            playersHealth= playersHealth - goblinsDamage;
            playersHealth = Math.max(playersHealth, 0); // Avoid negative health
            
            //prints out the damage (%) delt to the player and players name
            System.out.println("Goblins damage dealt "+goblinsDamage + "%"+ " to " +playerName);
        
            

            //Win or Deafeated section of the code
            //if the goblins health is 0%
            if (goblinsHealth <= 0) 
            {
                //displaying the rounds
                System.out.println("\n---------------- Round " + round + " ----------------");
                round++;
                //Displaying Health & name, weapon of the gladiotor's and goblins
                //players section displaying Name, weapon and health
                System.out.println(" _________________________________________");
                System.out.println("| Gladiator:                              |");
                System.out.println("| Gladiators Name: " + playerName + "                 |");
                System.out.println("| Weapon: Sword                           |");
                System.out.println("| Gladiators Health:" + playersHealth + "%                  |");
                System.out.println("|_________________________________________|");

                //for space 
                System.out.println("");
                //goblin section displaying Name, weapon and health
                System.out.println(" _________________________________________");
                System.out.println("| Goblin:                                 |");
                System.out.println("| Name: Giant Goblin                      |");
                System.out.println("| Weapon: Club                            |");
                System.out.println("| Goblins Health:" + goblinsHealth + "%                     |");
                System.out.println("|_________________________________________|");
                //contradulates the player for winning the game
                System.out.println("\n __________________________________________________________________________________________");
                System.out.println("| Contratulations! " + playerName + " ,You have defeated the Giant Goblin and you got your freedom Back! |");
            } 
            //then if players health is 0% 
            else if (playersHealth <= 0) 
            {
                //displaying the rounds
                System.out.println("\n---------------- Round " + round + " ----------------");
                round++;
                //Displaying Health & name, weapon of the gladiotor's and goblins
                //players section displaying Name, weapon and health
                System.out.println(" _________________________________________");
                System.out.println("| Gladiator:                              |");
                System.out.println("| Gladiators Name: " + playerName + "                 |");
                //Displaying the Weapon that the player is starting off
                System.out.println("| Weapon: Sword                           |");
                System.out.println("| Gladiators Health:" + playersHealth + "%                  |");
                System.out.println("|_________________________________________|");


                //goblin section displaying Name, weapon and health
                System.out.println(" \n_________________________________________");
                System.out.println("| Goblin:                                 |");
                System.out.println("| Name: Giant Goblin                      |");
                System.out.println("| Weapon: Club                            |");
                System.out.println("| Goblins Health:" + goblinsHealth + "%                     |");
                System.out.println("|_________________________________________|");
                
                //Letting the player know that he/she has been defeated 
                System.out.println("\n ____________________________________________________");
                System.out.println("You have been defeated by the Giant Goblin. Game Over!");
            
      
            }

            }
            //printing out would you like to play again
            System.out.print("Would u like to play again? (yes/no): ");
            playAgainChoice = keyboard.next();
            keyboard.nextLine(); //consumes the newline
            playagain=playAgainChoice.toLowerCase().equals("yes");
            
            //Thanking the player for playing the game print out on a new line
            System.out.println("\nThank your for playing Gladiators Last Stand ");
            System.out.println(" ____________________________________________");
        }
       
    }
}
/*kevin, the games nearly works perfectly it will only crash if you put "#" or different symbol for choosing for an attack
the reason i think it crashes since it doesnt match any of the options :)*/
