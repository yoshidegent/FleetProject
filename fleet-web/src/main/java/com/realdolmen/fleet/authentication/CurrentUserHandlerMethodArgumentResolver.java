package com.realdolmen.fleet.authentication;

import com.realdolmen.fleet.User;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(CurrentUser.class) != null
                        && methodParameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if(!this.supportsParameter(methodParameter))
            return WebArgumentResolver.UNRESOLVED;

        Authentication authentication = (Authentication)nativeWebRequest.getUserPrincipal();
        if(authentication == null)
            return null;

        Object principal = authentication.getPrincipal();
        if(principal == null || !(principal instanceof FleetPrincipal))
            return null;

        FleetPrincipal fleetPrincipal = (FleetPrincipal) principal;

        return fleetPrincipal.getUser();
    }
}
