package priv.ljh.operate.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.operate.entity.AdminUser;
import priv.ljh.operate.entity.AdminUserInfo;
import priv.ljh.operate.service.AdminUserService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.JwtUtil;
import priv.ljh.utils.MyToken;
import priv.ljh.utils.ResultResponse;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-26
 */
@Api(tags = {"管理员控制类"})
@RestController
@RequestMapping("/user")
@Slf4j
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation("管理员登录验证第一道关卡")
    @PostMapping("/login")
    public ResultResponse login(@RequestBody AdminUser adminUser){
        ResultResponse rs = new ResultResponse();

        //调用service完成username,和password的验证
        try {
            log.info("request adminUser=======>:"+ adminUser);
         AdminUser au = this.adminUserService.verify(adminUser);
            log.info("verfiy result======>:" + au);
            //根据验证结果，组成响应对象返回
            if(au != null){

                //创建一个token数据，封装到re中
                String token = JwtUtil.sign(adminUser.getUsername(), "-1");
                rs.setCode(Constants.STATUS_OK);
                rs.setMessage(Constants.MESSAGE_OK);
                rs.setData(new MyToken(token));
            }else {
                rs.setCode(Constants.STATUS_FALL);
                rs.setMessage(Constants.MESSAGE_FALL+"用户名和密码不匹配");
                rs.setData("fail");
            }
        } catch (Exception e){
            rs.setCode(Constants.STATUS_FALL);
            rs.setMessage(Constants.MESSAGE_FALL+e.getMessage());
            rs.setData("fail");
            e.printStackTrace();
        }
        return rs;
    }

    @ApiOperation("管理员登录第二道关卡")
    @GetMapping("/info")
    public ResultResponse infor(@RequestParam("token") String token){
        ResultResponse res = new ResultResponse();
        //验证token的合法性
        String tokenValue = JwtUtil.verity(token);
        if(tokenValue != null && tokenValue.startsWith(JwtUtil.TOKEN_SUCCESS)) {
            //如果ok,返回需要的用户信息
            //从token中拿出用户名
            String name = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS,"");
            /*AdminUser adminUser = this.adminUserService.searchUserByUserName(name);*/
            //封装用户信息
            AdminUserInfo info = new AdminUserInfo();
            info.setAvatar("https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/custom/tuxiang.jpg");
//            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            info.setIntroduction("测试用户");
            info.setName(name);
            List<String> roles = Arrays.asList("admin");
            info.setRoles(roles);

            res.setData(info);
            res.setCode(Constants.STATUS_OK);
            res.setMessage(Constants.MESSAGE_OK);
        }else {
            //否则：500
            res.setCode(Constants.STATUS_FALL);
            res.setMessage(Constants.MESSAGE_FALL);
        }

        return res;
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public ResultResponse logout(@RequestHeader("X-Token") String token){
        ResultResponse res = new ResultResponse();
        // 验证token的合法和有效性
        // success: username
        String tokenValue = JwtUtil.verity(token);
        // 获取token中的用户名
        String username = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS, "");
        // 移除session中的登录标记（或者redis中的登录标记）
        res.setMessage("logout success");
        res.setData("logout success");
        res.setCode(Constants.STATUS_OK);
        return res;
    }
}

