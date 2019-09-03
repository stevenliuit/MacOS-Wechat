package com.wechat.controller;

import java.net.URLDecoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.pojo.UserChatLog;
import com.wechat.pojo.UserInfo;
import com.wechat.service.WechatService;

@RestController
@RequestMapping("/")
public class WechatInfoController {
	private static Logger logger = LoggerFactory.getLogger(WechatInfoController.class);
	@Autowired
	private WechatService wechatService;
	
	 @GetMapping("users")
	 @ResponseBody
	 public List<UserInfo> getUserInfo(String keyword){
		 return wechatService.getUserInfo(keyword);
	 }
	 
	 @GetMapping("chatlog")
	 @ResponseBody
	 public List<UserChatLog> getChatLogInfo(String userId,String count){
		 return wechatService.getChatLogInfo(userId, count);
	 }
	 
	 @GetMapping("send")
	 @ResponseBody
	 public boolean sendContent(String userId,String content){
		 content = URLDecoder.decode(content);
		 logger.info("content:{}",content);
		 return wechatService.sendMessage(userId, content);
	 }
}
