package feeddit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Matkovic on 26.3.2017..
 */
@Controller
public class LoginController {

    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}
