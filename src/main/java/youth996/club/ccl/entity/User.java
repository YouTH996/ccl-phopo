package youth996.club.ccl.entity;

import lombok.Data;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> 用户实体类</ p>
 */
@Data
public class User {
    /**
     * id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
