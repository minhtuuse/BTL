import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RearrangeChars extends Game {

    public RearrangeChars(List<String> l) {
        super(l);
    }

    /**
     * in cac chu tao nen dap an ra man hinh
     */
    private void giveCharsToRearrange() {
        List<Character> givenChars = new ArrayList<>();
        for (char c : correctAnswer.toCharArray()) {
            givenChars.add(c);
        }
        Collections.shuffle(givenChars);
        for (char c : givenChars) {
            System.out.print(c);
            System.out.print("/");
        }
        System.out.println("\n");
    }

    /**
     * chon 1 tu bat ki trong tu dien
     */
    public void getAWord() {
        shuffleWords();
        correctAnswer = words.get(0);
        giveCharsToRearrange();
    }
}
