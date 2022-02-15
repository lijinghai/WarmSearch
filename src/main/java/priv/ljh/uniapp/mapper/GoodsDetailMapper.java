package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.GoodsDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import priv.ljh.uniapp.entity.Goodsfirst;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物品详情页信息 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-20
 */
@Mapper
@Repository
@ApiModel("物品详情页信息实体接口类")
public interface GoodsDetailMapper extends BaseMapper<GoodsDetail> {

    /**
     * 显示详情页信息
     * @param id
     * @return
     */
    @Select("select f.id,f.g_id,f.contact,f.create_time,f.imgdesc,f.imgname,f.imgurl,f.lostname,f.status,d.id from goodsfirst f, category d where f.g_id = d.id and f.g_id=#{id}")
    List<Map> getAllGoods(@Param("id")Integer id);

    /**
     * 显示首页信息
     * @param id
     * @return
     */
    @Select("select f.id,f.contact,f.create_time,f.imgdesc,f.imgname,f.imgurl,f.lostname,f.status,c.c_title from goodsfirst f, category where f.g_id = c.id and d.id =#{id}")
    List<Map> getAllCategories(@Param("id")Integer id);
}
