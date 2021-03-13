package priv.ljh.pc.service;

import priv.ljh.pc.entity.PcRecent;
import priv.ljh.pc.entity.PcUrgent;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端急需物品 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
public interface PcUrgentService extends IService<PcUrgent> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcUrgents
     * @return getUrgentId
     */
    public MyPage searchPcUrgent(int pageNo, int limit, String idSorted, List<PcUrgent> pcUrgents);

    /**
     * 根据goodsid查询数据
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param PcUrgent
     * @return
     */
    public MyPage searchPcUrgentId(int pageNo, int limit, String idSorted, List<Map> PcUrgent);

}
