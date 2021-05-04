package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.pc.entity.PcGoodsdetail;
import priv.ljh.uniapp.entity.GoodsDetail;
import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.uniapp.mapper.GoodsDetailMapper;
import priv.ljh.uniapp.service.GoodsDetailService;
import priv.ljh.uniapp.service.GoodsfirstService;
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
 * 物品详情页信息 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-20
 */
@Api(tags = {"物品详情页信息控制类"})
@Slf4j
@RestController
@RequestMapping("/goodsdetail")
public class GoodsDetailController {

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @Autowired
    private GoodsDetailService goodsDetailService;

    @ApiOperation("增加一条信息")
    @PostMapping("/all")
    public ResultResponse create(@RequestBody GoodsDetail goodsDetail){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        goodsDetailMapper.insert(goodsDetail);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, goodsDetail);
        return res;
    }

    @ApiOperation("增加一条物品详情页信息信息")
    @PostMapping
    public ResultResponse createGoodsDetail(GoodsDetail goodsDetail, MultipartFile file, HttpServletRequest req){
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
            goodsDetail.setDImgurl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }

        goodsDetailMapper.insert(goodsDetail);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, goodsDetail);
        return res;
    }

    @ApiOperation("根据id删除一条物品详情页信息数据")
    @PostMapping("/delete")
    public ResultResponse deleteGoodsDetail (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = goodsDetailMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条物品详情页信息数据")
    @PutMapping
    public ResultResponse updateGoodsDetail (@RequestBody GoodsDetail goodsDetail){
        ResultResponse res = null;
        goodsDetailMapper.updateById(goodsDetail);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, goodsDetail);
        return res;
    }

    @ApiOperation("查询所有展示的物品信息信息")
    @GetMapping
    public ResultResponse queryGoodsDetail(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
//        List<GoodsDetail> goodsDetails = goodsDetailMapper.selectList(null);
        List<Map> allGoods = goodsDetailMapper.getAllGoods(id);
//        log.info("goodsDetails====>"+goodsDetails);
        log.info("allGoods====>"+allGoods);
//        MyPage page = this.goodsDetailService.searchGoodsDetail(pageNo, limit, idSort,goodsDetails);
        MyPage page = this.goodsDetailService.searchGoodsDetail(pageNo, limit, idSort,allGoods);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("查询展示的物品信息信息")
    @GetMapping("/all")
    public ResultResponse queryGoodsDetail1(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<GoodsDetail> goodsDetails = goodsDetailMapper.selectList(null);
        log.info("goodsDetails====>"+goodsDetails);
        MyPage page = this.goodsDetailService.searchGoodsDetail1(pageNo, limit, idSort,goodsDetails);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

