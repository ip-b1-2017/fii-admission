package fii.admission.users;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

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
            //Random rand = new Random();
            MessageDigest digest = MessageDigest.getInstance(this.hashType);
            SecureRandom random = new SecureRandom();
            String salt = new BigInteger(0x32, random).toString(0x20);
            String str = this.str + salt;
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            int lg = hash.length;
            for (int i = 0; i < lg; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return (hexString.toString() + salt);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public String toString(String salt) {
        try {
            //Random rand = new Random();
            MessageDigest digest = MessageDigest.getInstance(this.hashType);
            String str = this.str + salt;
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            int lg = hash.length;
            for (int i = 0; i < lg; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return (hexString.toString() + salt);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
