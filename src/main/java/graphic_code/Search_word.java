package graphic_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Search_word {
    protected static Map<String, String> words = new LinkedHashMap<>();


    public void initialize() throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        FileReader fr = new FileReader("D:\\OOP\\DIC_\\src\\main\\java\\dictionaries.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                line = br.readLine();
            }
            if (line.charAt(0) == '|' ) {
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
        if(words.containsKey(word)){
            return words.get(word);
        } else {
            return "Không tìm thấy từ";
        }
    }
    public static Map<String, String> getMap(){
        return words;
    }
}


