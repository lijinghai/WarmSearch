package priv.ljh.uniapp.service;

import org.springframework.stereotype.Service;
import priv.ljh.pc.entity.PcUser;
import priv.ljh.uniapp.entity.SUser;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.requestMessage.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lijinghai
 * @since 2022-02-13
 */

public interface SUserService extends IService<SUser> {
    SUser login(SUser sUser);


    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param sUsers
     * @return
     */
    public MyPage searchPcUser(int pageNo, int limit, String idSorted, List<SUser> sUsers);

    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param users
     * @return
     */
    public MyPage searchById(int pageNo, int limit, String idSorted, List<Map> users);
}
