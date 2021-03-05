package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.Unbo;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 * 首页轮播图 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-19
 */
public interface UnboService extends IService<Unbo> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param Unbo
     * @return
     */
    public MyPage searchUnbo(int pageNo, int limit, String idSorted, List<Unbo> Unbo);
}
