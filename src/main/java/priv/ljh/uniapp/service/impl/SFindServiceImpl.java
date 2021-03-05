package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.SFind;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.uniapp.mapper.SFindMapper;
import priv.ljh.uniapp.service.SFindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 招领信息表 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
@Service
public class SFindServiceImpl extends ServiceImpl<SFindMapper, SFind> implements SFindService {

    /**
     * 显示首页信息
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param sFinds
     * @return
     */
    @Override
    public MyPage searchSFind(int pageNo, int limit, String idSorted, List<SFind> sFinds) {
        MyPage page = null;
        List<SFind> sFindsList = new ArrayList<>();
        sFindsList.addAll(sFinds);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(sFindsList);
        }
        int total = sFindsList.size();
        int maxPageNo = sFindsList.size()%limit == 0? sFindsList.size()/limit:sFindsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(sFindsList.subList(beginIndex, endIndex), total);

        return page;
    }

    /**
     * 显示详情页信息
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param sFinds
     * @return
     */
    @Override
    public MyPage searchAllSFind(int pageNo, int limit, String idSorted, List<Map> sFinds) {
        MyPage page = null;
        List<Map> sFindsList = new ArrayList<>();
        sFindsList.addAll(sFinds);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(sFindsList);
        }
        int total = sFindsList.size();
        int maxPageNo = sFindsList.size()%limit == 0? sFindsList.size()/limit:sFindsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(sFindsList.subList(beginIndex, endIndex), total);

        return page;
    }
}
