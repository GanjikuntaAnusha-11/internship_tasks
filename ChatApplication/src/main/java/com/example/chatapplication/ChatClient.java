package com.example.chatapplication;

import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ChatClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    // Same key as server
    private static final byte[] KEY = "0123456789abcdef".getBytes(StandardCharsets.UTF_8);

    public static void main(String[] args) {
        try (Socket soc = new Socket(SERVER_HOST, SERVER_PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            // Thread to read messages
            new Thread(() -> {
                try {
                    String input1;
                    while ((input1 = in.readLine()) != null) {
                        try {
                            String toDecrypt = decrypt(line);
                            System.out.println(toDecrypt);
                        } catch (Exception e) {
                            // initial prompts are plain text
                            System.out.println(input1);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read input from console
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = console.readLine()) != null) {
                out.println(encrypt(message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encryption(String plain) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skey = new SecretKeySpec(KEY, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes(StandardCharsets.UTF_8)));
    }

    private static String decryption(String enc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skey = new SecretKeySpec(KEY, "AES");
        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] decoded = Base64.getDecoder().decode(enc);
        return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
    }
}



