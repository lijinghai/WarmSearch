package priv.ljh.utils.uploadFile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * UploadFileService
 *
 * @author lijinghai
 * @date 2021/2/18 19:42
 * @since 1.0.0
 */
@Service
public interface UploadFileService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    ResultResponse uploadFiles(MultipartFile file, HttpServletRequest req);

}
