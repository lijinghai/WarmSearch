package priv.ljh.operate.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.operate.entity.Log;
import priv.ljh.operate.mapper.LogMapper;
import priv.ljh.operate.service.LogService;
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
@RequestMapping("/log")
@Api(tags = {"日志信息控制类"})
public class LogController {
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private LogService logService;

    @ApiOperation("根据id删除一条用户数据")
    @PostMapping("/delete")
    public ResultResponse deleteUser (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = logMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("查询所有用户数据")
    @GetMapping
    public ResultResponse queryEmployee(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Log> logs= logMapper.selectList(null);
        log.info("users====>"+logs);
        MyPage page = this.logService.searchlogs(pageNo, limit, idSort,logs);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

}

