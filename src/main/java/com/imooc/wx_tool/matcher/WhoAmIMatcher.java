package com.imooc.wx_tool.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.StringUtils;
/**
 * （消息匹配器）接口用于一些简单的匹配，可以自定义匹配逻辑，如格式验证。匹配成功则继续往下执行，否则不允许通过。
 */
public class WhoAmIMatcher implements WxMessageMatcher {

    @Override
    public boolean match(WxXmlMessage wxXmlMessage) {

        if (StringUtils.isNotEmpty(wxXmlMessage.getContent())){
            if (wxXmlMessage.getContent().equals("我是谁"))
            return true;
        }
        return false;
    }
}
