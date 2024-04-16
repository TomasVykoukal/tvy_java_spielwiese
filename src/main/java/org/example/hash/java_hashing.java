package org.example.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//a naive user's test of hashing mechanisms in java
public class java_hashing {
    public static String[] algs = new String[21];

    //function to convert byte array to hexadecimal string
    public static String ConvBytes2Hex(byte[] bytes_str) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes_str) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        algs[0]  = "SHA-1"; //todo: select contents programmatically - s. public class ShowAlgorithms*
        algs[1]  = "SHA1";
        algs[2]  = "SHA";
        algs[3]  = "MD2";
        algs[4]  = "MD5";
        algs[5]  = "SHA-512/256";
        algs[6]  = "SHA512/256";
        algs[7]  = "SHA3-512";
        algs[8]  = "SHA-256";
        algs[9]  = "SHA256";
        algs[10] = "SHA-384";
        algs[11] = "SHA384";
        algs[12] = "SHA-512/224";
        algs[13] = "SHA512/224";
        algs[14] = "SHA-512";
        algs[15] = "SHA512";
        algs[16] = "SHA3-256";
        algs[17] = "SHA-224";
        algs[18] = "SHA224";
        algs[19] = "SHA3-384";
        algs[20] = "SHA3-224";

        String text1 = "Hello world!";
        String text2 = "Hello World!";
        String text3 = "Hello world!";
        byte[] text1_b = text1.getBytes(StandardCharsets.UTF_8);
        byte[] text2_b = text2.getBytes(StandardCharsets.UTF_8);
        byte[] text3_b = text3.getBytes(StandardCharsets.UTF_8);
        byte[] hash1_b, hash2_b, hash3_b;
        String hash1, hash2, hash3;

        System.out.println("Text(s) to be hashed:");
        System.out.println(text1 + ", " + text2);
        System.out.println(text3);

        System.out.println("\nHashing by Java-native Hash Function:");
        System.out.println(text1.hashCode() + ", " + text2.hashCode());
        System.out.println(text3.hashCode());

        System.out.println("\nText to be hashed as byte[] Input (Check Output): " + new String(text1_b, StandardCharsets.UTF_8));

        System.out.println("Hashing by MessageDigest with different Algorithms incl. Digest Length:");
        for (int i = 0; i < algs.length; i++) {
            System.out.print((i+1) + ". \"" + algs[i] + "\"\t");
            MessageDigest md = MessageDigest.getInstance(algs[i]);
            //System.out.println(md.getAlgorithm() + "; " + md.getProvider() + "; " + md.getDigestLength());
            System.out.print("(" + md.getDigestLength() + ") ");

            md.update(text1_b);
            hash1_b = md.digest();

            hash1 = ConvBytes2Hex(hash1_b);
            System.out.println(hash1);
        }
    }
}
    //String sha256hex = new String(Hex.encode(hash));
    //String sha3Hex = bytesToHex(hashbytes);

