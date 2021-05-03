package priv.ljh.pc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.ljh.pc.entity.PcUser;
import priv.ljh.pc.mapper.PcUserMapper;
import priv.ljh.pc.service.PcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * PC端用户信息 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-14
 */
@Service
public class PcUserServiceImpl extends ServiceImpl<PcUserMapper, PcUser> implements PcUserService {

    @Autowired
    private PcUserMapper pcUserMapper;

    @Override
    public PcUser login(PcUser pcUser) {
        //根据接受的用户名和密码查询数据库
        PcUser userDB = pcUserMapper.login(pcUser);
        if(userDB != null){
            return userDB;
        }
        throw new RuntimeException("登录失败");
    }

    @Override
    public MyPage searchPcUser(int pageNo, int limit, String idSorted, List<PcUser> pcUsers) {
        MyPage page = null;
        List<PcUser> pcUsersList = new ArrayList<>();
        pcUsersList.addAll(pcUsers);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcUsersList);
        }
        int total = pcUsersList.size();
        int maxPageNo = pcUsersList.size()%limit == 0? pcUsersList.size()/limit:pcUsersList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcUsersList.subList(beginIndex, endIndex), total);

        return page;
    }
}
