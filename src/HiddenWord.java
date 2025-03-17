public class HiddenWord {
    private int length;
    private String lang;
    private String[] e4;
    private String[] e5;
    private String[] s4;
    private String[] s5;
    private String hidden;

    public HiddenWord(int len, String language){
        length = len;
        lang = language;
        listSetter();
        hidden = word();
    }

    public String getHidden(){
        return hidden;
    }

    public String word(){
        String str = "";
        int rand = (int)(Math.random() * 5 + 1);

        if (lang.equals("e")){
            if (length == 4){ //english and 4
                str = e4[rand];
            }else{ // english and 5
                str = e5[rand];
            }
        }else{
            if (length == 4){ // spanish and 4
                str = s4[rand];
            }else{ //spanish and 5
                str = s5[rand];
            }
        }
        return str;
    }

    private void listSetter(){
        e4 = new String[]{"fail", "gasp", "palm", "lick", "know"};
        e5 = new String[]{"dream", "start", "again", "known", "dance"};
        s4 = new String[]{"como", "pero", "gato", "once", "leer"};
        s5 = new String[]{"chica", "nadar", "jardin", "libro", "punto"};
    }
}
