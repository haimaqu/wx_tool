//package com.imooc.wx_tool.news;
//
//import javax.servlet.http.HttpServlet;
//
//public class HandleWeiXinMessageServlet extends HttpServlet {
//
//    public static final Logger logger = LoggerFactory.getLogger(HandleWeiXinMessageServlet.class);
//    /**
//     * VersionUID
//     */
//    private static final long serialVersionUID = 1L;
//
//
//    /*
//     * URL验证
//     * (non-Javadoc)
//     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
//     */
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String signature = req.getParameter("signature");
//        String timestamp = req.getParameter("timestamp");
//        String nonce = req.getParameter("nonce");
//        String echostr = req.getParameter("echostr");
//        logger.info("echostr" + echostr);
//        PrintWriter out = resp.getWriter();
//        if(CheckUtils.checkSignature(signature, timestamp, nonce)){
//            out.write(echostr);
//        }
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter out = resp.getWriter();
//        try {
//            Map<String,String> map = MessageUtil.xmlToMap(req);
//            String toUserName = map.get("ToUserName");
//            String fromUserName = map.get("FromUserName");
//            String msgType = map.get("MsgType");
//            String content = map.get("Content");
//            //判断请求是否事件类型 event
//            if(MessageUtil.MESSAGE_EVENT.equals(msgType)){
//                String eventType = map.get("Event");
//                //若是关注事件  subscribe
//                if(MessageUtil.EVENT_SUB.equals(eventType)){
//                    String mycontent = MessageUtil.menuText();
//                    message = MessageUtil.initText(toUserName, fromUserName, mycontent);
//
//                }
//            }
//            out.print(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//            out.close();
//        }
//
//    }
//}
