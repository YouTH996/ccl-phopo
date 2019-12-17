package youth996.club.ccl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = {"/","login","login.html"})
    public String to_login() {
        return "login";
    }

    @RequestMapping("about")
    public String about() {
        return "about";
    }

    @RequestMapping("blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("image-detail")
    public String imageDetail() {
        return "image-detail";
    }
}
