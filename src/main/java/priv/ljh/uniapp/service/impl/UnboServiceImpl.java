package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.uniapp.mapper.UnboMapper;
import priv.ljh.uniapp.service.UnboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 首页轮播图 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-19
 */
@Service
public class UnboServiceImpl extends ServiceImpl<UnboMapper, Unbo> implements UnboService {

    @Override
    public MyPage searchUnbo(int pageNo, int limit, String idSorted, List<Unbo> Unbo) {
        MyPage page = null;
        List<Unbo> unbosList = new ArrayList<>();
        unbosList.addAll(Unbo);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(unbosList);
        }
        int total = unbosList.size();
        int maxPageNo = unbosList.size()%limit == 0? unbosList.size()/limit:unbosList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(unbosList.subList(beginIndex, endIndex), total);

        return page;
    }
}
