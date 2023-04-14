package com.zzh.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author ZhangZhiHao
 */
public class ZiyouData {
    public static void main(String[] args) throws Exception {
        String result = postJson("https://api.ziyous.cn/api-user/admin/user/list.do", "{}");
        System.out.println("result = " + result);
    }

    public static String postJson(String url, String params) throws Exception {
        URL httpUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
        connection.setRequestProperty("content-type", "application/json;charset=utf-8");
        connection.setRequestProperty("Authorization","Bearer 5164a169-0262-41c7-94b1-69afa7f5e5f6");
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.connect();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        bufferedWriter.write(params);
        bufferedWriter.flush();
        bufferedWriter.close();
        StringBuilder content = new StringBuilder();
        if (connection.getResponseCode() == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                content.append(str);
            }
            bufferedReader.close();
            return content.toString();
        } else {
            System.err.println(connection.getResponseCode());
        }
        return "";
    }

}
