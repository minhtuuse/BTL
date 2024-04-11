import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Initialize {
    protected Map<String, String> words = new LinkedHashMap<>();

    public Map<String, String> getWords() {
        return words;
    }

    public void initialize() throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        FileReader fr = new FileReader("src/dic.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                line = br.readLine();
            }
            if (line.charAt(0) == '|') {
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
}
