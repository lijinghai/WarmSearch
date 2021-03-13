package priv.ljh.pc.service.impl;

import priv.ljh.pc.entity.PcGoodsdetail;
import priv.ljh.pc.mapper.PcGoodsdetailMapper;
import priv.ljh.pc.service.PcGoodsdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.uniapp.entity.GoodsDetail;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端物品详情信息 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
@Service
public class PcGoodsdetailServiceImpl extends ServiceImpl<PcGoodsdetailMapper, PcGoodsdetail> implements PcGoodsdetailService {

    @Override
    public MyPage searchPcGoodsdetail(int pageNo, int limit, String idSorted, List<PcGoodsdetail> pcGoodsdetails) {
        MyPage page = null;
        List<PcGoodsdetail> pcGoodsdetailsList = new ArrayList<>();
        pcGoodsdetailsList.addAll(pcGoodsdetails);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcGoodsdetailsList);
        }
        int total = pcGoodsdetailsList.size();
        int maxPageNo = pcGoodsdetailsList.size()%limit == 0? pcGoodsdetailsList.size()/limit:pcGoodsdetailsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcGoodsdetailsList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchPcGoodsDetail1(int pageNo, int limit, String idSorted, List<Map> pcGoodsdetails) {
        MyPage page = null;
        List<Map> pcGoodsdetailsList = new ArrayList<>();
        pcGoodsdetailsList.addAll(pcGoodsdetails);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcGoodsdetailsList);
        }
        int total = pcGoodsdetailsList.size();
        int maxPageNo = pcGoodsdetailsList.size()%limit == 0? pcGoodsdetailsList.size()/limit:pcGoodsdetailsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcGoodsdetailsList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchPcGoodsDetailKinds(int pageNo, int limit, String idSorted, List<Map> pcGoodsdetails) {
        MyPage page = null;
        List<Map> pcGoodsdetailsList = new ArrayList<>();
        pcGoodsdetailsList.addAll(pcGoodsdetails);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcGoodsdetailsList);
        }
        int total = pcGoodsdetailsList.size();
        int maxPageNo = pcGoodsdetailsList.size()%limit == 0? pcGoodsdetailsList.size()/limit:pcGoodsdetailsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcGoodsdetailsList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchPcGoodsId(int pageNo, int limit, String idSorted, List<Map> pcGoodsdetails) {
        MyPage page = null;
        List<Map> pcGoodsdetailsList = new ArrayList<>();
        pcGoodsdetailsList.addAll(pcGoodsdetails);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcGoodsdetailsList);
        }
        int total = pcGoodsdetailsList.size();
        int maxPageNo = pcGoodsdetailsList.size()%limit == 0? pcGoodsdetailsList.size()/limit:pcGoodsdetailsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcGoodsdetailsList.subList(beginIndex, endIndex), total);

        return page;
    }
}
