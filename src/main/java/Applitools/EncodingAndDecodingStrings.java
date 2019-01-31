package Applitools;

import org.apache.commons.codec.binary.Base64;

public class EncodingAndDecodingStrings {
    public static void main(String[] args) {
        String str = "password";

        byte[] encodingString = Base64.encodeBase64(str.getBytes());
        System.out.println(new String(encodingString));

        byte[] decodeString = Base64.decodeBase64(encodingString);
        System.out.println(new String(decodeString));
    }
}
