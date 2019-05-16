import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logifail {

    private File logifail;

    public Logifail(String failinimi) throws IOException {
        this.logifail = new File(failinimi);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(logifail))) {
            dos.writeInt(0);
        }
    }

    public void kirjuta(String info) throws IOException {
        List<String> kirjed = this.loe();
        List<String> väljund = new ArrayList<>();

        if (kirjed.size() == 5) {
            for (int i = 1; i < 5; i++) {
                väljund.add(kirjed.get(i));
            }
            väljund.add(info);
        }
        if (kirjed.size() < 5) {
            väljund.addAll(kirjed);
            väljund.add(info);
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(logifail, false))) {
            dos.writeInt(väljund.size());
            for (String kirje : väljund) {
                dos.writeUTF(kirje);
            }
        }
    }

    public List<String> loe() throws IOException {
        List<String> kirjed = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(logifail))) {
            int kirjeteArv = dis.readInt();
            for (int i = 0; i < kirjeteArv; i++) {
                kirjed.add(dis.readUTF());
            }
        }
        return kirjed;
    }

}
