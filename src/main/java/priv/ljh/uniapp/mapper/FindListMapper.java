package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.FindList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
