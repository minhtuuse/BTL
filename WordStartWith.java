import java.util.LinkedList;
import java.util.TreeSet;

public class WordStartWith {
    private LinkedList<String> dic;
    private TreeSet<String> set;

    public WordStartWith(LinkedList<String> l, TreeSet<String> s) {
        this.dic = l;
        this.set = s;
    }

    public String searchForWord(String word, int start, int end) {
        if (start >= end) {
            return "NOT FOUND";
        }
        if (dic.get((start + end) / 2).startsWith(word)) {
            return dic.get((start + end) / 2);
        } else if (dic.get((start + end) / 2).compareTo(word) < 0) {
            return searchForWord(word, (start + end) / 2+1, end);
        } else if (dic.get((start + end) / 2).compareTo(word) > 0) {
            return searchForWord(word, start, (start + end) / 2-1);
        }
        return "NOT FOUND";
    }

    public String startsWith(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append( searchForWord(word, 1, dic.size()));
        if (!sb.toString().equals("NOT FOUND")) {
            int begin = dic.indexOf(sb.toString());
            for (int i = begin - 1; i > 0; i--) {
                if (dic.get(i).startsWith(word)) {
                    sb.append("\n");
                    sb.append(dic.get(i));
                } else {
                    break;
                }
            }
            for (int t = begin+1; t < dic.size(); t++) {
                if (dic.get(t).startsWith(word)) {
                    sb.append("\n");
                    sb.append(dic.get(t));
                } else {
                    break;
                }
            }
        }
        if(!set.isEmpty()){
            if(sb.toString().equals("NOT FOUND")){
                sb.setLength(0);
            }
            for(String x: set){
                if(x.startsWith(word)){
                    sb.append("\n");
                    sb.append(x);
                }
            }
        }
        if(sb.charAt(0)=='\n'){
            sb.deleteCharAt(0);
            return sb.toString();
        }
        return sb.toString();
    }
}
