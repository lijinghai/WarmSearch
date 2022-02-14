package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.uniapp.entity.SUser;
import priv.ljh.uniapp.mapper.SUserMapper;
import priv.ljh.uniapp.service.SUserService;
import priv.ljh.utils.MyJWT.PCJwtUtils;
import priv.ljh.utils.requestMessage.Constants;
import priv.ljh.utils.requestMessage.MyPage;
import priv.ljh.utils.requestMessage.ResultResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2022-02-13
 */
@Api(tags = {"uniapp端用户控制类"})
@Slf4j
@RestController
@RequestMapping("/suser")
public class SUserController {

    @Autowired
    private SUserService sUserService;

    @Autowired
    private SUserMapper sUserMapper;


    @ApiOperation("用户登录,用户登录时的第一道关卡")
    @PostMapping("/login")
    public ResultResponse login(@RequestBody SUser user, HttpServletRequest request){
        log.info("用户名:"+user.getUsername());
        log.info("密码:"+user.getPassword());
        log.info("密码:"+user.getSex());
        log.info("密码:"+user.getAvatar());
        log.info("密码:"+user.getName());
        log.info("密码:"+user.getId());


        ResultResponse res = null;
        Map<String,Object> map = new HashMap<>();
        try {
            SUser userDB = sUserService.login(user);
            if(userDB != null){
                Map<String,String> playload = new HashMap<>();
                playload.put("userName",userDB.getUsername());
                playload.put("roles",userDB.getRoles());
                playload.put("avatar",userDB.getAvatar());
                playload.put("introduction",userDB.getIntroduction());
                playload.put("password", user.getPassword());
                playload.put("sex",userDB.getSex());
                playload.put("email",userDB.getEmail());
                playload.put("name",userDB.getName());


                //生成JWT令牌机制
                String token = PCJwtUtils.getToken(playload);
                map.put("token",token);
                log.info("token:"+token);


                //设置ServletContext

                ServletContext context= request.getServletContext();

                context.setAttribute("id",userDB.getId());

                // 获取 用户id
                context.getAttribute("id");

                log.info("user id======>"+ context.getAttribute("id"));

                res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, map);
            }else {
                res = new ResultResponse(Constants.STATUS_FALL, "账号或密码错误", "");
            }

        } catch (Exception e) {
            map.put("message",e.getMessage());
            res = new ResultResponse(Constants.STATUS_FALL, "账号或密码错误", "");
        }
        return res;
    }


    @ApiOperation("管理员登录第二道关卡")
    @GetMapping("/info")
    public ResultResponse infor(@RequestParam("token") String token, HttpServletRequest request) {
        ResultResponse res = new ResultResponse();
        //验证Token的合法性
        String tokenValue = request.getHeader("Authorization");
        DecodedJWT verify = PCJwtUtils.verify(token);
        //封装用户信息
        SUser info = new SUser();

        if(verify != null) {

            //如果ok,返回需要的用户信息
            //从token中拿出id

            //设置ServletContext获取user_id
            ServletContext context= request.getServletContext();
            int id = (int)context.getAttribute("id");

            String user_id = verify.getClaim("id").asString();
            info.setId(id);
            log.info("从token中拿出id====>"+id);

            //从token中拿出用户名username
            String userName = verify.getClaim("userName").asString();
            info.setUsername(userName);
            log.info("从token中拿出用户名userName====>"+userName);

            //从token中拿出密码password
            String password = verify.getClaim("password").asString();
            info.setPassword(password);
            log.info("从token中拿出用户名password====>"+password);

            //从token中拿出角色role
            String role = verify.getClaim("roles").asString();
            info.setRoles(role);
            log.info("从token中拿出角色role====>"+role);

            //从token中拿出图标avatar
            String avatar = verify.getClaim("avatar").asString();
            info.setAvatar(avatar);
            log.info("从token中拿出用户名avatar====>"+avatar);

            //从token中拿出介绍introducation
            String introduction = verify.getClaim("introduction").asString();
            info.setIntroduction(introduction);
            log.info("从token中拿出用户名introducation====>"+introduction);

            //从token中拿出性别
            String sex = verify.getClaim("sex").asString();
            info.setSex(String.valueOf(Integer.valueOf(sex)));
            log.info("从token中拿出性别sex====>"+sex);

            //从token中拿出邮箱emial
            String email = verify.getClaim("email").asString();
            info.setEmail(email);
            log.info("从token中拿出邮箱email====>"+email);

            //从token中拿出姓名name
            String name = verify.getClaim("name").asString();
            info.setName(name);
            log.info("从token中拿出姓名name====>"+name);


//            info.setAvatar("https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/custom/tuxiang.jpg");
//            info.setId(info.getId());
//            info.setUsername(name);
//            info.setIntroduction("测试用户");
//            info.setName(name);
//            List<String> roles = Arrays.asList("admin");
//            info.setRoles(roles);
//            res.setData(info);

            res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, info);
        }else {
            //否则：500
            res = new ResultResponse(Constants.STATUS_FALL, Constants.MESSAGE_FALL, info);
        }

        return res;
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public ResultResponse logout(@RequestHeader("X-Token") String token,HttpServletRequest request){
        ResultResponse res = new ResultResponse();
        // 验证token的合法和有效性
        String tokenValue = request.getHeader("Authorization");
        DecodedJWT verify = PCJwtUtils.verify(token);

        // 获取token中的用户名
        String username = verify.getClaim("name").asString();

        // 移除session中的登录标记（或者redis中的登录标记）
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, "退出成功");
        return res;
    }



    @ApiOperation("增加一条用户信息")
    @PostMapping("/add")
    public ResultResponse create(@RequestBody SUser user){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        sUserMapper.insert(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }


    @ApiOperation("根据id删除一条用户数据")
    @PostMapping("/delete")
    public ResultResponse deleteUser (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = sUserMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条用户数据")
    @PutMapping
    public ResultResponse updateUser(@RequestBody SUser user){
        ResultResponse res = null;
        sUserMapper.updateById(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }


    @ApiOperation("查询所有用户数据")
    @GetMapping
    public ResultResponse queryEmployee(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<SUser > users = sUserMapper.selectList(null);
        log.info("users====>"+users);
        MyPage page = this.sUserService.searchPcUser(pageNo, limit, idSort,users);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryUreteralDataById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = sUserMapper.selectById(id);
        log.info("info====>"+info);
        MyPage page = this.sUserService.searchById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

