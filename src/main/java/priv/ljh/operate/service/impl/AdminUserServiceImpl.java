package priv.ljh.operate.service.impl;

import priv.ljh.operate.entity.AdminUser;
import priv.ljh.operate.service.AdminUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-01-26
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private Map<String, AdminUser> aus = new HashMap<String, AdminUser>();
    {
        //  代码块（普通）
        AdminUser adminUser = null;
        for(int i=1;i<10;i++){
            adminUser = new AdminUser("admin"+i, "password"+i);
            aus.put(adminUser.getUsername(), adminUser);
        }
    }


    @Override
    public AdminUser verify(AdminUser adminUser) {
        AdminUser au = null;
        au = this.aus.get(adminUser.getUsername());
        if(au != null){
            if(!au.getPassword().equals(adminUser.getPassword())){
                au = null;
            }
        }
        return au;
    }
}
