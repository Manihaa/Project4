public class Guess {
    private String hidden;
    private int len;
    private String letter;

    public Guess(String word){
        hidden = word;
        len = hidden.length();
    }

    public boolean isValid(String word){
        boolean boo = true;
        // checks if the word is an applicable guess
        return boo;
    }

    public String[] attempt(){
        //returns for each letter whether it was
        // correct, wrong, or close so the game class can set
        // each letter to the correct subclass
    }

    public void setLetter(){
        //based on whether the letter was incorrect, correct, or close
    }
}
