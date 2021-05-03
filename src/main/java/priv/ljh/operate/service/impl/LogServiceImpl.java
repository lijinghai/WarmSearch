package priv.ljh.operate.service.impl;

import priv.ljh.operate.entity.Log;
import priv.ljh.operate.mapper.LogMapper;
import priv.ljh.operate.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-29
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Override
    public MyPage searchlogs(int pageNo, int limit, String idSorted, List<Log> logs) {
        MyPage page = null;
        List<Log> logList = new ArrayList<>();
        logList.addAll(logs);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(logList);
        }
        int total = logList.size();
        int maxPageNo = logList.size()%limit == 0? logList.size()/limit:logList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(logList.subList(beginIndex, endIndex), total);

        return page;
    }
}
