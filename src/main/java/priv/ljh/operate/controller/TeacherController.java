package priv.ljh.operate.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.operate.entity.Teacher;
import priv.ljh.operate.entity.User;
import priv.ljh.operate.mapper.TeacherMapper;
import priv.ljh.operate.service.TeacherService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-29
 */
@Slf4j
@RestController
@RequestMapping("/teacher")
@Api(tags = {"老师信息控制类"})
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("增加一条用户信息")
    @PostMapping
    public ResultResponse create(@RequestBody Teacher teacher){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        teacherMapper.insert(teacher);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, teacher);
        return res;
    }


    @ApiOperation("根据id删除一条用户数据")
    @PostMapping("/delete")
    public ResultResponse deleteUser (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = teacherMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条用户数据")
    @PutMapping
    public ResultResponse updateUser(@RequestBody Teacher teacher){
        ResultResponse res = null;
        teacherMapper.updateById(teacher);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, teacher);
        return res;
    }


    @ApiOperation("查询所有用户数据")
    @GetMapping
    public ResultResponse queryEmployee(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Teacher> teachers = teacherMapper.selectList(null);
        log.info("users====>"+teachers);
        MyPage page = this.teacherService.searchTeachers(pageNo, limit, idSort,teachers);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }
}

