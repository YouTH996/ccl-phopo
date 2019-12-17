package youth996.club.ccl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youth996.club.ccl.dao.PhotoDao;
import youth996.club.ccl.entity.Photo;
import youth996.club.ccl.service.PhotoService;

import java.util.List;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    private static final Logger log = LoggerFactory.getLogger(PhotoServiceImpl.class);
    @Autowired
    PhotoDao photoDao;


    @Override
    public List<Photo> selectPelPhoto() {
        List<Photo> pelPhotos=null;
        try {
            log.info("查找人物图片-sercive");
            pelPhotos = photoDao.selectPelPhoto();

        } catch (Exception e) {
            log.error("查找人物图片-sercive-发了异常",e.fillInStackTrace());
        }
        return pelPhotos;
    }

    @Override
    public List<Photo> selectFoodPhoto() {
        List<Photo> foodPhotos=null;
        try {
            log.info("查找食物图片-sercive");
            foodPhotos = photoDao.selectFoodPhoto();

        } catch (Exception e) {
            log.error("查找食物图片-sercive-发了异常",e.fillInStackTrace());
        }
        return foodPhotos;
    }

    @Override
    public List<Photo> selectViewPhoto() {
        List<Photo> viewPhotos=null;
        try {
            log.info("查找风景图片-sercive");
            viewPhotos = photoDao.selectViewPhoto();

        } catch (Exception e) {
            log.error("查找风景图片-sercive-发了异常",e.fillInStackTrace());
        }
        return viewPhotos;
    }

    @Override
    public List<Photo> selectFriPhoto() {
        List<Photo> friPhotos=null;
        try {
            log.info("查找朋友图片-sercive");
            friPhotos = photoDao.selectFriPhoto();

        } catch (Exception e) {
            log.error("查找朋友图片-sercive-发了异常",e.fillInStackTrace());
        }
        return friPhotos;
    }

    @Override
    public List<Photo> selectLifePhoto() {
        List<Photo> lifePhotos=null;
        try {
            log.info("查找生活图片-sercive");
            lifePhotos = photoDao.selectLifePhoto();

        } catch (Exception e) {
            log.error("查找生活图片-sercive-发了异常",e.fillInStackTrace());
        }
        return lifePhotos;
    }

    @Override
    public boolean insertPhoto(Photo photo) {
        int i = photoDao.insertPhoto(photo);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
