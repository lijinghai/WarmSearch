package priv.ljh.pc.service;

import priv.ljh.pc.entity.PcAttestation;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.pc.entity.PcCarousel;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 * 认领信息登记 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-07
 */
public interface PcAttestationService extends IService<PcAttestation> {
    /**
     *
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcAttestations
     * @return
     */
    public MyPage searchPcAttestation(int pageNo, int limit, String idSorted, List<PcAttestation> pcAttestations);
}
