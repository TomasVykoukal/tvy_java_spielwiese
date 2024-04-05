package org.example.convert;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

//Source: https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/
public class ConvBytes2String_dev {
    public static void main(String[] args) throws UnsupportedEncodingException /*bec. of old code*/ {
        String str = "This is raw text!";
        byte[] bytes_str = str.getBytes(StandardCharsets.UTF_8); //String to byte[]
        byte[] bytes_num = {-45, 72, 106, -23, 19, 110, 120, 86, -68, 66, 33, 35, -123, -22, 121, 112, -108, 71, 88, 2}; //SHA-1 hash of "Hello world!"

        //String conversion
        System.out.println("String: " + str);
        System.out.println("String (Byte Format): " + bytes_str);
        System.out.println("String (Byte Format toString()): " + bytes_str.toString()); //returns the address of the object in memory
        System.out.println("String (Byte Format Arrays.toString()): " + Arrays.toString(bytes_str));
        System.out.println("String (Byte Format new String()): " + (new String(bytes_str, StandardCharsets.UTF_8)));
        System.out.println("String (Byte Format new String()): " + (new String(bytes_str, "UTF-8"))); //old code, UnsupportedEncodingException

        //Number conversion
        System.out.println("\nNumbers (Byte Format): " + bytes_num);
        System.out.println("Numbers (Byte Format toString()): " + bytes_num.toString()); //returns the address of the object in memory
        System.out.println("Numbers (Byte Format Arrays.toString()): " + Arrays.toString(bytes_num));
        System.out.println("Numbers (Byte Format new String()): " + (new String(bytes_num, StandardCharsets.UTF_8)));
        System.out.println("Numbers (Byte Format new String()): " + (new String(bytes_num, "UTF-8"))); //old code, UnsupportedEncodingException

        StringBuffer sb = new StringBuffer();
        for (byte b : bytes_num) {
            //sb.append(String.format("%02x", b));
            str = String.format("%02x", b);
            System.out.print(str + " ");
            sb.append(str);
        }
        System.out.println("\nNumbers (String Format hex): " + (sb.toString()));
    }
}
