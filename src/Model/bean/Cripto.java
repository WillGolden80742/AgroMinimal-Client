package Model.bean;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
/**
 *
 * @author William
 */
public class Cripto {

    private String value = "";
    private static String key = "willGolden";

    public Cripto(String value) {
        this.value = value;
    }

    public Cripto() {

    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Cripto.key = key;
    }

    public String getHashMd5() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
        return hash.toString(16);
    }

    public String cifrarV (String text) {
            String textC = text;
            int ascii = 0, contKey = 0, sizeKey = key.length() - 1, sizeChar = text.length();
            textC = "";
            if (!key.equals("")) {
                for (int i = 0; i < sizeChar; i++) {
                    ascii = (int) text.charAt(i);
                    ascii += (int) key.charAt(contKey);
                    textC+="" + ((char) ascii);
                    if (contKey != sizeKey) {
                        contKey++;
                    } else {
                        contKey = 0;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Defina sua chave");
            }
        return textC;
    }

    public String decifrarV(String text) {
        int ascii = 0, contKey = 0, sizeKey = key.length() - 1, sizeChar = text.length();
        String textD = "";
        if (!key.equals("")) {
            for (int i = 0; i < sizeChar; i++) {
                ascii = (int) text.charAt(i);
                ascii -= (int) key.charAt(contKey);
                textD += "" + ((char) ascii);
                if (contKey != sizeKey) {
                    contKey++;
                } else {
                    contKey = 0;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Defina sua chave!");
        }
        return textD;
    }

//
//    public Object toObject(byte[] bytes) {
//        Object obj = null;
//        try {
//            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//            ObjectInputStream ois = new ObjectInputStream(bis);
//            obj = ois.readObject();
//        } catch (IOException ex) {
////TODO: Handle the exception
//        } catch (ClassNotFoundException ex) {
////TODO: Handle the exception
//        }
//        return obj;
//    }
//
//    public byte[] toArrayBytes (Object object) {
//        byte[] yourBytes = null;
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream(bos);
//            out.writeObject(object);
//            out.flush();
//            yourBytes = bos.toByteArray();
//        } catch (IOException ex) {
//            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                bos.close();
//            } catch (IOException ex) {
//                // ignore close exception
//            }
//        }
//        return yourBytes;
//    }
}
