package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.uniapp.mapper.GoodsfirstMapper;
import priv.ljh.uniapp.service.GoodsfirstService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 首页展示的物品信息 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-19
 */
@Service
public class GoodsfirstServiceImpl extends ServiceImpl<GoodsfirstMapper, Goodsfirst> implements GoodsfirstService {

    @Override
    public MyPage searchUnbo(int pageNo, int limit, String idSorted, List<Goodsfirst> goodsfirsts) {
        MyPage page = null;
        List<Goodsfirst> goodsfirstsList = new ArrayList<>();
        goodsfirstsList.addAll(goodsfirsts);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(goodsfirstsList);
        }
        int total = goodsfirstsList.size();
        int maxPageNo = goodsfirstsList.size()%limit == 0? goodsfirstsList.size()/limit:goodsfirstsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(goodsfirstsList.subList(beginIndex, endIndex), total);

        return page;
    }
}
