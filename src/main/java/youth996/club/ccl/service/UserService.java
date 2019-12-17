package youth996.club.ccl.service;

import youth996.club.ccl.entity.User;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
public interface UserService {
    /**
     * 根据用户名和用户名密码查找用户-登录功能
     * @param user
     * @return
     */
    Boolean selectUser(User user);
}
