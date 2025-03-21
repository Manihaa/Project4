import java.util.Scanner;

public class Game {
    private Scanner scan; //for gaining input
    private Guess[][] board; //for the gameplay visual
    private boolean end; //set to true to end the ask() loop
    private boolean win;
    private HiddenWord hiddenWord; //the hidden word class
    private Guess guess; //why do i have this?
    private int attempt; //number of tries taken to keep track of what row to edit board and to also end the game

    public Game(){
        scan = new Scanner(System.in);
        board = new Guess[][]{};
        end = false;
        win = false;
        attempt = 0;
    }

    public void start(){
        System.out.print("Welcome to Wordle!\nHow long do you want the word to be? (4 or 5) ");
        int len = scan.nextInt();
        while (!(len == 4 || len == 5)){
            System.out.print("Invalid answer. (4 or 5) ");
            len = scan.nextInt();
        }

        scan.nextLine();

        System.out.print("Should the word be in english or spanish? (e or s) ");
        String lang = scan.nextLine().toLowerCase();
        while (!(lang.equals("e") || lang.equals("s"))){
            System.out.print("Invalid answer. (e or s) ");
            lang = scan.nextLine();
        }

        hiddenWord = new HiddenWord(len, lang);
        guess = new Guess(hiddenWord.getHidden());
        boardMaker(len);

        if (lang.equals("e")){
            lang = "english";
        }else if (lang.equals("s")){
            lang = "spanish";
        }

        System.out.println("\nRemember, the word must be "
                + len + " letters long,\nin "
                + lang + ",\nand you only have 6 guesses.\nGood luck!\n");

        while(!end){
            ask();
        }
        if (win){
            System.out.println("Congratulations!\nIt took you " + attempt + " tries to win!");
        }else{
            System.out.println("The word was " + hiddenWord.getHidden() + ".\nBetter luck next time.");
        }
    }

    public void ask(){
        System.out.print("Enter your guess: ");
        String answer = scan.nextLine().toLowerCase();
        if (guess.isValid(answer)){
            String[] array = new String[answer.length()];
            for (int i = 0; i < array.length; i++){
                array[i] = answer.substring(i, i+1);
            }

            String[] checked = guess.attempt(array);

            for (int i = 0; i < checked.length; i++){
                if (checked[i].equals("close")){
                    board[attempt][i] = new CloseGuess(hiddenWord.getHidden(), array[i]);
                }else if(checked[i].equals("correct")){
                    board[attempt][i] = new CorrectGuess(hiddenWord.getHidden(), array[i]);
                }else if(checked[i].equals("wrong")){
                    board[attempt][i] = new WrongGuess(hiddenWord.getHidden(), array[i]);
                }
            }
            System.out.println("\nAttempt #" + (attempt+1));
            printBoard();
            didWin(checked);
            attempt++;
        }else{
            System.out.println("Invalid! The guess must be the correct length.");
        }
    }

    private void boardMaker(int num){
        board = new Guess[6][num];
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < num; c++){
                board[r][c] = new Guess(hiddenWord.getHidden());
            }
        }
    }

    public void printBoard(){
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < board[r].length; c++){
                System.out.print(board[r][c].getLetter() + "  ");
            }
            System.out.println();
        }
    }

    private void didWin(String[] checked){
        if (attempt+1 == 6){
            end = true;
        }

        boolean boo = true;
        for (int i = 0; i < checked.length; i++){
            if (!(checked[i].equals("correct"))){
                boo = false;
            }
        }
        if (boo){
            end = true;
            win = true;
        }
    }
}
