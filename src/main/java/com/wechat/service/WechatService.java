package com.wechat.service;

import java.util.List;

import com.wechat.pojo.UserChatLog;
import com.wechat.pojo.UserInfo;

public interface WechatService {
	 /**
	  * <p>功能描述：根据关键词获取用户信息。</p>	
	  * @param keyword
	  * @return
	  * @since JDK1.8。
	  * <p>创建日期:Sep 3, 2019 11:12:01 AM。</p>
	  */
	List<UserInfo> getUserInfo(String keyword); 
	 /**
	  * <p>功能描述：查找用户最近聊天记录。</p>	
	  * @param userId 用户id 必填
	  * @param count 返回条数 非必填
	  * @return
	  * @since JDK1.8。
	  * <p>创建日期:Sep 3, 2019 11:12:19 AM。</p>
	  */
	List<UserChatLog> getChatLogInfo(String userId,String count);
	
	
	 /**
	  * <p>功能描述：发送消息。</p>	
	  * @param userId 用户id 必填
	  * @param content 发送消息内容
	  * @return
	  * @since JDK1.8。
	  * <p>创建日期:Sep 3, 2019 11:12:19 AM。</p>
	  */
	boolean sendMessage(String userId,String content);
}
