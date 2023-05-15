package cn.edu.xsyu.campus.project.mapper;


import cn.edu.xsyu.campus.project.entity.UserInfo;
import cn.edu.xsyu.campus.project.entity.chat.ChatMsg;

import java.util.List;


public interface ChatmsgMapper {
    /**插入发送的消息记录*/
    void insertChatmsg(ChatMsg chatmsg);
    /**查询聊天记录*/
    List<UserInfo> LookChatMsg(ChatMsg chatMsg);
}