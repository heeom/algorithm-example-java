import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

    }

    public static String getHash(String key) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++) {
                System.out.println(digest);
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
