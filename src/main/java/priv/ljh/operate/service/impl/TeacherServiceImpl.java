package priv.ljh.operate.service.impl;

import priv.ljh.operate.entity.Teacher;
import priv.ljh.operate.entity.User;
import priv.ljh.operate.mapper.TeacherMapper;
import priv.ljh.operate.service.TeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @return
     */
    @Override
    public MyPage searchTeachers(int pageNo, int limit, String idSorted, List<Teacher> teachers) {
        MyPage page = null;
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.addAll(teachers);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(teacherList);
        }
        int total = teacherList.size();
        int maxPageNo = teacherList.size()%limit == 0? teacherList.size()/limit:teacherList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(teacherList.subList(beginIndex, endIndex), total);

        return page;
    }
}
