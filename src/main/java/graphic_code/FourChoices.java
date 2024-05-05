package graphic_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FourChoices extends Game {
    private List<String> choices = new ArrayList<>();
    private Map<String, String> dictionary;

    public FourChoices( Map<String, String> m) {
        super();
        this.dictionary = m;
    }

    /**
     * chon ngau nhien 4 tu tieng anh va 1 tu la dap an trong 4 tu
     */
    public void getFourChoices() {
        shuffleWords();
        for (int i = 0; i < 4; i++) {
            choices.add(words.get(i));
        }
        Random random = new Random();
        setCorrectAnswer(words.get(random.nextInt(4)));
    }

    /**
     * in ra man hinh nghia cua dap an va 4 tu tieng anh
     */
    public ArrayList<String> showQuestion() {
        getFourChoices();
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(dictionary.get(correctAnswer));
        for (String x : choices) {
            arrayList.add(x);
        }
        return arrayList;
    }
    public void clearchoices(){
        choices.clear();
    }
}