package youth996.club.ccl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import youth996.club.ccl.entity.User;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名和用户名密码查找用户-登录功能
     * @param user
     * @return
     */
    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User selectUser(User user);
}
