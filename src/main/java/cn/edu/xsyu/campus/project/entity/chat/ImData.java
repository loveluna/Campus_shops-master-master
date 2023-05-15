package cn.edu.xsyu.campus.project.entity.chat;

import cn.edu.xsyu.campus.project.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ImData {
    private UserInfo mine;
    private List<Friend> friend;
    private List<Groups> group;
}