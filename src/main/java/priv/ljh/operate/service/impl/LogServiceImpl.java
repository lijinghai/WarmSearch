package priv.ljh.operate.service.impl;

import priv.ljh.operate.entity.Log;
import priv.ljh.operate.mapper.LogMapper;
import priv.ljh.operate.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-23
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
