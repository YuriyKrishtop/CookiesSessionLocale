package com.epam.edu;

import com.epam.edu.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(Constants.Paths.SLASH)
    public String getHomePage() {
        return Constants.Pages.HOME_PAGE;
    }
}
