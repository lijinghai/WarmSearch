package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.FindList;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 * 待招领物品详情表 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
public interface FindListService extends IService<FindList> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param findLists
     * @return
     */
    public MyPage searchFindList(int pageNo, int limit, String idSorted, List<FindList> findLists);
}
