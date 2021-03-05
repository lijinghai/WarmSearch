package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 寻物类别 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-22
 */
@Mapper
@Repository
@ApiModel("寻物类别实体接口类")
public interface CategoryMapper extends BaseMapper<Category> {

}
