package priv.ljh.operate.service;

import priv.ljh.operate.entity.Electronic;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-29
 */
public interface ElectronicService extends IService<Electronic> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @return
     */
    public MyPage searchElectronic(int pageNo, int limit, String idSorted, List<Electronic> electronics);
}
