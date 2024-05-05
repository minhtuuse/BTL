package graphic_code;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class game1_controller {
    @FXML
    protected Button submit;
    @FXML

    protected Button hint;
    @FXML
    protected Button again;
    @FXML
    protected Button start;
    @FXML
    protected Button next;

    @FXML

    protected Label lb1;
    @FXML

    protected Label lb2;
    @FXML

    protected Label score;
    @FXML

    protected TextField dapan;


    private int cauhoi = 0;
    boolean playagain = false;
    private int diem =0;
    private int luot =1;

    RearrangeChars rearrangeChars = new RearrangeChars();

    public void begin(ActionEvent event) {
        bat();
        start.setVisible(false);
        start.setDisable(true);
        game();
        cauhoi++;
    }

    public void tat() {
        submit.setVisible(false);
        hint.setVisible(false);
        lb2.setVisible(false);
        score.setVisible(false);
        dapan.setVisible(false);
        lb1.setVisible(false);
        next.setVisible(false);
    }

    public void bat() {
        submit.setVisible(true);
        hint.setVisible(true);
        lb2.setVisible(true);
        score.setVisible(true);
        dapan.setVisible(true);
        lb1.setVisible(true);
        next.setVisible(true);
    }

    public void game() {
        if (cauhoi == 11) {
            tat();
            lb1.setVisible(true);
            again.setVisible(true);
            lb1.setText("ĐIỂM CỦA BẠN : " + diem);
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
            lb1.setText(rearrangeChars.giveCharsToRearrange());
            lb2.setText("NHẬP TỪ TIẾNG ANH");
        }
    }
    public void nop(ActionEvent event){
        String answer = dapan.getText();
        if(rearrangeChars.checkAnswer(answer)){
            diem+=10;
        }else {
            diem-=10;
        }
        score.setText("Điểm:"+diem);
        lb1.setText(rearrangeChars.getCorrectAnswer());
    }
    public void goiy(ActionEvent event){
        if(luot>3){
            lb2.setText("HẾT LƯỢT GỢI Ý\n"+rearrangeChars.tips(luot));
        }
        else {
            lb2.setText(rearrangeChars.tips(luot));
            luot++;
        }
    }
    public void nextquestion(ActionEvent event){
        cauhoi++;
        luot=1;
        game();
        dapan.clear();
    }
    public void choilai(ActionEvent event){
        playagain=true;
        diem=0;
        score.setText("Điểm:"+diem);
        game();
    }
}