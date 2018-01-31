package com.ggp.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ggp.controller.base.BaseController;
import com.ggp.entity.User;
import com.ggp.service.login.LoginService;
import com.ggp.util.Const;
import com.ggp.util.SHA;


@Controller
public class LoginController extends BaseController{
	@Resource(name="loginService")
	private LoginService loginService;
	
	
	@RequestMapping(value="/login_tologin")
	public ModelAndView goLogin() throws Exception{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login/Login");
 		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/login_Name")
	public String  queryName(HttpServletRequest request) throws Exception{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		ModelAndView mv = this.getModelAndView();
		user.setUsername(name);
		user.setPassword(SHA.getResult(pwd));
		user = loginService.getName(user);
		if(user != null){
			return "true";
		}
		return "false";
	}
		
	
	@RequestMapping(value="/login")
	public ModelAndView login(@Param(value="uname") String uname ,
						  @Param(value="pwd") String pwd  ) throws Exception {
			ModelAndView mv = this.getModelAndView();
			String errInfo = "";
			
			if(!"".equals(uname) && !"".equals(pwd)){
				//密码加密
				String passwd = SHA.getResult(pwd);
				User user = new User();
				user.setUsername(uname);
				user.setPassword(passwd);
				user = loginService.getUser(user);
				if(user != null){
					HttpSession session = this.getRequest().getSession(true);
					session.setAttribute(Const.SESSION_USER, user);
					mv.setViewName("redirect:goIndex.do");
				}else{
					errInfo = "hasno";
					mv.setViewName("redirect:login_tologin.do");
				}
			}else{
				errInfo = "empty";
				mv.setViewName("redirect:login_tologin.do");
			}
			mv.addObject("errInfo", errInfo);
			return mv ;
	}
	
	
	@RequestMapping(value="/goIndex")
	public ModelAndView goIndex() throws Exception{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("index/index");
		return mv;
	}
	
}
