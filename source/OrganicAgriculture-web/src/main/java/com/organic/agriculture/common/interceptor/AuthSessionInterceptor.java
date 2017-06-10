package com.organic.agriculture.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.organic.agriculture.common.Application;
import com.organic.agriculture.common.session.AuthLocator;
import com.organic.agriculture.common.session.ServletAuthLocator;

/**
 * 
 */
public class AuthSessionInterceptor implements HandlerInterceptor {

    private String forwardUrl = Application.DEFAULT_FORWARD_URL;

    /**
     * Controller処理前呼び出す preHandle true 次の処理を行う、falseキャンセル
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        if (isLogin(request))
//            return true;
//
//        if (handler instanceof HandlerMethod) {
//            if (((HandlerMethod) handler).getBean().getClass().getName().contains(UserController.class.getName())) {
//                return true;
//            }
//        }
//        
//        if (forwardUrl.equals(request.getServletPath())) {
//            return true;
//        }
//        request.getSession().invalidate();
//        response.sendRedirect(request.getContextPath() + forwardUrl);
//    	return false;
        return true;
    }

    /**
     * Controller実行あと処理を行う
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        return;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    /**
     * セッション情報存在かを通して、登録されたか判断
     */
    private boolean isLogin(HttpServletRequest request) {
        AuthLocator locator = new ServletAuthLocator(request);
        if (!locator.isAuth()) {
            return false;
        }
        return true;
    }
}
