package priv.ljh.pc.service.impl;

import priv.ljh.pc.entity.PcRecent;
import priv.ljh.pc.entity.PcUrgent;
import priv.ljh.pc.mapper.PcUrgentMapper;
import priv.ljh.pc.service.PcUrgentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端急需物品 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
@Service
public class PcUrgentServiceImpl extends ServiceImpl<PcUrgentMapper, PcUrgent> implements PcUrgentService {

    @Override
    public MyPage searchPcUrgent(int pageNo, int limit, String idSorted, List<PcUrgent> pcUrgents) {
        MyPage page = null;
        List<PcUrgent> pcUrgentsList = new ArrayList<>();
        pcUrgentsList.addAll(pcUrgents);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcUrgentsList);
        }
        int total = pcUrgentsList.size();
        int maxPageNo = pcUrgentsList.size()%limit == 0? pcUrgentsList.size()/limit:pcUrgentsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcUrgentsList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchPcUrgentId(int pageNo, int limit, String idSorted, List<Map> PcUrgent) {
        MyPage page = null;
        List<Map> PcUrgentList = new ArrayList<>();
        PcUrgentList.addAll(PcUrgent);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(PcUrgentList);
        }
        int total = PcUrgentList.size();
        int maxPageNo = PcUrgentList.size()%limit == 0? PcUrgentList.size()/limit:PcUrgentList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(PcUrgentList.subList(beginIndex, endIndex), total);

        return page;
    }
}
