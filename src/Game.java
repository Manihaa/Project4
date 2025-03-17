import java.util.Scanner;

public class Game {
    private Scanner scan;
    private String[][] board;
    private boolean end;

    public Game(){
        scan = new Scanner(System.in);
        board = new String[][]{};
        end = false;
    }

    public void start(){
        System.out.println("Welcome to Wordle!\nHow long do you want the word to be?\n(4 or 5)");
        int len = scan.nextInt();
        while (!(len == 4 || len == 5)){
            System.out.println("Invalid answer.\n(3, 4, or 5)");
            len = scan.nextInt();
        }

        System.out.println("Should the word be in english or spanish?\n(e or s)");
        String lang = scan.nextLine().toLowerCase();
        while (!(lang.equals("e") || lang.equals("s"))){
            System.out.println("Invalid answer.\n(e or s)");
            lang = scan.nextLine();
        }

        HiddenWord hiddenWord = new HiddenWord(len, lang);
        boardMaker(len);

        while(!end){
            ask();
        }
        System.out.println("");
    }

    public void ask(){

    }

    private void boardMaker(int num){
        board = new String[6][num];
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < num; c++){
                board[r][c] = "x";
            }
        }
    }

}
