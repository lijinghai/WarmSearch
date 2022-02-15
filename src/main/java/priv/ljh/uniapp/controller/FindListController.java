package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.pc.entity.PcGoodsdetail;
import priv.ljh.uniapp.entity.FindList;
import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.uniapp.entity.SFind;
import priv.ljh.uniapp.mapper.FindListMapper;
import priv.ljh.uniapp.service.FindListService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 待招领物品详情表 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
@Api(tags = {"待招领物品详情表信息控制类"})
@Slf4j
@RestController
@RequestMapping("/findlist")
public class FindListController {

    @Autowired
    private FindListMapper findListMapper;

    @Autowired
    private FindListService findListService;
    @ApiOperation("增加一条信息")
    @PostMapping("/all")
    public ResultResponse create(@RequestBody FindList findList){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        findListMapper.insert(findList);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, findList);
        return res;
    }

    @ApiOperation("增加一条待招领物品详情表信息")
    @PostMapping
    public ResultResponse create(FindList findList, MultipartFile file, HttpServletRequest req){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);

        Map<String, Object> result = new HashMap<>();
        String originalName = file.getOriginalFilename();
        if(!originalName.endsWith(".png")) {
            result.put("status","error");
            result.put("msg","文件类型不对");
        }else if(!originalName.endsWith(".jpg")) {
            result.put("status","error");
            result.put("msg","文件类型不对");
        }
        String realPath = "D:\\serach\\";
        File folder = new File(realPath);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        String newName = UUID.randomUUID().toString() + ".jpg";
        try {
            file.transferTo(new File(folder,newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + newName;
            result.put("status","success");
            result.put("url",url);

            //将图片地址存入数据库
            findList.setFlImgurl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        findListMapper.insert(findList);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, findList);
        return res;
    }

    @ApiOperation("根据id删除一条首页展示的物品信息数据")
    @PostMapping("/delete")
    public ResultResponse deleteFindList(@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = findListMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条首页展示的物品信息数据")
    @PutMapping
    public ResultResponse updateFindList(@RequestBody FindList findList){
        ResultResponse res = null;
        findListMapper.updateById(findList);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, findList);
        return res;
    }

    @ApiOperation("查询所有首页展示的物品信息信息")
    @GetMapping
    public ResultResponse queryFindList(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<FindList> findLists = findListMapper.selectList(null);
        log.info("findLists====>"+findLists);
        MyPage page = this.findListService.searchFindList(pageNo, limit, idSort,findLists);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public priv.ljh.utils.requestMessage.ResultResponse queryUreteralDataById(@RequestParam("id") Integer id, @RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        priv.ljh.utils.requestMessage.ResultResponse res = null;
        List<Map> info = findListMapper.selectById(id);
        log.info("info====>"+info);
        priv.ljh.utils.requestMessage.MyPage page = this.findListService.searchById(pageNo, limit, idSort,info);
        res = new priv.ljh.utils.requestMessage.ResultResponse(priv.ljh.utils.requestMessage.Constants.STATUS_OK, priv.ljh.utils.requestMessage.Constants.MESSAGE_OK,page);
        return res;
    }
}

