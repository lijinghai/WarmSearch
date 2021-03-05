package priv.ljh.operate.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 登录时需要的info信息
 * @author lijinghai
 * @Date 2021-1-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("登录时需要的info信息")
public class AdminUserInfo {
    @ApiModelProperty(value = "角色")
    private List<String> roles;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "图标")
    private String avatar;

    @ApiModelProperty(value = "名称")
    private String name;
}
