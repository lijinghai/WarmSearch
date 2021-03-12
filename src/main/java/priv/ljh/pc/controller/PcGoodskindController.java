package priv.ljh.pc.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.operate.entity.User;
import priv.ljh.pc.entity.PcGoodskind;
import priv.ljh.pc.mapper.PcGoodskindMapper;
import priv.ljh.pc.service.PcGoodskindService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;

/**
 * <p>
 *  PC端物品种类信息
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-12
 */
@Api(tags = {"PC端物品种类信息控制类"})
@Slf4j
@RestController
@RequestMapping("/pcgoodskind")
public class PcGoodskindController {
    @Autowired
    private PcGoodskindMapper pcGoodskindMapper;

    @Autowired
    private PcGoodskindService pcGoodskindService;

    @ApiOperation("增加一条PC端物品种类信息")
    @PostMapping
    public ResultResponse create(@RequestBody PcGoodskind pcGoodskind){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        pcGoodskindMapper.insert(pcGoodskind);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcGoodskind);
        return res;
    }


    @ApiOperation("根据id删除一条PC端物品种类信息")
    @PostMapping("/delete")
    public ResultResponse deletePcGoodskind (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = pcGoodskindMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条PC端物品种类信息")
    @PutMapping
    public ResultResponse updatePcGoodskind(@RequestBody PcGoodskind pcGoodskind){
        ResultResponse res = null;
        pcGoodskindMapper.updateById(pcGoodskind);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcGoodskind);
        return res;
    }


    @ApiOperation("查询所有PC端物品种类信息")
    @GetMapping
    public ResultResponse queryPcGoodskind(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<PcGoodskind> pcGoodskind = pcGoodskindMapper.selectList(null);
        log.info("pcGoodskind====>"+pcGoodskind);
        MyPage page = this.pcGoodskindService.searchKinds(pageNo, limit, idSort,pcGoodskind);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }


}

