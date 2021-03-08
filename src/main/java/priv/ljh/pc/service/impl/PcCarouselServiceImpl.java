package priv.ljh.pc.service.impl;

import priv.ljh.pc.entity.PcCarousel;
import priv.ljh.pc.mapper.PcCarouselMapper;
import priv.ljh.pc.service.PcCarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * PC端轮播图 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-08
 */
@Service
public class PcCarouselServiceImpl extends ServiceImpl<PcCarouselMapper, PcCarousel> implements PcCarouselService {

    @Override
    public MyPage searchPcCarousel(int pageNo, int limit, String idSorted, List<PcCarousel> pcCarousel) {
        MyPage page = null;
        List<PcCarousel> pcCarouselList = new ArrayList<>();
        pcCarouselList.addAll(pcCarousel);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcCarouselList);
        }
        int total = pcCarouselList.size();
        int maxPageNo = pcCarouselList.size()%limit == 0? pcCarouselList.size()/limit:pcCarouselList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcCarouselList.subList(beginIndex, endIndex), total);

        return page;
    }
}
