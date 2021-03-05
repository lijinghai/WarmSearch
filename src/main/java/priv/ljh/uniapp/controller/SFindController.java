package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.uniapp.entity.SFind;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.uniapp.mapper.SFindMapper;
import priv.ljh.uniapp.service.SFindService;
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
 * 招领信息表 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
@Api(tags = {"招领信息表控制类"})
@Slf4j
@RestController
@RequestMapping("/sfind")
public class SFindController {

    @Autowired
    private SFindService sFindService;

    @Autowired
    private SFindMapper sFindMapper;

    @ApiOperation("增加一条招领信息表信息")
    @PostMapping
    public ResultResponse create(SFind sFind, MultipartFile file, HttpServletRequest req){
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
            sFind.setFImg(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        sFindMapper.insert(sFind);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, sFind);
        return res;
    }

    @ApiOperation("根据id删除一条招领信息表数据")
    @PostMapping("/delete")
    public ResultResponse deleteSFind (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = sFindMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条招领信息表数据")
    @PutMapping
    public ResultResponse updateSFind(@RequestBody SFind sFind){
        ResultResponse res = null;
        sFindMapper.updateById(sFind);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, sFind);
        return res;
    }

    @ApiOperation("查询所有首页招领信息表信息")
    @GetMapping("/all")
    public ResultResponse querySFind(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<SFind> sFinds = sFindMapper.selectList(null);
        log.info("sFinds====>"+sFinds);
        MyPage page = this.sFindService.searchSFind(pageNo, limit, idSort,sFinds);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("查询招领信息表详细数据")
    @GetMapping
    public ResultResponse queryCategory(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> sFind = sFindMapper.getAllSFind(id);
        log.info("sFind ====>"+sFind );
        MyPage page = this.sFindService.searchAllSFind(pageNo, limit, idSort,sFind);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

}

