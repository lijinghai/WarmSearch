package priv.ljh.pc.service;

import org.springframework.stereotype.Service;
import priv.ljh.pc.entity.PcUser;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端用户信息 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-14
 */
@Service
public interface PcUserService extends IService<PcUser> {
    PcUser login(PcUser pcUser);

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcUsers
     * @return
     */
    public MyPage searchPcUser(int pageNo, int limit, String idSorted, List<PcUser> pcUsers);

    priv.ljh.utils.requestMessage.MyPage searchById(int pageNo, int limit, String idSorted, List<Map> users);
}
