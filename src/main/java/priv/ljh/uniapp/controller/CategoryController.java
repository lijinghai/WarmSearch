package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.uniapp.entity.Category;
import priv.ljh.uniapp.mapper.CategoryMapper;
import priv.ljh.uniapp.mapper.GoodsDetailMapper;
import priv.ljh.uniapp.service.CategoryService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 寻物类别 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-22
 */
@Api(tags = {"寻物类别控制类"})
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @ApiOperation("增加一条寻物类别信息")
    @PostMapping
    public ResultResponse create(@RequestBody Category category){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        categoryMapper.insert(category);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, category);
        return res;
    }


    @ApiOperation("根据id删除一条寻物类别数据")
    @PostMapping("/delete")
    public ResultResponse deleteCategory (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = categoryMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条寻物类别数据")
    @PutMapping
    public ResultResponse updateCategory(@RequestBody Category category){
        ResultResponse res = null;
        categoryMapper.updateById(category);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, category);
        return res;
    }


    @ApiOperation("查询所有寻物类别右侧数据")
    @GetMapping
    public ResultResponse queryCategory(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> Allcategories = goodsDetailMapper.getAllGoods(id);
        log.info("categories====>"+Allcategories);
        MyPage page = this.categoryService.searchCategory(pageNo, limit, idSort,Allcategories);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @ApiOperation("查询所有寻物类别左侧数据")
    @GetMapping("/all")
    public ResultResponse queryCategory1(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Category> Allcategories1 = categoryMapper.selectList(null);
        log.info("categories====>"+Allcategories1);
        MyPage page = this.categoryService.searchAllCategory(pageNo, limit, idSort,Allcategories1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

}

