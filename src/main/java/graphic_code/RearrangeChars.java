package graphic_code;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RearrangeChars extends Game {
    public RearrangeChars(){
        super();
    }
    public String giveCharsToRearrange() {
        shuffleWords();
        correctAnswer = words.get(0);
        List<Character> givenChars = new ArrayList<>();
        for (char c : correctAnswer.toCharArray()) {
            givenChars.add(c);
        }
        Collections.shuffle(givenChars);
        StringBuilder result=new StringBuilder();
        for(char a:givenChars){
            result.append(a);
            result.append("/");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public String tips(int i){
        if(i>correctAnswer.length()){
            return "LOI";
        }
        return correctAnswer.substring(0,i);
    }
}
