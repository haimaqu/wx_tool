package com.imooc.wx_tool.util;

/***
 * @author V��֪ʶ�� www.vxzsk.com
 * linfanhehe@163.com
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
public class TestAcessToken {
    /***
     * ģ��get����
     * @param url
     * @param charset
     * @param timeout
     * @return
     */
     public static String sendGet(String url, String charset, int timeout)
      {
        String result = "";
        try
        {
          URL u = new URL(url);
          try
          {
            URLConnection conn = u.openConnection();
            conn.connect();
            conn.setConnectTimeout(timeout);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            String line="";
            while ((line = in.readLine()) != null)
            {
             
              result = result + line;
            }
            in.close();
          } catch (IOException e) {
            return result;
          }
        }
        catch (MalformedURLException e)
        {
          return result;
        }
       
        return result;
      }
   public static void main(String[] args) {
        String appid="wx53f704e68305cde5";//Ӧ��ID
        String appSecret="72aa5fa5c0d4a50efe13aa7697d73c2f";//(Ӧ����Կ)
        String url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appSecret+"";
        String backData=TestAcessToken.sendGet(url, "utf-8", 10000);
        System.out.println("���أ�"+backData);
    }
}