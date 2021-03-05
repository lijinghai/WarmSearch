package priv.ljh.operate.service;

import priv.ljh.operate.entity.AdminUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-26
 */
public interface AdminUserService  {
    /**
     * 如果验证成功，返回adminUser对象
     * 否则，返回null或throw
     */
    public AdminUser verify(AdminUser adminUser);

}
