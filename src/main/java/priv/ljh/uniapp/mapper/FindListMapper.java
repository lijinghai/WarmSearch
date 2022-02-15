package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.FindList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 待招领物品详情表 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-23
 */
@Mapper
@Repository
@ApiModel("待招领物品详情表实体接口类")
public interface FindListMapper extends BaseMapper<FindList> {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from find_list where id  = #{id}")
    List<Map> selectById(@Param("id") Integer id);
}
