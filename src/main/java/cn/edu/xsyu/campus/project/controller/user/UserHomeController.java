package cn.edu.xsyu.campus.project.controller.user;

import cn.edu.xsyu.campus.project.entity.Commodity;
import cn.edu.xsyu.campus.project.entity.UserInfo;
import cn.edu.xsyu.campus.project.service.CommodityService;
import cn.edu.xsyu.campus.project.service.UserInfoService;
import cn.edu.xsyu.campus.project.util.StatusCode;
import cn.edu.xsyu.campus.project.vo.LayuiPageVo;
import cn.edu.xsyu.campus.project.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: hlt
 * @Description: 个人主页
 * @Date: 2020/2/23 18:07
 */
@Controller
public class UserHomeController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private CommodityService commodityService;

    /**
     * 个人简介
     * 前端传入用户id（userid）
     */
    @ResponseBody
    @GetMapping("/user/userinfo/{userid}")
    public ResultVo userinfo(@PathVariable("userid") String userid) {
        UserInfo userInfo = userInfoService.LookUserinfo(userid);
        if (!StringUtils.isEmpty(userInfo)){
            return new ResultVo(true, StatusCode.OK, "查询成功",userInfo);
        }
        return new ResultVo(false, StatusCode.ERROR, "查询失败");
    }

    /**
     * 分页展示个人已审核的商品信息（状态码：1）
     *前端传入用户id（userid）、当前页码（nowPaging）、
     */
    @ResponseBody
    @GetMapping("/user/usercommodity/{userid}")
    public LayuiPageVo userHomeCommodity(@PathVariable("userid") String userid, int limit, int page) {
        List<Commodity> commodityList = commodityService.queryAllCommodity((page - 1) * limit, limit, userid,1);
        Integer dataNumber = commodityService.queryCommodityCount(userid,1);
        return new LayuiPageVo("", 0,dataNumber,commodityList);
    }

}
