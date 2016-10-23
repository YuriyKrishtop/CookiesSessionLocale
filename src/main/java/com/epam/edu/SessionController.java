package com.epam.edu;

import com.epam.edu.util.Constants;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes(Constants.VALUE)
public class SessionController {


    @RequestMapping(value = Constants.Paths.SLASH + Constants.Paths.READ_SESSION, method = RequestMethod.GET)
    public ModelAndView readSession(@ModelAttribute(Constants.VALUE) String value) {

        ModelAndView modelAndView = new ModelAndView(Constants.Pages.READ_PAGE);
        modelAndView.addObject(Constants.VALUE, value);
        return modelAndView;
    }

//    @RequestMapping(value = Constants.Paths.SLASH + Constants.Paths.READ_SESSION, method = RequestMethod.GET)
//    public ModelAndView readSession(HttpServletRequest request) {
//
//        ModelAndView modelAndView = new ModelAndView(Constants.Pages.READ_PAGE);
//        Object personAttribute = request.getSession().getAttribute(Constants.VALUE);
//        modelAndView.addObject(Constants.VALUE, personAttribute);
//        return modelAndView;
//    }

    @RequestMapping(value = Constants.Paths.SLASH + Constants.Paths.WRITE_SESSION, method = RequestMethod.GET)
    public String writeSession(@RequestParam(value = Constants.VALUE, required = false) String value,
                               HttpServletRequest request) {

        String sessionVariable = StringUtils.defaultIfBlank(value, Constants.DEFAULT_VALUE);
        request.getSession().setAttribute(Constants.VALUE, sessionVariable);
        return Constants.Pages.WRITE_PAGE;
    }
}
