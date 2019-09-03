package com.wechat.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.wechat.config.PublicConfig;
import com.wechat.pojo.UserChatLog;
import com.wechat.pojo.UserInfo;
import com.wechat.service.WechatService;

@Service
public class WechatServiceImpl implements WechatService{
	private static Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);
	@Value("${wechat.local.url}")
	private String wechatUrl;
	
	@Autowired
    private RestTemplate restTemplate;
	
	 /**
	  * <p>功能描述:查找用户。</p>	
	  * @param keyword
	  * @return
	  * @since JDK1.8。
	  * <p>创建日期Sep 3, 2019 10:26:07 AM。</p>
	  * <p>更新日期:[日期YYYY-MM-DD][Steven][变更描述]。</p>
	  */
	@Override
	public List<UserInfo> getUserInfo(String keyword) {
		String url = wechatUrl+PublicConfig.UserInfo.USER_INFO;
		if(!StringUtils.isEmpty(keyword)) {
			url += "?keyword=" + keyword;
		}
		UserInfo[] users = restTemplate.getForObject(url, UserInfo[].class);
		List<UserInfo> userList = Arrays.asList(users);
		return userList;
	}

	 /**
	  * <p>功能描述:根据用户id获取最近聊天记录。</p>	
	  * @param userId
	  * @param count
	  * @return
	  * @since JDK1.8。
	  * <p>创建日期Sep 3, 2019 11:20:13 AM。</p>
	  * <p>更新日期:[日期YYYY-MM-DD][Steven][变更描述]。</p>
	  */
	@Override
	public List<UserChatLog> getChatLogInfo(String userId, String count) {
		String url = wechatUrl+PublicConfig.UserInfo.USER_CHAT_LOG;
		
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isEmpty(userId)) {
			return null;
		}else {
			sb.append("userId="+userId);
		}
		if(!StringUtils.isEmpty(count)) {
			sb.append("&count="+count);
		}
		url+="?"+sb.toString();
		UserChatLog[] userChatLog = restTemplate.getForObject(url, UserChatLog[].class);
		List<UserChatLog> userChatLogList = Arrays.asList(userChatLog);
		return userChatLogList;
	}

	 /**
	  * <p>功能描述:发送短信消息。</p>	
	  * @param userId
	  * @param content
	  * @return
	  * @since JDK1.8。
	  * <p>创建日期Sep 3, 2019 11:23:45 AM。</p>
	  * <p>更新日期:[日期YYYY-MM-DD][Steven][变更描述]。</p>
	  */
	@Override
	public boolean sendMessage(String userId, String content) {
		String url = wechatUrl+PublicConfig.UserInfo.SEND_MESSAGE;
		if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(content)) {
			return false;
		}
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		postParameters.add("userId", userId);
		postParameters.add("content", content);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters, headers);
		String responseMessage = restTemplate.postForObject(url, r, String.class);
		return true;
	}

}
