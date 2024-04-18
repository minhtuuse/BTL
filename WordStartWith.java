import java.util.LinkedList;
import java.util.TreeSet;

public class WordStartWith {
    private LinkedList<String> dic;
    private TreeSet<String> set;

    /**
     * @param l linkedlist cac tu  tieng  anh trong tu dien ban dau.
     * @param s tro toi l (cac tu tieng anh duoc them vao).
     */
    public WordStartWith(LinkedList<String> l, TreeSet<String> s) {
        this.dic = l;
        this.set = s;
    }

    /**
     * dung BinarySearch de tim ra 1 tu bat dau bang String  word.
     *
     * @param word  tu can tim
     * @param start
     * @param end
     * @return ket qua la tu tim duoc hoac  "NOT FOUND"
     */
    public String searchForWord(String word, int start, int end) {
        if (start > end) {
            return "NOT FOUND";
        }
        if (dic.get((start + end) / 2).startsWith(word)) {
            return dic.get((start + end) / 2);
        } else if (dic.get((start + end) / 2).compareTo(word) < 0) {
            return searchForWord(word, (start + end) / 2 + 1, end);
        } else if (dic.get((start + end) / 2).compareTo(word) > 0) {
            return searchForWord(word, start, (start + end) / 2 - 1);
        }
        return "NOT FOUND";
    }

    /**
     * dung ham searchForWord de tim duoc 1 tu bat dau bang  String word.
     * neu searchForWord tra ve "NOT FOUND" ,xet den cac tu trong set. neu van khong co thi tra ve "NOT FOUND".
     * neu searchForWord tra ve 1 tu, tim vi tri cua tu do trong linkedlist, roi chay tu vi tri do den 2 dau,
     * sau do xet them cac tu trong set.
     * tra ve tat ca cac tu bat dau voi String word.
     *
     * @param word
     * @return
     */
    public String startsWith(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(searchForWord(word, 1, dic.size()));
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
            for (int t = begin + 1; t < dic.size(); t++) {
                if (dic.get(t).startsWith(word)) {
                    sb.append("\n");
                    sb.append(dic.get(t));
                } else {
                    break;
                }
            }
        }
        if (!set.isEmpty()) {
            for (String x : set) {
                if (x.startsWith(word)) {
                    sb.append("\n");
                    sb.append(x);
                }
            }
        }
        String[] lines = sb.toString().split("\n");
        sb.setLength(0);
        if (lines.length < 2 && lines[0].equals("NOT FOUND")) {
            return "NOT FOUND";
        } else {
            for (int i = 0; i < lines.length; i++) {
                if (!lines[i].equals("NOT FOUND")) {
                    sb.append(lines[i]);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
