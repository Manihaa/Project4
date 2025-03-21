public class Guess {
    private String hidden;
    private int len;
    private String letter;

    public Guess(String word){
        hidden = word;
        len = hidden.length();
        letter = Colors.BLACK + "x" + Colors.RESET;
    }

    public void setLetter(String let){
        letter = let;
    }

    public String getLetter(){
        return letter;
    }

    public boolean isValid(String word){
        boolean boo = true;
        if (word.length() != len){
            boo = false;
        }
        return boo;
    }

    public String[] attempt(String[] array){
        String[] checked = new String[array.length];
        for (int i = 0; i < array.length; i++){
            if (hidden.contains(array[i])){
                checked[i] = "close";
                if (hidden.substring(i, i+1).equals(array[i])){
                    checked[i] = "correct";
                }
            }else{
                checked[i] = "wrong";
            }
        }
        return checked;
    }

}
