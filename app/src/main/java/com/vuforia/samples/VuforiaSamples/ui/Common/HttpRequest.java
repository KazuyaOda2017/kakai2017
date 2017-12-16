package com.vuforia.samples.VuforiaSamples.ui.Common;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by K.Oda on 2017/12/16.
 */

public class HttpRequest extends AsyncTask<Uri.Builder, Void, String> {

    private String url;
    private String json;
    private CallBackTask callBackTask;

    public HttpRequest(String url,String json){
        this.url = url;
        this.json = json;
    }

    public String excutePost(String url, String json) {

        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        PrintStream ps = null;
        String res = "";

        try {
            //URL設定
            URL ur = new URL(url);

            connection = (HttpURLConnection) ur.openConnection();
            connection.setRequestMethod("POST");
            //no Redirects
            connection.setInstanceFollowRedirects(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setReadTimeout(10000);
            connection.setConnectTimeout(20000);

            //ヘッダーの設定
            connection.addRequestProperty("Content-Type", "application/json; charset=UTF-8");

            //接続
            connection.connect();

            //リクエストボディに書き出しを行う
            outputStream = connection.getOutputStream();
            ps = new PrintStream(outputStream);
            ps.print(json);
            ps.close();
            outputStream.close();

            //レスポンスボディの読み出しを行う
            int responseCode = connection.getResponseCode();
            res = convertToString(connection.getInputStream());

            return res;
        } catch (NullPointerException e) {

            return res;

        } catch (ProtocolException e) {
            e.printStackTrace();
            return res;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return res;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "1";
        } finally {
            ps.close();
        }

    }

    public static String convertToString(InputStream stream) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        while (null != (line = br.readLine())) {
            sb.append(line);
        }
        try {
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    protected String doInBackground(Uri.Builder... builders) {

        String res = this.excutePost(this.url,this.json);
        return res;
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        callBackTask.CallBack(result);
    }

    public void setOnCallBack(CallBackTask _cbj){
        callBackTask = _cbj;
    }

    public static class CallBackTask{
        public void CallBack(String result){

        }
    }
}
