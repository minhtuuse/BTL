package graphic_code;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<String> startsWith(String word) {
        List<String> foundWords = new ArrayList<>();
        int size=0;
        foundWords.add(searchForWord(word, 1, dic.size()));
        if (!foundWords.get(0).equals("NOT FOUND")) {
            int begin = dic.indexOf(foundWords.get(0));
            for (int i = begin - 1; i > 0; i--) {
                if(size>5) {
                    break;
                }
                if (dic.get(i).startsWith(word)) {
                    foundWords.add(dic.get(i));
                    size++;
                } else {
                    break;
                }
            }
            for (int t = begin + 1; t < dic.size(); t++) {
                if(size>5) {
                    break;
                }
                if (dic.get(t).startsWith(word)) {
                    foundWords.add(dic.get(t));
                    size++;
                } else {
                    break;
                }
            }
        }
        if (!set.isEmpty()) {
            for (String x : set) {
                if (x.startsWith(word)) {
                    foundWords.add(x);
                }
            }
        }
        if (foundWords.size() > 1 && foundWords.get(0).equals("NOT FOUND")) {
            foundWords.remove(0);
        }
        return foundWords;
    }
}