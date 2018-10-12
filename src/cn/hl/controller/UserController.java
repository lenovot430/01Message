package cn.hl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.hl.entity.User;

@Controller
public class UserController {

	/**
	 * 处理添加操作
	 * @param user
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping("/add")
	public String add(@Valid User user,BindingResult result,Map<String,Object> map) {
		
		if(result.getFieldErrorCount()>0) {
			//打印错误的信息
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			//存储表单中所需的性别信息
			Map<Boolean,String> genders=new HashMap<Boolean,String>();
			genders.put(true, "Male");
			genders.put(false, "FeMale");
				
			//将性别信息集合添加到ModelAndView对象中
			map.put("genders", genders);
			
			//将初始化后的User对象存储到ModelAndView中
			map.put("user", user);
			
			
			return "/add.jsp";
		}
		
		return "/index.jsp";
	}
	
	/**
	 * 执行除法运算
	 * @param i
	 * @return
	 */
	@RequestMapping("/div")
	public String div(int i) {
		
		int r=20/i;
		
		System.out.println("r="+r);
		
		return "/result.jsp";
	}
	
	/**
	 * 执行登陆操作
	 * 		将一场转为Http的状态码
	 * @param account
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String account,String pwd) {
		
		if (!"admin".equals(account)||!"123".equals(pwd)) {
			throw new RuntimeException("错误的用户名和密码");
			
		}
		return "index.jsp";
	}
	
	/**
	 * 执行登陆过程
	 * 	405-用户或密码不匹配
	 * @param account
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/login1")
	public String logining(String account,String pwd) {
		
		if (!"admin".equals(account)||!"123".equals(pwd)) {
			throw new CheckException();
			
		}
		return "index.jsp";
	}
	
	/**
	 * 自定义异常
	 * @author Gjl
	 *
	 */
	@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED,reason="用户名或密码不匹配")
	public class CheckException extends RuntimeException{}
	
	/**
	 * Spring的标准异常转为Http的状态码
	 * @return
	 */
	@RequestMapping(value="method1",method=RequestMethod.POST)
	public String postMethod() {
		
		System.out.println("postMethod() is do ...");
		
		return "index.jsp";
		
	}
	
	@RequestMapping("/all")
	public String allException(String name) {
		
		System.out.println("name="+name);
		System.out.println("nameLength="+name.length());
		
		return "index.jsp";
		
	}
	
	/**
	 * 错误处理方法
	 * 	错误处理方法可以接收任意的异常对象
	 * 	如果需要向页面传递异常信息时,需要使用ModelAndView对象进行传递
	 * @param ex
	 * @return
	 */
	/*@ExceptionHandler({ArithmeticException.class})
	public ModelAndView arithmeticExceptionHandler(ArithmeticException ex) {
		ModelAndView mv=new ModelAndView("/error.jsp");
		mv.addObject("ex", ex);
		
		return mv;
	}*/
	
}
