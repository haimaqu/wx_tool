package com.imooc.wx_tool;

import com.imooc.wx_tool.constants.MenuKey;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxMenu;
import com.soecode.wxtools.exception.WxErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        //初始化统一API调用入口
        IService iService = new WxService();
        WxMenu menu = new WxMenu();
        List<WxMenu.WxMenuButton> btnList = new ArrayList<>();

        //增加功能
        WxMenu.WxMenuButton btn1 = new WxMenu.WxMenuButton();
        btn1.setName("分类");
        List<WxMenu.WxMenuButton> subList = new ArrayList<>();
        WxMenu.WxMenuButton btn1_1 = new WxMenu.WxMenuButton();
        btn1_1.setType(WxConsts.MENU_BUTTON_CLICK);
        btn1_1.setKey(MenuKey.HOT_SONG);
        btn1_1.setName("上升榜");

        WxMenu.WxMenuButton btn1_2 = new WxMenu.WxMenuButton();
        btn1_2.setType(WxConsts.MENU_BUTTON_CLICK);
        btn1_2.setKey(MenuKey.TOP_500);
        btn1_2.setName("最火歌曲");

        WxMenu.WxMenuButton btn1_3 = new WxMenu.WxMenuButton();
        btn1_3.setType(WxConsts.MENU_BUTTON_CLICK);
        btn1_3.setKey(MenuKey.NET_HOT_SONG);
        btn1_3.setName("网络红歌");

        WxMenu.WxMenuButton btn1_4 = new WxMenu.WxMenuButton();
        btn1_4.setType(WxConsts.MENU_BUTTON_CLICK);
        btn1_4.setKey(MenuKey.HUAYU_SONG);
        btn1_4.setName("最新歌曲");

        WxMenu.WxMenuButton btn1_5 = new WxMenu.WxMenuButton();
        btn1_5.setType(WxConsts.MENU_BUTTON_VIEW);
        btn1_5.setKey(MenuKey.KUAIDI_CHAXUN);
        btn1_5.setUrl("http://not.natapp1.cc/lists");
        btn1_5.setName("快递查询");
       // http://not.natapp1.cc/weixin/list

        //微信最多只有5个二级菜单
        WxMenu.WxMenuButton btn1_6 = new WxMenu.WxMenuButton();
        btn1_6.setType(WxConsts.MENU_BUTTON_VIEW);
        btn1_6.setKey(MenuKey.TINAE_KUAIADI);
//        btn1_6.setUrl("http://not.natapp1.cc/weixin");
        btn1_6.setUrl("http://not.natapp1.cc");
        btn1_6.setName("天鹅快递");

        subList.addAll(Arrays.asList(btn1_1,btn1_2,btn1_4,btn1_5,btn1_6));
        btn1.setSub_button(subList);

        WxMenu.WxMenuButton btn2 = new WxMenu.WxMenuButton();
        btn2.setName("主功能");
        List<WxMenu.WxMenuButton> subList2 = new ArrayList<>();
        //扫码
        WxMenu.WxMenuButton btn2_1 = new WxMenu.WxMenuButton();
        btn2_1.setType(WxConsts.MENU_SCANCODE_PUSH);
        btn2_1.setKey(MenuKey.SAO_MA);
        btn2_1.setName("微信扫码");

        //地理位置
        WxMenu.WxMenuButton btn2_2 = new WxMenu.WxMenuButton();
        btn2_2.setType(WxConsts.MENU_LOCATION_SELECT);
        btn2_2.setKey(MenuKey.DILI_WEIZHI);
        btn2_2.setName("地理位置");

        //下单
        WxMenu.WxMenuButton btn2_3 = new WxMenu.WxMenuButton();
        btn2_3.setType(WxConsts.MENU_BUTTON_VIEW);
//        btn2_3.setType(WxConsts.MENU_LOCATION_SELECT);
        btn2_3.setKey(MenuKey.XIA_DAN);
        btn2_3.setUrl("http://not.natapp1.cc/xiadan");
        btn2_3.setName("一键下单");


        subList2.addAll(Arrays.asList(btn2_1,btn2_2,btn2_3));
        btn2.setSub_button(subList2);
///////////////////////
        WxMenu.WxMenuButton btn3 = new WxMenu.WxMenuButton();
        btn3.setName("我");
        List<WxMenu.WxMenuButton> subList3 = new ArrayList<>();

        WxMenu.WxMenuButton btn3_1 = new WxMenu.WxMenuButton();
        btn3_1.setType(WxConsts.MENU_BUTTON_VIEW);
        btn3_1.setKey(MenuKey.FUWU_CHAXUN);
        btn3_1.setUrl("http://not.natapp1.cc/fuwuchaxun");
        btn3_1.setName("服务查询");
        //地理位置
        WxMenu.WxMenuButton btn3_2 = new WxMenu.WxMenuButton();
        btn3_2.setType(WxConsts.MENU_BUTTON_VIEW);
        btn3_2.setKey(MenuKey.WODE_SHUNFENG);
        btn3_2.setUrl("http://not.natapp1.cc/wodeshunfeng");
        btn3_2.setName("我");


        WxMenu.WxMenuButton btn3_3 = new WxMenu.WxMenuButton();
        btn3_3.setType(WxConsts.MENU_BUTTON_VIEW);
        btn3_3.setKey(MenuKey.HUOQU_YONGHUXINXI);
        btn3_3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx53f704e68305cde5&redirect_uri=http://not.natapp1.cc/tologinuserinfo&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
//        btn3_3.setUrl("http://not.natapp1.cc/tologinuserinfo");
//        btn3_3.setUrl("http://not.natapp1.cc/wodeshunfeng");

        btn3_3.setName("我的快运");
        subList3.addAll(Arrays.asList(btn3_1,btn3_2,btn3_3));
        btn3.setSub_button(subList3);

////////////////////////////////
//        WxMenu.WxMenuButton btn33 = new WxMenu.WxMenuButton();
//        btn33.setType(WxConsts.MENU_BUTTON_CLICK);
//        btn33.setKey(MenuKey.HELP);
//        btn33.setName("我");


//
//        ViewButton viewButton = new ViewButton();
//        viewButton.setName("view菜单");
//        viewButton.setType("view");
//        //viewButton.setUrl("http://myjava.ngrok.xiaomiqiu.cn/tomainpage");
//        viewButton.setUrl(
//                "https://open.weixin.qq.com/connect/oauth2/authorize?appid=XXXXXX&redirect_uri=http://myjava.ngrok.xiaomiqiu.cn/tologin/userinfo&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");



        //将三个按钮设置进btnList
        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);

//        btnList.add(btn33);
        //设置进菜单类
        menu.setButton(btnList);
        //调用API即可
        try{
            //参数1--menu     ，参数2--是否是个性化定制，如果是个性化定制，需要设置MenuRule
            iService.createMenu(menu,false);
        }catch (WxErrorException e){
            e.printStackTrace();
        }


    }


}
