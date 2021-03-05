package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.GoodsDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物品详情页信息 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-20
 */
public interface GoodsDetailService extends IService<GoodsDetail> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param goodsDetails
     * @return
     */
    public MyPage searchGoodsDetail(int pageNo, int limit, String idSorted, List<Map> goodsDetails);
    public MyPage searchGoodsDetail1(int pageNo, int limit, String idSorted, List<GoodsDetail> goodsDetails);
}
