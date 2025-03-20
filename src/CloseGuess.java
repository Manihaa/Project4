public class CloseGuess extends Guess{
    public CloseGuess(String hiddenWord, String let){
        super(hiddenWord);
        setLetter(let);
    }

    @Override
    public void setLetter(String let){
        let = Colors.YELLOW + let + Colors.RESET;
        super.setLetter(let);
    }
}
