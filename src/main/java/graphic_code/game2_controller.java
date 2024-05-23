package graphic_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class game2_controller {
    @FXML
    protected Button ans1;
    @FXML
    protected Button ans2;
    @FXML
    protected Button ans3;
    @FXML
    protected Button ans4;
    @FXML
    protected Button start;
    @FXML
    protected Button again;
    @FXML
    protected Button next;
    @FXML
    protected TextArea question;
    @FXML
    protected Label lb;
    @FXML
    protected Label score;
    Search_word search_word=new Search_word();
    FourChoices fourChoices=new FourChoices(search_word.getMap());
    private int cauhoi = 0;
    boolean playagain = false;
    boolean choose=false;
    private int diem =0;
    public void resetcolor(){
        ans1.setStyle("-fx-background-color: grxáey;");
        ans2.setStyle("-fx-background-color: grxáey;");
        ans3.setStyle("-fx-background-color: grxáey;");
        ans4.setStyle("-fx-background-color: grxáey;");
    }
    public void begin(ActionEvent event) {
        bat();
        start.setVisible(false);
        start.setDisable(true);
        game();
        cauhoi++;
    }
    public void tat(){
        ans1.setVisible(false);
        ans2.setVisible(false);
        ans3.setVisible(false);
        ans4.setVisible(false);
        next.setVisible(false);
        question.setVisible(false);
        lb.setVisible(false);
        score.setVisible(false);
    }
    public void bat(){
        ans1.setVisible(true);
        ans2.setVisible(true);
        ans3.setVisible(true);
        ans4.setVisible(true);
        next.setVisible(true);
        question.setVisible(true);
        lb.setVisible(true);
        score.setVisible(true);
    }
    public void game() {
        if (cauhoi == 11) {
            tat();
            lb.setVisible(true);
            again.setVisible(true);
            lb.setText("ĐIỂM CỦA BẠN : " + diem);
            if (playagain) {
                cauhoi = 1;
                playagain = false;
                bat();
                again.setVisible(false);
                diem =0;
                game();
            } else {
                return;
            }
        } else {
            lb.setText("CHỌN ĐÁP ÁN ĐÚNG");
            fourChoices.clearchoices();
            ArrayList<String> ques=fourChoices.showQuestion();
            question.setText(ques.get(0));
            ans1.setText(ques.get(1));
            ans2.setText(ques.get(2));
            ans3.setText(ques.get(3));
            ans4.setText(ques.get(4));
        }
    }
    public void da1(ActionEvent event) {
        if (choose == false) {
            choose=true;
            String answer = ans1.getText();
            if (fourChoices.checkAnswer(answer)) {
                ans1.setStyle("-fx-background-color: green");
                diem += 10;
            } else {
                diem -= 10;
                ans1.setStyle("-fx-background-color: red");
                if (fourChoices.checkAnswer(ans2.getText())) {
                    ans2.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans3.getText())) {
                    ans3.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans4.getText())) {
                    ans4.setStyle("-fx-background-color: green");
                }
            }
            score.setText("Điểm:" + diem);
        }
    }
    public void da2(ActionEvent event) {
        if (choose == false) {
            choose=true;
            String answer = ans2.getText();
            if (fourChoices.checkAnswer(answer)) {
                ans2.setStyle("-fx-background-color: green");
                diem += 10;
            } else {
                diem -= 10;
                ans2.setStyle("-fx-background-color: red");
                if (fourChoices.checkAnswer(ans1.getText())) {
                    ans1.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans3.getText())) {
                    ans3.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans4.getText())) {
                    ans4.setStyle("-fx-background-color: green");
                }
            }
            score.setText("Điểm:" + diem);
        }
    }
    public void da3(ActionEvent event) {
        if (choose == false) {
            choose=true;
            String answer = ans3.getText();
            if (fourChoices.checkAnswer(answer)) {
                ans3.setStyle("-fx-background-color: green");
                diem += 10;
            } else {
                diem -= 10;
                ans3.setStyle("-fx-background-color: red");
                if (fourChoices.checkAnswer(ans2.getText())) {
                    ans2.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans1.getText())) {
                    ans1.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans4.getText())) {
                    ans4.setStyle("-fx-background-color: green");
                }
            }
            score.setText("Điểm:" + diem);
        }
    }
    public void da4(ActionEvent event) {
        if (choose == false) {
            choose=true;
            String answer = ans4.getText();
            if (fourChoices.checkAnswer(answer)) {
                ans4.setStyle("-fx-background-color: green");
                diem += 10;
            } else {
                diem -= 10;
                ans4.setStyle("-fx-background-color: red");
                if (fourChoices.checkAnswer(ans2.getText())) {
                    ans2.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans3.getText())) {
                    ans3.setStyle("-fx-background-color: green");
                } else if (fourChoices.checkAnswer(ans1.getText())) {
                    ans1.setStyle("-fx-background-color: green");
                }
            }
            score.setText("Điểm:" + diem);
        }
    }
    public void nextquestion(ActionEvent event){
        cauhoi++;
        choose=false;
        resetcolor();
        game();
    }
    public void choilai(ActionEvent event){
        playagain=true;
        diem=0;
        score.setText("Điểm:"+diem);
        game();
    }
}
