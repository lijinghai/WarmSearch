package priv.ljh.operate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Adminuser对象", description="")
public class AdminUser implements java.io.Serializable {

    @ApiModelProperty(value = "姓名(登录名)")
    private String username;

    /**
     * @JsonIgnore 该对象不需要变成json对象上传到前端
     */
    @ApiModelProperty(value = "登录密码")
    private String password;

}
