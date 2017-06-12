package com.organic.agriculture.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = OrganicAgrException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, OrganicAgrException e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
	
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
    

    /**
     * session失效的异常拦截
     * 把Exception替换成session time out的exception，shiro的时候使用InvalidSessionException，UnknownSessionException
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String sessionTimeout(Exception e, Model model, HttpServletRequest request, HttpServletResponse response) {
//        model.addAttribute("tips", "session超时");
//        return "/login.html";
//    }
    
    /**
     * 拦截未知的运行时异常
     *
     */
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorInfo notFount(RuntimeException e) {
//    }
}
