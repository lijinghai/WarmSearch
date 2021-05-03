package priv.ljh.operate.service;

import priv.ljh.operate.entity.Log;
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
public interface LogService extends IService<Log> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @return
     */
    public MyPage searchlogs(int pageNo, int limit, String idSorted, List<Log> logs);
}
