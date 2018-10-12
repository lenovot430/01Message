package cn.hl.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler({Exception.class})
	public ModelAndView arithmeticExceptionHandler(Exception ex) {
		ModelAndView mv=new ModelAndView("/error.jsp");
		mv.addObject("exe", ex);
		System.out.println("ArithmeticException is do ...");

		return mv;
	}
	
}
