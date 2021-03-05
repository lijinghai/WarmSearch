package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.SFind;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 招领信息表 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
public interface SFindService extends IService<SFind> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param sFinds
     * @return
     */
    public MyPage searchSFind(int pageNo, int limit, String idSorted, List<SFind> sFinds);

    public MyPage searchAllSFind(int pageNo, int limit, String idSorted, List<Map> sFinds);
}
