package youth996.club.ccl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import youth996.club.ccl.entity.Photo;
import youth996.club.ccl.entity.User;
import youth996.club.ccl.service.PhotoService;
import youth996.club.ccl.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> </p>
 */
@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    PhotoService photoService;

    /**
     * 用户登录功能
     * @param request
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model, HttpSession session) {

        if (session.getAttribute("user") != null) {
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
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        log.info("用户登录功能");
        Boolean success = null;
        try {
            success = userService.selectUser(user);
        } catch (Exception e) {
            log.error("用户登录功能-发生了异常",e.fillInStackTrace());
        }
        if (success) {
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
            session.setAttribute("user",user);
            return "index";
        }else{
            model.addAttribute("msg", "登录失败，用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("out")
    public String out(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
