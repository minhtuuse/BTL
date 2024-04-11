import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Save {
    private Map<String, String> words;
    private TreeSet<String> list;

    public Save(Map<String, String> m, TreeSet<String> l) {
        this.words = m;
        this.list = l;
    }

    public void save() throws IOException {
        Set<String> deleted = new HashSet<>();
        FileWriter fw = new FileWriter("src/dic.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<String, String> entry : words.entrySet()) {
            String Eng = entry.getKey();
            String Vie = entry.getValue();
            if (!Eng.isEmpty() && !list.contains(Eng)) {
                if (!list.isEmpty()) {
                    if (Eng.compareTo(list.first()) < 0) {
                        bw.write("|" + Eng + "\n" + Vie);
                    } else {
                        bw.write("|" + list.first() + "\n" + words.get(list.first()));
                        deleted.add(list.first());
                        list.remove(list.first());
                        bw.write("|" + Eng + "\n" + Vie);
                    }
                } else if(!deleted.contains(Eng)) {
                    bw.write("|" + Eng + "\n" + Vie);
                }
            }
        }
        if(!list.isEmpty()){
            for(String x : list){
                bw.write("|"+x+"\n"+words.get(x));
                System.out.println(x);
            }
        }
        bw.write("|");
        bw.flush();
        fw.close();
        bw.close();
    }
}
