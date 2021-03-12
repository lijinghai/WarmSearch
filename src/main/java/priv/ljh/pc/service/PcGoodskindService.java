package priv.ljh.pc.service;

import priv.ljh.pc.entity.PcGoodskind;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.pc.entity.PcRecent;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 *  PC端物品种类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-12
 */
public interface PcGoodskindService extends IService<PcGoodskind> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcGoodskinds
     * @return
     */
    public MyPage searchKinds(int pageNo, int limit, String idSorted, List<PcGoodskind> pcGoodskinds);

}
