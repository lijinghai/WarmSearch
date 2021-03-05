package priv.ljh.operate.service.impl;

import priv.ljh.operate.entity.Electronic;
import priv.ljh.operate.mapper.ElectronicMapper;
import priv.ljh.operate.service.ElectronicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-29
 */
@Service
public class ElectronicServiceImpl extends ServiceImpl<ElectronicMapper, Electronic> implements ElectronicService {

    @Override
    public MyPage searchElectronic(int pageNo, int limit, String idSorted, List<Electronic> electronics) {
        MyPage page = null;
        List<Electronic> electronicList = new ArrayList<>();
        electronicList.addAll(electronics);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(electronicList);
        }
        int total = electronicList.size();
        int maxPageNo = electronicList.size()%limit == 0? electronicList.size()/limit:electronicList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(electronicList.subList(beginIndex, endIndex), total);

        return page;
    }
}
