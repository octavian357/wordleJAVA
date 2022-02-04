import java.util.Scanner;
import java.util.ArrayList;

public class Wordle{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static String word = "PENIS";
    public static void main(String[] args) {
        boolean gameEnded = false;

        ArrayList<String> guesses = new ArrayList<String>();
        int guessCount = 0; 

        //get users name
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your name: ");
        String user = in.nextLine();
        System.out.println("Hello " + user + "!! Welcome to WORDLE.");

        System.out.println("Correct letters int the RIGHT position will be " + ANSI_GREEN + "GREEN" + ANSI_RESET);
        System.out.println("Correct letters in the WRONG position will be " + ANSI_YELLOW + "YELLOW" + ANSI_RESET);

        //GAME BEGIN
        while(gameEnded == false){
            System.out.println("Enter you guess:");
            String guess = in.nextLine();
            guesses.add(guess);
            guessCount++;
            for (int i = 0; i < guesses.size(); i++) {
            gameEnded = guessComp(guesses.get(i));
            }
            if(guesses.size() == 6){
                gameEnded = true;
            }
            System.out.println("");
        }
        if(guesses.get(guesses.size()-1).toUpperCase().equals(word)){
            System.out.println("CONGRADULATIONS!! YOU GOT THE ANSWER IN " + guessCount);
        }
        in.close(); 
    }

    public static boolean guessComp(String guess){
        System.out.println("");
        for(int i=0; i<5; i++){
             if(word.charAt(i) == guess.toUpperCase().charAt(i)){
                System.out.print(ANSI_GREEN + guess.toUpperCase().charAt(i) + ANSI_RESET);
            }else if(word.contains(String.valueOf(guess.toUpperCase().charAt(i)))){
                System.out.print(ANSI_YELLOW + guess.toUpperCase().charAt(i) + ANSI_RESET);
            }else{
                System.out.print(guess.toUpperCase().charAt(i));
            }
        }
        if(guess.toUpperCase().equals(word)){
            return true;
        }else{
            return false;
        }
    }
} 