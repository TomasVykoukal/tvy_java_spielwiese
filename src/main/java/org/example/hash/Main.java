package org.example.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String text1 = "Hello world!";
        String text2 = "Hello World!";
        String text3 = "Hello world!";
        byte[] hash1, hash2, hash3;

        System.out.println(text1 + ", " + text2);
        System.out.println(text3);

        System.out.println("java-native hash function");
        System.out.println(text1.hashCode() + ", " + text2.hashCode());
        System.out.println(text3.hashCode());

        System.out.println("SHA-1 via MessageDigest");
        MessageDigest md_SHA_1 = MessageDigest.getInstance("SHA-1");
        System.out.println(md_SHA_1.getAlgorithm() + "; " + md_SHA_1.getProvider() + "; " + md_SHA_1.getDigestLength());
        System.out.println(md_SHA_1.digest(text1.getBytes(StandardCharsets.UTF_8)) + ", " + md_SHA_1.digest(text2.getBytes(StandardCharsets.UTF_8)));
        System.out.println(md_SHA_1.digest(text2.getBytes(StandardCharsets.UTF_8)));

        System.out.println("SHA-256 via MessageDigest");
        MessageDigest md_SHA_256 = MessageDigest.getInstance("SHA-256");
        System.out.println(md_SHA_256.getAlgorithm() + "; " + md_SHA_256.getProvider() + "; " + md_SHA_256.getDigestLength());
        System.out.println(md_SHA_256.digest(text1.getBytes(StandardCharsets.UTF_8)) + ", " + md_SHA_256.digest(text2.getBytes(StandardCharsets.UTF_8)));
        System.out.println(md_SHA_256.digest(text2.getBytes(StandardCharsets.UTF_8)));

        System.out.println("SHA3-256 via MessageDigest");
        MessageDigest md_SHA3_256 = MessageDigest.getInstance("SHA3-256");
        System.out.println(md_SHA3_256.getAlgorithm() + "; " + md_SHA3_256.getProvider() + "; " + md_SHA3_256.getDigestLength());
        System.out.println(md_SHA3_256.digest(text1.getBytes(StandardCharsets.UTF_8)) + ", " + md_SHA3_256.digest(text2.getBytes(StandardCharsets.UTF_8)));
        System.out.println(md_SHA3_256.digest(text3.getBytes(StandardCharsets.UTF_8)));

        //byte[] hash_bytes = Hashing.digest("SHA-256", hw1.getBytes()).asBytes();



    }
}