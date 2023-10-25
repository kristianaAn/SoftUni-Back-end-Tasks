package com.softuni.mobilele.web;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
    public ModelAndView view(String viewName, ModelAndView mv) {
        mv.setViewName(viewName);
        return mv;
    }

    public ModelAndView view(String viewName) {
        return this.view(viewName, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view("redirect:" + url);
    }
}
