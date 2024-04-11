import java.util.Map;
import java.util.TreeSet;

public class EditDic {
    private Map<String, String> words;
    private TreeSet<String> l = new TreeSet<>();

    public EditDic(Map<String, String> m) {
        this.words = m;
    }
    public TreeSet<String> getSet(){
        return this.l;
    }

    public void add(String Eng, String Vie) {
        if (words.containsKey(Eng)) {
            System.out.println("Tu tieng Anh ban vua Nhap da ton tai. Ban co muon thay doi nghia cua tu?");
            // neu nguoi dung chon co
            changeMeaning(Eng, Vie);
        } else {
            words.put(Eng, Vie + "\n");
            l.add(Eng);
        }
    }

    public void changeMeaning(String Eng, String Vie) {
        if (!words.containsKey(Eng)) {
            System.out.println("Tu ban muon thay doi nghia khong ton tai trong tu dien." +
                    " Ban co muon them no vao tu dien?");
            //neu nguoi dung chon co
            add(Eng, Vie);
        } else {
            words.put(Eng, Vie + "\n");
        }
    }

    public void addMeaning(String Eng, String Vie) {
        if (!words.containsKey(Eng)) {
            System.out.println("Tu ban muon them nghia khong ton tai. Ban co muon them no vao tu dien?");
            // neu nguoi dung chon co
            add(Eng, Vie);
        } else {
            StringBuilder sb = new StringBuilder(words.get(Eng));
            sb.append("\n");
            sb.append(Vie);
            sb.append("\n");
            words.put(Eng, sb.toString());
        }
    }

    public void deleteMeaning(String Eng) {
        if (!words.containsKey(Eng)) {
            System.out.println("Tu ban muon xoa khong ton tai trong tu dien");
        } else {
            words.remove(Eng);
            if (l.contains(Eng)) {
                l.remove(Eng);
            }
        }
    }
}
