import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeSet;

public class Save {
    private Map<String, String> words;
    private TreeSet<String> list;

    public Save(Map<String, String> m, TreeSet<String> l) {
        this.words = m;
        this.list = l;
    }

    /**
     * ham dung de luu lai nhung thay doi tu EditEic vao file txt, neu ko co thay doi gi thi ko can chay
     * ham nay se viet de len file txt ban dau, tuc la xoa di viet lai tu dau
     * lan luot ghi cac tu tieng anh va nghia cua no ra file txt, trong khi so sanh voi tu dau tien trong TreeSet list
     * neu tu trong words dang xet de ghi ra so sanh lon hon tu dau tien trong TreeSet, thi se ghi tu trong TreeSet ra truoc
     * @throws IOException
     */
    public void save() throws IOException {
        TreeSet<String> copy = new TreeSet<>(list);
        FileWriter fw = new FileWriter("src/dic.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<String, String> entry : words.entrySet()) {
            String Eng = entry.getKey();
            String Vie = entry.getValue();
            if (!Eng.isEmpty() && !list.contains(Eng)) {
                if (!copy.isEmpty()) {
                    if (Eng.compareTo(copy.first()) < 0) {
                        bw.write("|" + Eng + "\n" + Vie);
                    } else {
                        while (Eng.compareTo(copy.first()) >= 0) {
                            bw.write("|" + copy.first() + "\n" + words.get(copy.first()));
                            copy.remove(copy.first());
                        }
                        bw.write("|" + Eng + "\n" + Vie);
                    }
                } else if (!list.contains(Eng)) {
                    bw.write("|" + Eng + "\n" + Vie);
                }
            }
        }
        if (!copy.isEmpty()) {
            for (String x : copy) {
                bw.write("|" + x + "\n" + words.get(x));
                copy.remove(x);
            }
        }
        bw.write("|");
        bw.flush();
        fw.close();
        bw.close();
    }
}
