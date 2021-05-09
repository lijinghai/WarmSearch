package priv.ljh.pc.service;

import priv.ljh.pc.entity.PcCarousel;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 * PC端轮播图 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-08
 */
public interface PcCarouselService extends IService<PcCarousel> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcCarousel
     * @return
     */
    public MyPage searchPcCarousel(int pageNo, int limit, String idSorted, List<PcCarousel> pcCarousel);

}
