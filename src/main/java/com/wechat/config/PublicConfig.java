package com.wechat.config;
/**
 * 公共配置类
 */
public class PublicConfig {

    public class UserInfo {
    	//最近聊天列表 支持参数keyword
        public final static String USER_INFO = "/wechat-plugin/user";
        /// 根据指定用户id查询前几条数据 wechat-plugin/chatlog?userId=4804435999@chatroom&count=5
        public final static String USER_CHAT_LOG = "/wechat-plugin/chatlog";
        //指定UserId发送消息 post 方式 userId和content内容
        public final static String SEND_MESSAGE = "/wechat-plugin/send-message";
        
      //指定UserId发送消息 post 方式 userId和content内容
        public final static String OPEN_SESSION = "/wechat-plugin/open-session";
    }
}
