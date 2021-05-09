package priv.ljh.pc.service;

import priv.ljh.pc.entity.PcGoodsdetail;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端物品详情信息 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
public interface PcGoodsdetailService extends IService<PcGoodsdetail> {

    /**
     *自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcGoodsdetails
     * @return
     */
    public MyPage searchPcGoodsdetail(int pageNo, int limit, String idSorted, List<PcGoodsdetail> pcGoodsdetails);

    /**
     * 多表查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcGoodsdetails
     * @return
     */
    public MyPage searchPcGoodsDetail1(int pageNo, int limit, String idSorted, List<Map> pcGoodsdetails);

    /**
     * 根据种类查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcGoodsdetails
     * @return
     */
    public MyPage searchPcGoodsDetailKinds(int pageNo, int limit, String idSorted, List<Map> pcGoodsdetails);

    /**
     * 根据物品id查询数据
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcGoodsdetails
     * @return
     */
    public MyPage searchPcGoodsId(int pageNo, int limit, String idSorted, List<Map> pcGoodsdetails);
}
