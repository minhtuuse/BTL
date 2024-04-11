import java.util.Map;

public class Search{
    private Map<String, String> words;
    public Search(Map<String,String> m){
        this.words=m;
    }
    public String searchForWord(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        } else {
            return "khong tim thay tu";
        }
    }
}
