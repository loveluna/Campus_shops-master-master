package cn.edu.xsyu.campus.project.service;

import cn.edu.xsyu.campus.project.entity.UserInfo;
import cn.edu.xsyu.campus.project.entity.chat.Friends;
import cn.edu.xsyu.campus.project.mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FriendsService {
    @Autowired
    FriendsMapper friendsMapper;

    /**
     * 添加好友
     */
    public void insertFriend(Friends friends) {
        friendsMapper.insertFriend (friends);
    }

    /**
     * 判断双方是否是好友
     */
    public Integer JustTwoUserIsFriend(Friends friends) {
        return friendsMapper.JustTwoUserIsFriend (friends);
    }

    /**
     * 查询用户的好友列表
     */
    public List<UserInfo> LookUserFriend(String userid) {
        return friendsMapper.LookUserFriend (userid);
    }

    /**
     * 查询用户的信息
     */
    public UserInfo LookUserMine(String userid) {
        return friendsMapper.LookUserMine (userid);
    }
}
