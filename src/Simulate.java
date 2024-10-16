public class Simulate {
    public static void main(String[] args) {
        //System.out.println(simulateOneGame());
        simulateManyGames(1_000_000_000);
    }

    public static void simulateManyGames(int numGames) {
        int totalGames = 0;
        int bigWin = 0, smallWin = 0, losses = 0;

        for(int i = 1; i < numGames+1; i++) {
            System.out.println("\n" + i + ". " + simulateOneGame());

            totalGames++; //keeps track of total games played

            String s = simulateOneGame();
            if(s.contains("big")) bigWin++; //keeps track of big wins
            if(s.contains("small")) smallWin++; //keeps track of small wins
            if(s.contains("lost")) losses++; //keeps track of losses

            s = "\uD83E\uDD28\uD83D\uDCF8 Caught you in 8K UHD surround sound 32 Gigs ram, HDR GEFORCE RTX, " +
                    "TI-80 texas insturments, Triple A duracell battery ultrapower100 Cargador Compatible " +
                    "iPhone 1A 5 W 1400 + Cable 100% 1 Metro Blanco Compatible " +
                    "iPhone 5 5 C 5S 6 SE 6S 7 8 X XR XS XS MAX GoPro hero 1 2 terrabyte xbox series x " +
                    "Dell UltraSharp 49 Curved Monitor - U4919DW Sony HDC-3300R 2/3\" CCD HD Super Motion Color Camera," +
                    " 1080p Resolution Toshiba EM131A5C-SS Microwave Oven with Smart Sensor, Easy Clean Interior," +
                    " ECO Mode and Sound On/Off, 1.2 Cu. ft, Stainless Steel" +
                    " HP LaserJet Pro M404n Monochrome Laser Printer with Built-in Ethernet (W1A52A) " +
                    "GE Voluson E10 Ultrasound Machine LG 23 Cu. Ft. Smart Wi-Fi Enabled InstaView Door-in-Door" +
                    " Counter-Depth Refrigerator with Craft Ice Maker GFW850SPNRS GE 28\" Front Load Steam Washer" +
                    " 5.0 Cu. Ft. with SmartDispense, WiFi, OdorBlock and Sanitize and Allergen - Royal Sapphire Kohler" +
                    " K-3589 Cimarron Comfort Height Two-Piece Elongated 1.6 GPF Toilet with AquaPiston Flush Technology";
        }
        System.out.println("\nTotal Games: " + totalGames);

        double bigWinProportion = (double) bigWin / totalGames;
        double bigWinPercent = (bigWinProportion * 100.0);
        bigWinPercent = Math.round(bigWinPercent * 1000.0) / 1000.0;
        System.out.println("Big Wins: " + bigWin + " --> " + bigWinProportion + " = " + bigWinPercent + "%");

        double smallWinProportion = (double) smallWin / totalGames;
        double smallWinPercent = (smallWinProportion * 100.0);
        smallWinPercent = Math.round(smallWinPercent * 1000.0) / 1000.0;
        System.out.println("Small Wins: " + smallWin + " --> " + smallWinProportion + " = " + smallWinPercent + "%");

        double lossProportion = (double) losses / totalGames;
        double lossPercent = (lossProportion * 100.0);
        lossPercent = Math.round(lossPercent * 1000.0) / 1000.0;
        System.out.println("Losses: " + losses + " --> " + lossProportion + " = " + lossPercent + "%");
    }

    public static String simulateOneGame() {
        int guess1, guess2;
        int randomNumber1 ,randomNumber2;

        guess1 = (int)((Math.random() * 20) + 1); //generates guess1 within range
        guess2 = (int)((Math.random() * 19) + 1); //generates guess2 within range
        if(guess2 == guess1) guess2++;

        randomNumber1 = (int)((Math.random() * 20) + 1); //generates randomNumber1 within range
        randomNumber2 = (int)((Math.random() * 19) + 1); //generates randomNumber2 within range
        if(randomNumber1 == randomNumber2) randomNumber2++;

        if((guess1 == randomNumber1 || guess1 == randomNumber2) &&//<-- both guesses have to match
           (guess2 == randomNumber1 || guess2 == randomNumber2)) { //big win
            return ("You win big, the numbers were " + randomNumber1 + " and " + randomNumber2);

        } else if((guess1 == randomNumber1 || guess1 == randomNumber2) ||//<-- only one guess has to match
                  (guess2 == randomNumber1 || guess2 == randomNumber2)) { //small win
            return ("You win small, the numbers were " + randomNumber1 + " and " + randomNumber2);

        } else return ("You lost, the numbers were " + randomNumber1 + " and " + randomNumber2);


/*
        alternate version of the game with different logic

        if((randomNumber1 == guess1 && randomNumber2 == guess2) ||
                (randomNumber1 == guess2 && randomNumber2 == guess1)) { //big W
            return ("You win big, the numbers were " + randomNumber1 + " and " + randomNumber2);

        } else if((randomNumber1 == guess1 || randomNumber1 == guess2) ||
                (randomNumber2 == guess1 || randomNumber2 == guess2)) { //small W
            return ("You win small, the numbers were " + randomNumber1 + " and " + randomNumber2);

        } else return ("You lost, the numbers were " + randomNumber1 + " and " + randomNumber2);

*/
    }
}