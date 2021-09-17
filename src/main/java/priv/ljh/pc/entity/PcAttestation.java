package priv.ljh.pc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 认领信息登记
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PcAttestation对象", description="认领信息登记")
public class PcAttestation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "被认领的物品名称")
    private String goodsName;

    @ApiModelProperty(value = "认领人的姓名")
    private String userName;

    @ApiModelProperty(value = "认领人的联系方式")
    private String contact;

    @ApiModelProperty(value = "认领人的学号或工号")
    private String number;

    @ApiModelProperty(value = "认领人的地址")
    private String address;

    @ApiModelProperty(value = "认领人的证件照")
    private String imgUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale = "zh", timezone = "Asia/Shanghai",pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "认领时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

}
