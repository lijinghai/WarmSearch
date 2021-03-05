package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.SFind;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 招领信息表 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
@Mapper
@Repository
@ApiModel("招领信息表实体接口类")
public interface SFindMapper extends BaseMapper<SFind> {

    /**
     * 显示详情页信息
     * @param id
     * @return
     */
    @Select("select f.id, fl_id, fl_imgurl, fl_imgdesc, fl_status, fl_createTime, version, fl_name, fl_contact, f_click, f_img from find_list f, s_find s where f.fl_id = s.id and f.fl_id =#{id}")
    List<Map> getAllSFind(@Param("id")Integer id);

    /**
     * 显示首页信息
     * @param id
     * @return
     */
    @Select("select f.id, fl_id, fl_imgurl, fl_imgdesc, fl_status, fl_createTime, version, fl_name, fl_contact, f_click, f_img from find_list f, s_find s where f.fl_id = s.id and s.id =#{id}")
    List<Map> getAllSFinds(@Param("id")Integer id);
}
