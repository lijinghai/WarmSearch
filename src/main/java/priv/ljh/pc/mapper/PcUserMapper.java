package priv.ljh.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.pc.entity.PcUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * PC端用户信息 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-14
 */
@Mapper
@Repository
@ApiModel("PC端用户信息接口类")
public interface PcUserMapper extends BaseMapper<PcUser> {
    @Select("select * from pc_user where username = #{username} and password= #{password}")
    PcUser login(PcUser user);
}
