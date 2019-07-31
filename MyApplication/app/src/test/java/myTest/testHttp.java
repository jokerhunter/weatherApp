package myTest;

import net.sf.json.JSONObject;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class testHttp {
    HttpURLConnection connection = null;
    InputStream is = null;
    BufferedReader br = null;
    String result = null;
    public static void main(String[] args) {
        doGet("https://v.juhe.cn/weather/citys?key=af487048073b6c4049fd9178f684e78e");
    }

    public static String doGet(String httpurl){
//        System.setProperty("proxyType", "4");
        System.setProperty("proxyPort", "8080");
        System.setProperty("proxyHost", "172.25.75.2");
//        System.setProperty("proxySet", "true");
        try {

            URL url = new URL(httpurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.connect();
            System.out.println(conn.getResponseCode());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testJson(){
        String jsonMessage = "{\"语文\":\"88\",\"数学\":\"78\",\"计算机\":\"99\"}";

        JSONObject  myJson = JSONObject.fromObject(jsonMessage);
    }
}
