public class WrongGuess extends Guess{
    public WrongGuess(String hiddenWord, String let){
        super(hiddenWord);
        setLetter(let);
    }

    @Override
    public void setLetter(String let){
        let = Colors.RED + let + Colors.RESET;
        super.setLetter(let);
    }

}
