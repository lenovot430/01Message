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
	 * ������Ӳ���
	 * @param user
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping("/add")
	public String add(@Valid User user,BindingResult result,Map<String,Object> map) {
		
		if(result.getFieldErrorCount()>0) {
			//��ӡ�������Ϣ
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			//�洢����������Ա���Ϣ
			Map<Boolean,String> genders=new HashMap<Boolean,String>();
			genders.put(true, "Male");
			genders.put(false, "FeMale");
				
			//���Ա���Ϣ������ӵ�ModelAndView������
			map.put("genders", genders);
			
			//����ʼ�����User����洢��ModelAndView��
			map.put("user", user);
			
			
			return "/add.jsp";
		}
		
		return "/index.jsp";
	}
	
	/**
	 * ִ�г�������
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
	 * ִ�е�½����
	 * 		��һ��תΪHttp��״̬��
	 * @param account
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String account,String pwd) {
		
		if (!"admin".equals(account)||!"123".equals(pwd)) {
			throw new RuntimeException("������û���������");
			
		}
		return "index.jsp";
	}
	
	/**
	 * ִ�е�½����
	 * 	405-�û������벻ƥ��
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
	 * �Զ����쳣
	 * @author Gjl
	 *
	 */
	@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED,reason="�û��������벻ƥ��")
	public class CheckException extends RuntimeException{}
	
	/**
	 * Spring�ı�׼�쳣תΪHttp��״̬��
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
	 * ��������
	 * 	�����������Խ���������쳣����
	 * 	�����Ҫ��ҳ�洫���쳣��Ϣʱ,��Ҫʹ��ModelAndView������д���
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
