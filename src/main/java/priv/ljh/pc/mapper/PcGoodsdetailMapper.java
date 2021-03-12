package priv.ljh.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.pc.entity.PcGoodsdetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端物品详情信息 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-03-11
 */
@Mapper
@Repository
@ApiModel("PC端物品详情信息实体接口类")
public interface PcGoodsdetailMapper extends BaseMapper<PcGoodsdetail> {

    /**
     * 显示详情页信息
     * @param
     * @return
     */
    @Select("select  pg.panelId, pg.type, pg.goodsId, pg.url, pg.create_time, pg.updated_time, pg.goods_name, pg.goods_detail, pg.status,c.id, c.c_title from pc_goodsdetail pg, category c where pg.panelId = c.id and pg.panelId=#{id}")
    List<Map> getAllGoods(@Param("id")Integer id);

    /**
     * 根据种类查询
     * @param id
     * @return
     */
    @Select("select  g.panelId, g.kindId, g.type, g.goodsId, g.url, g.create_time, g.updated_time, g.goods_name, g.goods_detail, g.status, k.id,k.kind from pc_goodsdetail g, pc_goodskind where g.kindId = k.id and  g.kindId=#{id}")
    List<Map> getAllGoodsKinds(@Param("id")Integer id);

}
