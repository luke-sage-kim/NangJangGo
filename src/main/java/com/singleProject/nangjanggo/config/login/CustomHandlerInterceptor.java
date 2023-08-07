package com.singleProject.nangjanggo.config.login;

import com.singleProject.nangjanggo.config.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@RequiredArgsConstructor
public class CustomHandlerInterceptor implements HandlerInterceptor {
    private final HttpSession httpSession;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");


        if (user != null) {
            if (modelAndView != null){
                modelAndView.addObject("user", user);

            } else {
                modelAndView = new ModelAndView();
                modelAndView.addObject("user", user);

            }
        }

    }

}
