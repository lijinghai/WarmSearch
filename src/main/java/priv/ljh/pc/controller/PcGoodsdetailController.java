package priv.ljh.pc.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.pc.entity.PcGoodsdetail;
import priv.ljh.pc.entity.PcRecent;
import priv.ljh.pc.mapper.PcGoodsdetailMapper;
import priv.ljh.pc.service.PcGoodsdetailService;
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
 * PC端物品详情信息 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
@Api(tags = {"PC端物品详情信息控制类"})
@Slf4j
@RestController
@RequestMapping("/pcgoodsdetail")
public class PcGoodsdetailController {

    @Autowired
    private PcGoodsdetailMapper pcGoodsdetailMapper;
    @Autowired
    private PcGoodsdetailService pcGoodsdetailService;

    @ApiOperation("增加一条PC端物品详情信息")
    @PostMapping
    public ResultResponse create(PcGoodsdetail pcGoodsdetail, MultipartFile file, HttpServletRequest req){
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
            pcGoodsdetail.setUrl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        pcGoodsdetailMapper.insert(pcGoodsdetail);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcGoodsdetail);
        return res;
    }

    @ApiOperation("根据id删除一条PC端物品详情信息数据")
    @PostMapping("/delete")
    public ResultResponse deletePcGoodsdetail (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = pcGoodsdetailMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条PC端物品详情信息数据")
    @PutMapping
    public ResultResponse updatePcGoodsdetail(@RequestBody PcGoodsdetail pcGoodsdetail){
        ResultResponse res = null;
        pcGoodsdetailMapper.updateById(pcGoodsdetail);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcGoodsdetail);
        return res;
    }

    @ApiOperation("查询PC端物品详情信息")
    @GetMapping
    public ResultResponse queryPcGoodsdetail(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<PcGoodsdetail> pcGoodsdetails = pcGoodsdetailMapper.selectList(null);
        log.info("pcGoodsdetails====>"+pcGoodsdetails);
        MyPage page = this.pcGoodsdetailService.searchPcGoodsdetail(pageNo, limit, idSort,pcGoodsdetails);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
    @ApiOperation("查询所有PC端物品详情信息")
    @GetMapping("/all")
    public ResultResponse queryPcGoodsdetailAll(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> allGoods = pcGoodsdetailMapper.getAllGoods(id);
        log.info("allGoods====>"+allGoods);
        MyPage page = this.pcGoodsdetailService.searchPcGoodsDetail1(pageNo, limit, idSort,allGoods);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("查询所有PC端各种类物品详情信息")
    @GetMapping("/allkinds")
    public ResultResponse queryPcGoodsdetailAllkinds(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> allGoods = pcGoodsdetailMapper.getAllGoodsKinds(id);
        log.info("allGoods====>"+allGoods);
        MyPage page = this.pcGoodsdetailService.searchPcGoodsDetailKinds(pageNo, limit, idSort,allGoods);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据goodsID查询所有PC端各种类物品详情信息")
    @GetMapping("/goodsid")
    public ResultResponse queryPcGoodsId(@RequestParam("goodsId") Integer goodsId,@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> allGoods = pcGoodsdetailMapper.getAllGoodsId(id,goodsId);
        log.info("allGoods====>"+allGoods);
        MyPage page = this.pcGoodsdetailService.searchPcGoodsDetailKinds(pageNo, limit, idSort,allGoods);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

