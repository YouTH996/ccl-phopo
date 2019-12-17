package youth996.club.ccl.service;

import youth996.club.ccl.entity.Photo;

import java.util.List;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
public interface PhotoService {

    /**
     * 查找人物图片-sercive
     * @return
     */
    List<Photo> selectPelPhoto();

    /**
     * 查找食物图片-sercive
     * @return
     */
    List<Photo> selectFoodPhoto();

    /**
     * 查找风景图片-sercive
     * @return
     */
    List<Photo> selectViewPhoto();

    /**
     * 查找朋友图片-sercive
     * @return
     */
    List<Photo> selectFriPhoto();

    /**
     * 查找生活图片-sercive
     * @return
     */
    List<Photo> selectLifePhoto();

    /**
     * 添加图片-service
     * @return
     */
    boolean insertPhoto(Photo photo);
}
