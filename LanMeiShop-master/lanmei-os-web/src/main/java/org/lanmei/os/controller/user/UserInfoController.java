package org.lanmei.os.controller.user;

import org.lanmei.os.common.session.SessionUtils;
import org.lanmei.user.dao.model.OsUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 处理用户登录，注册请求Controller
 * @author lgj
 * @date:2018/05/17
 */
@Api(value="/user/info",description="处理用户信息修改Controller")
@Controller
@RequestMapping("/user-info")
public class UserInfoController {
	
	
	private final static Logger logger = LoggerFactory.getLogger("UserLoginController.class");	
	{
		logger.debug("UserInfoController Create Bean............. ");
	}
	
	
	@ApiOperation(value="/user-login",httpMethod="GET",notes="请求个人中心页面")
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView  loginPage() {
		
		logger.debug("into /user-info");
		OsUser user=(OsUser) SessionUtils.getSession("currenLogintUser");
		

		ModelAndView mv = new ModelAndView("/user/info");
		mv.addObject("user", user);
		return mv;
	}
	@ApiOperation(value="/user-login",httpMethod="GET",notes="请求个人中心页面")
	@RequestMapping(path="/setting", method=RequestMethod.GET)
	public ModelAndView  infoSeting() {
		
		logger.debug("into /user-info/setting");
		
		OsUser user=(OsUser) SessionUtils.getSession("currenLogintUser");
		
		ModelAndView mv = new ModelAndView("/user/info-setting");
		mv.addObject("user", user);
		return mv;
	}
}
