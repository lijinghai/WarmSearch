package priv.ljh.utils.uploadFile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.utils.Constants;
import priv.ljh.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * UploadFileServiceImpl
 *
 * @author lijinghai
 * @date 2021/2/18 19:46
 * @since 1.0.0
 */
@Slf4j
@Service
public class UploadFileServiceImpl implements UploadFileService{

    public String url = null;

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public ResultResponse uploadFiles(MultipartFile file, HttpServletRequest req) {
        ResultResponse res = null;
//        HttpServletRequest req = null;
        //判断文件是否为空
        if(file.isEmpty()) {
            res = new ResultResponse(Constants.STATUS_FALL, Constants.MESSAGE_FALL,null);
            return res;
        }
        //原始文件名
        String originalFile = file.getOriginalFilename();
        //使用时间戳重新命名文件，存在服务器里
        String fileName = System.currentTimeMillis()+"."+originalFile.substring(originalFile.lastIndexOf(".")+1);
        //存放用户上传文件的文件夹
        String filePath = "D:\\serach\\";
        //目标文件
        File dest = new File(filePath+fileName);

        //判断目录是否存在
        if(!dest.getParentFile().exists()) {
            //创建
            dest.getParentFile().mkdirs();
            try {
                //拷贝
                file.transferTo(dest);
            }catch (Exception e) {
                e.printStackTrace();
                res = new ResultResponse(Constants.STATUS_FALL, Constants.MESSAGE_FALL+"文件上传失败",fileName);
                res.setMessage(Constants.MESSAGE_FALL+"文件上传失败");
                return res;
            }
        }
        url = req.getScheme() + "://" +req.getServerName() + ":" + req.getServerPort() + "/" + fileName;
        log.info(url);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,url);

        // 保存到数据库
        setUrl(url);

        return res;
    }

}
