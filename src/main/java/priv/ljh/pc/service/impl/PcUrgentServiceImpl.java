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
}
