package com.imooc.wx_tool.po;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextMessageUtil{
     private static final String MESSAGE_TEXT = "text";

    /**
     * 将发送消息封装成对应的xml格式
     */
    public static String messageToxml(MessageText  message) {
        XStream xstream  = new XStream();
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }

    /**
     * 图文消息转为xml
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",newsMessage.getClass());
        xStream.alias("item",new News().getClass());
        return xStream.toXML(newsMessage);
    }
    /**
     * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
     * @param FromUserName
     * @param ToUserName
     */
    //public static String initMessage(String ToUserName, String FromUserName,String Content) {
    public static String initMessage(String FromUserName, String ToUserName,String content) {
        MessageText text = new MessageText();
        text.setFromUserName(ToUserName);
        text.setToUserName(FromUserName);
        text.setMsgType(MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        //text.setContent(content);
        //return  messageToxml(text);
        return messageToxml(text);
    }
    /**
     * 主菜单
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照提示进行操作:\n\n");
        sb.append("1.天鹅快递介绍\n");
        sb.append("2.天鹅查询系统介绍\n");
        sb.append("回复？调出此菜单");
        return sb.toString();
    }

    public static String firstMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("天鹅快递是一家快运");
        return sb.toString();
    }

//    public static String secondMenu(){
//        StringBuffer sb = new StringBuffer();
//        sb.append()
//    }

    //图片消息
    public static String initNewsMessage(String toUserName,String fromUserName){
        String message = null;
        List<News> newsList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();
        News news = new News();
        news.setTitle("天鹅快递");
        news.setDescription("承运货物以IT电子产品及服装为主，网络覆盖上海及江苏省内绝大多数县级区域，" +
                "并延伸至浙江、安徽大部分市县。公司实行班车化运营，干线班车全部为全封闭厢式货车。");
        news.setPicUrl("http://not.natapp1.cc/weixin/img/tianekuaidi.jpg");
        news.setUrl("http://www.chinawutong.com/co/cowuliupt_01/index.aspx?id=1309155");
        newsList.add(news);

        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType("news");
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());

        message = newsMessageToXml(newsMessage);
        return message;
    }
}
