package priv.ljh.operate.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.operate.entity.Electronic;
import priv.ljh.operate.mapper.ElectronicMapper;
import priv.ljh.operate.service.ElectronicService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;
import priv.ljh.utils.uploadFile.UploadFileService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-29
 */
@Api(tags = {"电子信息控制类"})
@RestController
@RequestMapping("/electronic")
@Slf4j
public class ElectronicController {

    @Autowired
    private ElectronicMapper electronicMapper;
    @Autowired
    private ElectronicService electronicService;

    @ApiOperation("增加一条用户信息")
    @PostMapping
    public ResultResponse create(@RequestBody Electronic electronic){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        electronicMapper.insert(electronic);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, electronic);
        return res;
    }


    @ApiOperation("根据id删除一条用户数据")
    @PostMapping("/delete")
    public ResultResponse deleteUser (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = electronicMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条用户数据")
    @PutMapping
    public ResultResponse updateUser(@RequestBody Electronic electronic){
        ResultResponse res = null;
        electronicMapper.updateById(electronic);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, electronic);
        return res;
    }


    @ApiOperation("查询所有用户数据")
    @GetMapping
    public ResultResponse queryEmployee(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Electronic> electronic = electronicMapper.selectList(null);
        log.info("users====>"+electronic);
        MyPage page = this.electronicService.searchElectronic(pageNo, limit, idSort,electronic);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

}

