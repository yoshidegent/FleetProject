package com.realdolmen.fleet.controllers.advices;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.User;
import com.realdolmen.fleet.authentication.CurrentUser;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserResolverAdvise {
    @ModelAttribute("user")
    public User currentUser(@CurrentUser User user) {
        return user;
    }

    @ModelAttribute("userEmployee")
    public Employee currentEmployee(@CurrentUser User user) {
        if(user instanceof Employee)
            return (Employee) user;

        return null;
    }
}
