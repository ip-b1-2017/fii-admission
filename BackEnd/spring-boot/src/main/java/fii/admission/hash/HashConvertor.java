package fii.admission.hash;

import java.security.MessageDigest;

/**
 * Created by andy on 20.05.2017.
 */
public class HashConvertor {
    private String str;
    private String hashType;

    public HashConvertor(String str) {
        this(str, "SHA-256");
    }

    public HashConvertor(String str , String hashType){
        this.str=str;
        this.hashType=hashType;
    }
    public String toString() {
        try {
            MessageDigest digest = MessageDigest.getInstance(this.hashType);
            byte[] hash = digest.digest(this.str.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            int lg = hash.length;
            for (int i = 0; i < lg; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
