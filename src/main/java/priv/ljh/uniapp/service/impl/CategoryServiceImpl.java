package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.Category;
import priv.ljh.uniapp.mapper.CategoryMapper;
import priv.ljh.uniapp.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 寻物类别 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 显示详情页信息
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param categories
     * @return
     */
    @Override
    public MyPage searchCategory(int pageNo, int limit, String idSorted, List<Map> categories) {
        MyPage page = null;
        List<Map> categoriesList = new ArrayList<>();
        categoriesList.addAll(categories);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(categoriesList);
        }
        int total = categoriesList.size();
        int maxPageNo = categoriesList.size()%limit == 0? categoriesList.size()/limit:categoriesList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(categoriesList.subList(beginIndex, endIndex), total);

        return page;
    }

    /**
     * 显示首页信息
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param categories
     * @return
     */
    @Override
    public MyPage searchAllCategory(int pageNo, int limit, String idSorted, List<Category> categories) {
        MyPage page = null;
        List<Category> categoriesList = new ArrayList<>();
        categoriesList.addAll(categories);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(categoriesList);
        }
        int total = categoriesList.size();
        int maxPageNo = categoriesList.size()%limit == 0? categoriesList.size()/limit:categoriesList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(categoriesList.subList(beginIndex, endIndex), total);

        return page;
    }
}
