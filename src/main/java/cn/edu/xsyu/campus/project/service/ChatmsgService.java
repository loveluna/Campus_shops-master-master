package cn.edu.xsyu.campus.project.service;

import cn.edu.xsyu.campus.project.entity.UserInfo;
import cn.edu.xsyu.campus.project.entity.chat.ChatMsg;
import cn.edu.xsyu.campus.project.mapper.ChatmsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatmsgService {
    @Autowired
    ChatmsgMapper chatmsgMapper;

    /**插入发送的消息记录*/
    @Async
    public void insertChatmsg(ChatMsg chatmsg){
        chatmsgMapper.insertChatmsg(chatmsg);
    }

    /**查询聊天记录*/
    public List<UserInfo> LookChatMsg(ChatMsg chatMsg){
        return chatmsgMapper.LookChatMsg(chatMsg);
    }
}
