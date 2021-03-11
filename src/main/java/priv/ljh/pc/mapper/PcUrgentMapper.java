package priv.ljh.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.ljh.pc.entity.PcUrgent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * PC端急需物品 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
@Mapper
@Repository
@ApiModel("PC端急需物品实体接口类")
public interface PcUrgentMapper extends BaseMapper<PcUrgent> {

}
