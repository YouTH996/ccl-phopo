package youth996.club.ccl.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;
import youth996.club.ccl.FinalProperties;

import java.io.IOException;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p>文件上传工具类</p>
 */
public class FileUploadUtil {

    /**
     * 图片上传
     * @param multipartFile
     * @return
     */
    public static String imgUpload(MultipartFile multipartFile) {
        //TODO:获得上传文件的二进制字节流对象
        String imgUrl = FinalProperties.URL;
        String originalFilename = multipartFile.getOriginalFilename();
        int n = originalFilename.lastIndexOf(".");
        String extFileName = originalFilename.substring(n + 1);
        try {
            String path = new ClassPathResource("/tracker.conf").getPath();;
            byte[] bytes = multipartFile.getBytes();
            ClientGlobal.init(path);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            String[] fileMsg = storageClient.upload_file(bytes, extFileName, null);
            for (String s : fileMsg) {
                imgUrl+="/"+s;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
