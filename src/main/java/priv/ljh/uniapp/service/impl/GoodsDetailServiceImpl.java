package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.GoodsDetail;
import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.uniapp.mapper.GoodsDetailMapper;
import priv.ljh.uniapp.service.GoodsDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物品详情页信息 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-20
 */
@Service
public class GoodsDetailServiceImpl extends ServiceImpl<GoodsDetailMapper, GoodsDetail> implements GoodsDetailService {

    @Override
    public MyPage searchGoodsDetail(int pageNo, int limit, String idSorted, List<Map> goodsDetails) {
        MyPage page = null;
        List<Map> goodsDetailsList = new ArrayList<>();
        goodsDetailsList.addAll(goodsDetails);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(goodsDetailsList);
        }
        int total = goodsDetailsList.size();
        int maxPageNo = goodsDetailsList.size()%limit == 0? goodsDetailsList.size()/limit:goodsDetailsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(goodsDetailsList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchGoodsDetail1(int pageNo, int limit, String idSorted, List<GoodsDetail> goodsDetails) {
        MyPage page = null;
        List<GoodsDetail> goodsDetailsList = new ArrayList<>();
        goodsDetailsList.addAll(goodsDetails);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(goodsDetailsList);
        }
        int total = goodsDetailsList.size();
        int maxPageNo = goodsDetailsList.size()%limit == 0? goodsDetailsList.size()/limit:goodsDetailsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(goodsDetailsList.subList(beginIndex, endIndex), total);

        return page;
    }
}
