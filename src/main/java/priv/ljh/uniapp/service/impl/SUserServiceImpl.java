package priv.ljh.uniapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.ljh.pc.entity.PcUser;
import priv.ljh.uniapp.entity.SUser;
import priv.ljh.uniapp.mapper.SUserMapper;
import priv.ljh.uniapp.service.SUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.requestMessage.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2022-02-13
 */
@Service
public class SUserServiceImpl extends ServiceImpl<SUserMapper, SUser> implements SUserService {
    @Autowired
    private SUserMapper sUserMapper;

    @Override
    public SUser login(SUser pcUser) {
        //根据接受的用户名和密码查询数据库
        SUser userDB = sUserMapper.login(pcUser);
        if(userDB != null){
            return userDB;
        }
        throw new RuntimeException("登录失败");
    }


    @Override
    public MyPage searchPcUser(int pageNo, int limit, String idSorted, List<SUser> sUsers) {
        MyPage page = null;
        List<SUser> pcUsersList = new ArrayList<>();
        pcUsersList.addAll(sUsers);
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

    @Override
    public MyPage searchById(int pageNo, int limit, String idSorted, List<Map> users) {
        MyPage page = null;
        List<Map> infoList = new ArrayList<>();
        infoList.addAll(users);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(infoList);
        }
        int total = infoList.size();
        int maxPageNo = infoList.size()%limit == 0? infoList.size()/limit:infoList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(infoList.subList(beginIndex, endIndex), total);

        return page;
    }
}
