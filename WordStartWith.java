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
    public void startsWith(String word) {
        String[] words = new String[300];
        int current = 1;
        words[0] = searchForWord(word, 1, dic.size());
        if (!words[0].equals("NOT FOUND")) {
            int begin = dic.indexOf(words[0]);
            for (int i = begin - 1; i > 0; i--) {
                if (dic.get(i).startsWith(word)) {
                    words[current] = dic.get(i);
                    current++;
                } else {
                    break;
                }
            }
            for (int t = begin + 1; t < dic.size(); t++) {
                if (dic.get(t).startsWith(word)) {
                    words[current] = dic.get(t);
                    current++;
                } else {
                    break;
                }
            }
        }
        if (!set.isEmpty()) {
            for (String x : set) {
                if (x.startsWith(word)) {
                    words[current] = x;
                    current++;
                }
            }
        }
        if (current < 2 && words[0].equals("NOT FOUND")) {
            System.out.println("NOT FOUND");
        } else {
            for (int i = 0; i < current; i++) {
                if (!words[i].equals("NOT FOUND")) {
                    System.out.println(words[i]);
                }
            }
        }
    }
}
