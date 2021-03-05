package priv.ljh.operate.service;

import org.springframework.stereotype.Service;
import priv.ljh.operate.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-22
 */
@Service
public interface UserService extends IService<User> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @return
     */
    public MyPage searchEmployees(int pageNo, int limit, String idSorted,List<User> users);
}
