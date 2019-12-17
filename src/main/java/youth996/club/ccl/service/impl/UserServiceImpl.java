package youth996.club.ccl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youth996.club.ccl.dao.UserDao;
import youth996.club.ccl.entity.User;
import youth996.club.ccl.service.UserService;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;
    @Override
    public Boolean selectUser(User user) {
        log.info("根据用户名和用户名密码查找用户-登录功能");
        User user1=null;
        try {
            user1= userDao.selectUser(user);

        } catch (Exception e) {
            log.error("根据用户名和用户名密码查找用户-登录功能-发生了异常",e.fillInStackTrace());
        }
        if (user1 != null) {
            return true;
        } else {
            return false;
        }
    }
}
