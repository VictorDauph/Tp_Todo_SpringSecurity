package m2i.todoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Victor
 */

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String root(){
        return "welcome";
    }
}
