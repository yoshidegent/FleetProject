package com.realdolmen.fleet.controllers.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public String error(HttpServletRequest request, HttpServletResponse response, Model model) {
        // TODO: log the error
        int status = response.getStatus();
        model.addAttribute("statusCode", status);

        switch(status) {
            case 404:
                return "errors/404";
            case 500:
                return "errors/500";
            default:
                return "errors/http";
        }
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
