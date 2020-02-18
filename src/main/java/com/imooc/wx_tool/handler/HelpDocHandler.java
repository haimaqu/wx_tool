package com.imooc.wx_tool.handler;

import com.imooc.wx_tool.constants.ResponseConst;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import java.util.Map;

public class HelpDocHandler implements WxMessageHandler {

    private static HelpDocHandler instance = null;
    private boolean isRun = false;

    public HelpDocHandler() {
    }

    public static synchronized HelpDocHandler getInstance(){
        if(instance == null){
            new HelpDocHandler();
        }
        return instance;
    }
    public synchronized boolean getIsRun() {
        return isRun;
    }

    public synchronized void setRun(boolean run) {
        isRun = run;
    }

    private WxXmlOutMessage execute(WxXmlMessage wxXmlMessage){
        return WxXmlOutMessage.TEXT().content(ResponseConst.HELP).toUser(wxXmlMessage.getFromUserName()).fromUser(wxXmlMessage.getToUserName()).build();
    }
    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxXmlMessage, Map<String, Object> map, IService iService) throws WxErrorException {

        WxXmlOutMessage response = null;
        if (!getIsRun()){
            setRun(true);
            response = execute(wxXmlMessage);
            setRun(false);
        }

        return response;
    }
}
