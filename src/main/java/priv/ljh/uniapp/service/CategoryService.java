package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 寻物类别 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-22
 */
public interface CategoryService extends IService<Category> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param categories
     * @return
     */
    public MyPage searchCategory(int pageNo, int limit, String idSorted, List<Map> categories);

    public MyPage searchAllCategory(int pageNo, int limit, String idSorted, List<Category> categories);

}
