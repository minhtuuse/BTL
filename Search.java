import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Search {
    private static Map<String, String> words = new HashMap<String, String>();

    public void initialize() throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        FileReader fr = new FileReader("src/dictionaries.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                line = br.readLine();
            }
            if (line.charAt(0) == '|' || line.charAt(0) == '!') {
                words.put(sb.toString(), sb2.toString());
                sb.setLength(0);
                sb2.setLength(0);
                sb.append(line);
                sb.deleteCharAt(0);
            } else {
                sb2.append(line);
                sb2.append("\n");
            }
        }
        fr.close();
        br.close();
    }

    public static String searchForWord(String word) {
        return words.get(word);
    }

    public static void main(String[] args) throws IOException {
        Search s = new Search();
        s.initialize();
        System.out.println(searchForWord("1 to 1 relationship"));
    }

}
