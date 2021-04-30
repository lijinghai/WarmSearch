package priv.ljh.pc.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.pc.entity.PcUrgent;
import priv.ljh.pc.mapper.PcUrgentMapper;
import priv.ljh.pc.service.PcUrgentService;
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
 * PC端急需物品 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
@Api(tags = {"PC端急需物品控制类"})
@Slf4j
@RestController
@RequestMapping("/pcurgent")
public class PcUrgentController {

    @Autowired
    private PcUrgentMapper pcUrgentMapper;

    @Autowired
    private PcUrgentService pcUrgentService;

    @ApiOperation("增加一条PC端急需物品信息")
    @PostMapping
    public ResultResponse create(PcUrgent pcUrgent, MultipartFile file, HttpServletRequest req){
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
            pcUrgent.setUrl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        pcUrgentMapper.insert(pcUrgent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcUrgent);
        return res;
    }

    @ApiOperation("根据id删除一条PC端急需物品数据")
    @PostMapping("/delete")
    public ResultResponse deletePcCarousel (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = pcUrgentMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条PC端急需物品数据")
    @PutMapping
    public ResultResponse updatePcCarousel(@RequestBody PcUrgent pcUrgent){
        ResultResponse res = null;
        pcUrgentMapper.updateById(pcUrgent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcUrgent);
        return res;
    }

    @ApiOperation("查询所有PC端急需物品信息")
    @GetMapping
    public ResultResponse queryPcCarousel(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<PcUrgent> pcUrgent = pcUrgentMapper.selectList(null);
        log.info("pcUrgent====>"+pcUrgent);
        MyPage page = this.pcUrgentService.searchPcUrgent(pageNo, limit, idSort,pcUrgent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据goodsid查询所有PC端急需物品信息")
    @GetMapping("/goodsid")
    public ResultResponse queryPcCarousel(@RequestParam("goodsId") Integer goodsId,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> pcUrgent = pcUrgentMapper.getUrgentId(goodsId);
        log.info("pcUrgent====>"+pcUrgent);
        MyPage page = this.pcUrgentService.searchPcUrgentId(pageNo, limit, idSort,pcUrgent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

}

