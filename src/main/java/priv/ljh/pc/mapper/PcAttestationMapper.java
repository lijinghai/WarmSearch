package priv.ljh.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.ljh.pc.entity.PcAttestation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 认领信息登记 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-07
 */
@Mapper
@Repository
@ApiModel("PC端认领信息登记接口类")
public interface PcAttestationMapper extends BaseMapper<PcAttestation> {

}
