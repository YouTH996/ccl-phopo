package youth996.club.ccl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import youth996.club.ccl.FinalProperties;
import youth996.club.ccl.entity.Photo;
import youth996.club.ccl.service.PhotoService;
import youth996.club.ccl.util.FileUploadUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Controller
public class PhotoController {
    private static final Logger log = LoggerFactory.getLogger(PhotoController.class);
    @Autowired
    PhotoService photoService;
    @RequestMapping("toUpload")
    public String toUpload() {
        return "upload";
    }

    /**
     * 文件上传逻辑功能
     * @param multipartFile
     * @return
     */
    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, Model model, HttpServletRequest request) {
        boolean b=false;
        try {
            //获取上传图片的类型
            String type = request.getParameter("type");
            int typeCode=-1;
            if("人物".equals(type)){
                typeCode=0;
            }else if("风景".equals(type)){
                typeCode=1;
            }else if("食物".equals(type)){
                typeCode=2;
            }
            else if("朋友".equals(type)){
                typeCode=3;
            }else if("生活".equals(type)){
                typeCode=4;
            }
            //获取图片大小
            double size= multipartFile.getBytes().length / 1024.00;
            //获取图片名
            String name = multipartFile.getOriginalFilename();
            //获取图片格式
            int i = name.lastIndexOf(".");
            String format = name.substring(i + 1);
            log.info("文件上传逻辑功能");
            if (multipartFile.getBytes().length==0) {
                model.addAttribute("msg", "请添加图片!");
                return "upload";
            } else if (!format.equals("jpg") && !format.equals("png") && !format.equals("jpeg")) {
                model.addAttribute("msg", "图片格式只支持jpg，png，jpeg!");
                return "upload";
            } else if (size > 1024.00) {
                model.addAttribute("msg", "图片体积太大，无法上传！");
                return "upload";
            }
            String imgUrl = FileUploadUtil.imgUpload(multipartFile);
            //TODO:加上前缀：http://
            imgUrl = FinalProperties.URLHEADER + imgUrl;
            log.info("图片上传的保存地址为：" + imgUrl);
            //TODO:往数据库中插入图片
            Photo photo = new Photo(name, imgUrl, format, size,typeCode);
            b = photoService.insertPhoto(photo);
        } catch (Exception e) {
            log.error("文件上传逻辑功能-发生了异常",e.fillInStackTrace());
        }
        if(b){
            model.addAttribute("msg", "添加图片成功!");
            List<Photo> pelPhotos = photoService.selectPelPhoto();
            List<Photo> foodPhotos = photoService.selectFoodPhoto();
            List<Photo> viewPhotos = photoService.selectViewPhoto();
            List<Photo> friPhotos = photoService.selectFriPhoto();
            List<Photo> lifePhotos = photoService.selectLifePhoto();
            model.addAttribute("pelPhotos",pelPhotos);
            model.addAttribute("foodPhotos",foodPhotos);
            model.addAttribute("viewPhotos",viewPhotos);
            model.addAttribute("friPhotos",friPhotos);
            model.addAttribute("lifePhotos",lifePhotos);
            return "index";
        }else{
            model.addAttribute("msg", "添加图片失败!");
            return "upload";
        }
    }


}
