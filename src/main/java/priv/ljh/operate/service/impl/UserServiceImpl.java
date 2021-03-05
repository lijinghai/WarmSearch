package priv.ljh.operate.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import priv.ljh.operate.entity.User;
import priv.ljh.operate.mapper.UserMapper;
import priv.ljh.operate.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @return
     */
    @Override
    public MyPage searchEmployees(int pageNo, int limit, String idSorted,List<User> users) {
        MyPage page = null;
        List<User> userList = new ArrayList<>();
        userList.addAll(users);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(userList);
        }
        int total = userList.size();
        int maxPageNo = userList.size()%limit == 0? userList.size()/limit:userList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(userList.subList(beginIndex, endIndex), total);

        return page;
    }
}
