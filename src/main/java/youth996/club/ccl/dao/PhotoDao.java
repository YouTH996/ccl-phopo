package youth996.club.ccl.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import youth996.club.ccl.entity.Photo;

import java.util.List;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Mapper
public interface PhotoDao {


    /**
     * 查找人物图片-dao
     * @return
     */
    @Select("select * from tb_photo where type=0")
    List<Photo> selectPelPhoto();

    /**
     * 查找食物图片-dao
     * @return
     */
    @Select("select * from tb_photo where type=1")
    List<Photo> selectFoodPhoto();

    /**
     * 查找风景图片-dao
     * @return
     */
    @Select("select * from tb_photo where type=2")
    List<Photo> selectViewPhoto();

    /**
     * 查找朋友图片-dao
     * @return
     */
    @Select("select * from tb_photo where type=3")
    List<Photo> selectFriPhoto();

    /**
     * 查找生活图片-dao
     * @return
     */
    @Select("select * from tb_photo where type=4")
    List<Photo> selectLifePhoto();

    /**
     * 添加图片-dao
     */
    @Insert("insert into tb_photo (name,url,format,size,type)  VALUES ( #{name}, #{url}, #{format}, #{size},#{type})")
    int insertPhoto(Photo photo);
}
