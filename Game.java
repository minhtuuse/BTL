import java.util.Collections;
import java.util.List;

public class Game {
    protected List<String> words;
    protected String correctAnswer;
    protected double score=0;
    public Game(List<String>l ){
        this.words=l;
    }

    public double getScore() {
        return score;
    }

    public void setScore() {
        this.score =  this.score+1;
    }

    protected void shuffleWords(){
        Collections.shuffle(words);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
