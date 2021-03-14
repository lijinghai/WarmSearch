package priv.ljh.pc.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.operate.entity.User;
import priv.ljh.pc.entity.PcUser;
import priv.ljh.pc.mapper.PcUserMapper;
import priv.ljh.pc.service.PcUserService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.PCJwtUtils;
import priv.ljh.utils.ResultResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端用户信息 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-14
 */
@Api(tags = {"PC端用户控制类"})
@Slf4j
@RestController
@RequestMapping("/pcuser")
public class PcUserController {

    @Autowired
    private PcUserService pcUserService;

    @Autowired
    private PcUserMapper pcUserMapper;

    @ApiOperation("用户登录")
    @GetMapping("/login")
    public Map<String,Object> login(PcUser user){
        log.info("用户名:"+user.getUsername());
        log.info("密码:"+user.getPassword());

        Map<String,Object> map = new HashMap<>();
        try {
            PcUser userDB = pcUserService.login(user);
            Map<String,String> playload = new HashMap<>();
//            playload.put("id",userDB.getId());
            playload.put("name",userDB.getUsername());

            //生成JWT令牌机制
            String token = PCJwtUtils.getToken(playload);
            map.put("state",true);
            map.put("msg","登录成功");
            map.put("token",token);
        } catch (Exception e) {
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @ApiOperation("增加一条用户信息")
    @PostMapping("/add")
    public ResultResponse create(@RequestBody PcUser user){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        pcUserMapper.insert(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }


    @ApiOperation("根据id删除一条用户数据")
    @PostMapping("/delete")
    public ResultResponse deleteUser (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = pcUserMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条用户数据")
    @PutMapping
    public ResultResponse updateUser(@RequestBody PcUser user){
        ResultResponse res = null;
        pcUserMapper.updateById(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }


    @ApiOperation("查询所有用户数据")
    @GetMapping
    public ResultResponse queryEmployee(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<PcUser > users = pcUserMapper.selectList(null);
        log.info("users====>"+users);
        MyPage page = this.pcUserService.searchPcUser(pageNo, limit, idSort,users);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

}

