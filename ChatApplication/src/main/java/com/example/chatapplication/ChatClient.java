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
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Thread to read messages
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        try {
                            String decrypted = decrypt(line);
                            System.out.println(decrypted);
                        } catch (Exception e) {
                            // initial prompts are plain text
                            System.out.println(line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read input from console
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            while ((msg = console.readLine()) != null) {
                out.println(encrypt(msg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String plain) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skey = new SecretKeySpec(KEY, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plain.getBytes(StandardCharsets.UTF_8)));
    }

    private static String decrypt(String enc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skey = new SecretKeySpec(KEY, "AES");
        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] decoded = Base64.getDecoder().decode(enc);
        return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
    }
}

