package graphic_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    protected List<String> words;
    protected String correctAnswer;
    protected double score = 0;
    Search_word search_word=new Search_word();

    public Game() {
        this.words = new ArrayList<>(search_word.getMap().keySet());
    }

    public double getScore() {
        return score;
    }

    public void setScore() {
        this.score = this.score + 1;
    }

    protected void shuffleWords() {
        Collections.shuffle(words);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void showCorrectAnswer() {
        System.out.println(getCorrectAnswer());
    }

    /**
     * String answer phai duoc doc bang BufferReader
     * vi du:
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * rc.checkAnswer(br.readLine());
     * @param answer
     */
    public boolean checkAnswer(String answer) {
        String trimmedAnswer = answer.trim();
        String trimmedCorrectAnswer = correctAnswer.trim();
        if (trimmedAnswer.equalsIgnoreCase(trimmedCorrectAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}
