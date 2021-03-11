package priv.ljh.pc.service;

import priv.ljh.pc.entity.PcRecent;
import priv.ljh.pc.entity.PcUrgent;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

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
     * @return
     */
    public MyPage searchPcUrgent(int pageNo, int limit, String idSorted, List<PcUrgent> pcUrgents);


}
