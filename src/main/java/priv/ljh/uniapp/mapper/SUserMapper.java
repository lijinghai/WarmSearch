package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.pc.entity.PcUser;
import priv.ljh.uniapp.entity.SUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2022-02-13
 */
@Mapper
@Repository
@ApiModel("PC端用户信息接口类")
public interface SUserMapper extends BaseMapper<SUser> {
    @Select("select * from s_user where username = #{username} and password= #{password}")
    SUser login(SUser user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from s_user where id  = #{id}")
    List<Map> selectById(@Param("id") Integer id);
}
