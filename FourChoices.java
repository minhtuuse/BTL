import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FourChoices extends Game {
    private List<String> choices = new ArrayList<>();
    private Map<String, String> dictionary;

    public FourChoices(List<String> l, Map<String, String> m) {
        super(l);
        this.dictionary = m;
    }

    /**
     * chon ngau nhien 4 tu tieng anh va 1 tu la dap an trong 4 tu
     */
    private void getFourChoices() {
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
    public void showQuestion() {
        System.out.println("Mieu ta sau day dung nhat voi tu tieng Anh nao trong 4 tu");
        getFourChoices();
        System.out.println(dictionary.get(correctAnswer));
        System.out.println();
        for (String x : choices) {
            System.out.println(x);
        }
    }
}
