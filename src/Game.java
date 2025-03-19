import java.util.Scanner;

public class Game {
    private Scanner scan; //for gaining input
    private Guess[][] board; //for the gameplay visual
    private boolean end; //set to true to end the ask() loop
    private HiddenWord hiddenWord; //the hidden word class
    private Guess guess; //why do i have this?

    public Game(){
        scan = new Scanner(System.in);
        board = new Guess[][]{};
        end = false;
    }

    public void start(){
        System.out.println("Welcome to Wordle!\nHow long do you want the word to be?\n(4 or 5)");
        int len = scan.nextInt();
        while (!(len == 4 || len == 5)){
            System.out.println("Invalid answer.\n(4 or 5)");
            len = scan.nextInt();
        }

        System.out.println("Should the word be in english or spanish?\n(e or s)");
        String lang = scan.nextLine().toLowerCase();
        while (!(lang.equals("e") || lang.equals("s"))){
            System.out.println("Invalid answer.\n(e or s)");
            lang = scan.nextLine();
        }

        hiddenWord = new HiddenWord(len, lang);
        guess = new Guess(hiddenWord.getHidden());
        boardMaker(len);

        System.out.println("Remember,\nthe word must be "
                + len + " letters long,\nin "
                + lang + ", and you only have 6 guesses.\nGood luck!");

        while(!end){
            ask();
        }

        System.out.println("");
    }

    public void ask(){
        System.out.print("Enter your guess: ");
        String answer = scan.nextLine().toLowerCase();

    }

    private void boardMaker(int num){
        board = new Guess[6][num];
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < num; c++){
                board[r][c] = new Guess(hiddenWord.getHidden());
            }
        }
    }

}
