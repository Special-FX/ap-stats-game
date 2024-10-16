import java.util.Scanner;

public class Game {
    private static Scanner scan;
    //private static double playerBalance;
    private static int playerBalance;
    private static int wager; //change to double or something
    private static int lossCount;
    private static String balanceString;
    private static String wagerString;

    public static void main(String[] args) {
        //greeting();
        modifiedGreeting();

        boolean nineteenDollarFortniteCard = true; //checks for valid balance amounts
        while(nineteenDollarFortniteCard) {

            System.out.print("What's your balance? Enter here: ");
            Scanner scan = new Scanner(System.in);
            balanceString = scan.nextLine();

//            balanceString = "20";
            nineteenDollarFortniteCard = false;
            for(int i = 0; i < balanceString.length(); i++) {
                if(Character.isLetter(balanceString.charAt(i))) {
                    nineteenDollarFortniteCard = true;
                    System.out.println("Enter a valid balance.");
                    System.out.println();
                    break;
                }
            }
        } //playerBalance = Double.valueOf(balanceString);
        playerBalance = Integer.valueOf(balanceString);

        boolean play = true;
        while(play) {
            //System.out.println("Current balance: $" + playerBalance);
            System.out.println("Current tokens: " + playerBalance);
            System.out.println();


            boolean beans = true;
            while(beans) { //asks for player's wager, if player enters <=zero, keeps asking until player enters a valid wager
                System.out.print("What's your wager? Enter here: ");
                scan = new Scanner(System.in);
                wagerString = scan.nextLine();
                beans = false;
                for(int i = 0; i < wagerString.length(); i++) {
                    if(Character.isLetter(wagerString.charAt(i))) {
                        beans = true;
                        System.out.println("Enter a valid wager.");
                        System.out.println();
                        break;
                    }
                    if(Integer.parseInt(wagerString) <= 0 || Integer.parseInt(wagerString) > playerBalance) {
                        beans = true;
                        System.out.println("Enter a valid wager. ");
                        System.out.println();
                        break;
                    }
                }
            } wager = (int) Double.parseDouble(wagerString);


//            wager = 1; //you can uncomment the above if you want to ask the player for a wager, otherwise the
                       //default wager will be 1 token
            System.out.println("You have wagered " + wager + " token(s)");

            System.out.print("\nI have my numbers, what's your first guess? Enter here: ");
            scan = new Scanner(System.in);
            int guess = scan.nextInt();
            System.out.print("What's your second guess? Enter here: ");
            scan = new Scanner(System.in);
            int guess2 = scan.nextInt();
            returnAnswer(guess, guess2);
            playerBalance -= (int) wager;
            if(lossCount == 100) { //CHANGE LOSS COUNT TO WHATEVER
                play = false;
                System.out.println("You're losing too much, go gamble somewhere else.");
                System.out.println();
            } if(playerBalance == 0) {
                play = false;
                //System.out.println("Current balance: $" + playerBalance);
                System.out.println("Current tokens: " + playerBalance);
                System.out.println("You literally have no money left, goodbye.");
                System.out.println();
            } if(playerBalance < 0) {
                play = false;
                //System.out.println("Current balance: -$" + Math.abs(playerBalance));
                System.out.println("Current tokens: -" + Math.abs(playerBalance));
                System.out.println("You're literally in debt, goodbye.");
                System.out.println();
            }
        }
    }

    public static void greeting() { //simple greeting
        System.out.println();
        System.out.println("Welcome to the game, and the rules are as follows: ");
        System.out.println("-Each round I will think of a number from 1 to 100 (inclusive)");
        System.out.println("-In order to guess, you will make a wager");
        System.out.println("    -If your guess matches the number I'm thinking of, you get ten times your wager back");
        System.out.println("    -If your guess does not match the number I'm thinking of, I get to keep your wager");
        System.out.println("    -If you guess correctly 3 times in a row, you get ten times your wager for that round");
        System.out.println();
    }

    public static void modifiedGreeting() { //modified for tokens
        System.out.println();
        System.out.println("Welcome to the game, and the rules are as follows: ");
        System.out.println("-Each round I will think of two integer values from 1 to 20 (inclusive)");
        System.out.println("-In order to play, you will wager a token");
        System.out.println("    -If your guess matches a number I'm thinking of, you get thrice the tokens back");
        System.out.println("    -If your guess does not match the number I'm thinking of, I get to keep your token");
        System.out.println("    -If you guess both numbers, you get ten times the tokens back");
        System.out.println();
    }

    public static void returnAnswer(int guess, int guess2) { //takes the guess and processes it
        int randomNumber = (int)((Math.random() * 20) + 1); // generates a random number from 1 to 100
        int randomNumber2 = (int)((Math.random() * 19) + 1);
        if(randomNumber == randomNumber2) randomNumber2++;
//        randomNumber = 69;
//        int randomNumber2 = 21;
         // keeps generating random numbers until it does not match the player's guess
                                 // there is a chance this doesn't happen within the 50 iterations, but it's like something 1E-30
        if((randomNumber != guess) && (randomNumber2 != guess) && (randomNumber != guess2) && (randomNumber2 != guess2)) {
            // if the random number does not equal the player's guess, print a loss then break*
            System.out.println("\nYou lost, the numbers were " + randomNumber + " and " + randomNumber2);
            System.out.println();
            //break;
        }
        /*else {
            randomNumber = (int)(Math.random() * 99) + 1; // if the randomly generated number matches the player's guess, generate another random number
            randomNumber2 = (int)(Math.random() * 99) + 1;
        }*/

        if(((randomNumber == guess && randomNumber2 == guess2) || (randomNumber == guess2 && randomNumber2 == guess))) {
            System.out.println("\nYou win big, the numbers were " + randomNumber + " and " + randomNumber2);
            System.out.println();
            playerBalance += (int) (wager*10);
        } else if((randomNumber == guess || randomNumber == guess2) || (randomNumber2 == guess || randomNumber2 == guess2)) {
            System.out.println("\nYou win small, the numbers were " + randomNumber + " and " + randomNumber2);
            System.out.println();
            playerBalance += (int) (wager*3);
        }

        if(randomNumber % 2 != 0 || randomNumber2 % 2 != 0) { // *if the randomly generated number is odd, increment lossCount
            lossCount++;
        }
    }
}