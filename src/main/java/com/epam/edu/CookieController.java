package com.epam.edu;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.edu.util.Constants;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CookieController {

//	@RequestMapping(Constants.Paths.SLASH + Constants.Paths.READ_COOKIE)
//	public ModelAndView readCookie(HttpServletRequest request) {
//
//		String myCookie = "";
//		Cookie[] cookies = request.getCookies();
//
//		for (Cookie c : cookies) {
//			if (Constants.VALUE.equalsIgnoreCase(c.getName())) {
//				myCookie  = c.getValue();
//			}
//		}
//
//		ModelAndView mv = new ModelAndView(Constants.Pages.READ_PAGE);
//		mv.addObject(Constants.VALUE, myCookie);
//		return mv;
//	}

    @RequestMapping(Constants.Paths.SLASH + Constants.Paths.READ_COOKIE)
    public ModelAndView readCookie(@CookieValue(value = Constants.VALUE, defaultValue = StringUtils.EMPTY) String cookie,
                                   @CookieValue(value = Constants.KEY, defaultValue = StringUtils.EMPTY) String myCookie)
    {
        ModelAndView mv = new ModelAndView(Constants.Pages.READ_PAGE);
        mv.addObject(Constants.VALUE, cookie);
        mv.addObject(Constants.KEY, myCookie);
        return mv;
    }


    @RequestMapping(Constants.Paths.SLASH + Constants.Paths.WRITE_COOKIE)
    public String writeCookie(@RequestParam(value = Constants.VALUE, required = false) String value,
                              HttpServletResponse response) {

        String cookieValue = StringUtils.defaultIfBlank(value, Constants.DEFAULT_VALUE);
        response.addCookie(new Cookie(Constants.VALUE, cookieValue));
        response.addCookie(new Cookie(Constants.KEY, Constants.MY_VALUE));
        return Constants.Pages.WRITE_PAGE;
    }
}
