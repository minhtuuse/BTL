import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RearrangeChars extends Game {

    public RearrangeChars(List<String> l) {
        super(l);
    }

    /**
     * in cac tu tao nen dap an ra man hinh
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
        words.remove(words.get(0));
        giveCharsToRearrange();
    }

    /**
     * kiem  tra dap an
     * @param answer
     */
    public void checkAnswer(String answer) {
        String trimmedAnswer = answer.trim();
        String trimmedCorrectAnswer = correctAnswer.trim();
        if (trimmedAnswer.equals(trimmedCorrectAnswer)) {
            setScore();
            System.out.println("DUNG");
            System.out.println(getScore());
        } else {
            System.out.println("SAI");
            System.out.println(correctAnswer);
        }
    }
}
