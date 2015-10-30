package com.realdolmen.fleet.controllers.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CurrentUrlResolverAdvice {
    @ModelAttribute("currentUrl")
    public String currentUrl(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(request.getRequestURL());
        if(request.getQueryString() != null)
            sb.append("?").append(request.getQueryString());

        return sb.toString();
    }
}
