public class CorrectGuess extends Guess{
    public CorrectGuess(String hiddenWord, String let){
        super(hiddenWord);
        setLetter(let);
    }

    @Override
    public void setLetter(String let){
        let = Colors.GREEN + let + Colors.RESET;
        super.setLetter(let);
    }

}
