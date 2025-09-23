package com.example.chatapplication;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ChatServer {
    private static final int PORT = 12345;
    private static final Map<String, String> USERS = Map.of(
            "Karthik", "karthik@1",
            "Dheeraj", "Dheeraj@2",
            "Akshaya", "akshaya@3"
    );
    private static final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();

    // Shared AES key for demo
    private static final byte[] KEY = "0123456789abcdef".getBytes(StandardCharsets.UTF_8);

    public static void main(String[] args) {
        System.out.println("Chat server started on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
            private Socket socket;
            private PrintWriter out;
            private BufferedReader in;
            private String username;

            ClientHandler(Socket socket) {
                this.socket = socket;
            }

            @Override
            public void run() {
                try {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);

                    // Authentication
                    out.println("Enter username:");
                    String user = in.readLine();
                    out.println("Enter password:");
                    String pass = in.readLine();

                    if (!USERS.containsKey(user) || !USERS.get(user).equals(pass)) {
                        out.println("Authentication failed.");
                        socket.close();
                        return;
                    }

                    this.username = user;
                    clients.add(this);
                    broadcast(username + " joined the chat.");

                    String line;
                    while ((line = in.readLine()) != null) {
                        String decrypted = decrypt(line);
                        broadcast(username + ": " + decrypted);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        clients.remove(this);
                        broadcast(username + " left the chat.");
                        socket.close();
                    } catch (IOException ignored) {}
                }
            }

            void sendMessage(String msg) {
                try {
                    out.println(encrypt(msg));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void broadcast(String msg) {
                for (ClientHandler client : clients) {
                    client.sendMessage(msg);
                }
                System.out.println(msg);
            }
        }

        // AES encrypt/decrypt
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

