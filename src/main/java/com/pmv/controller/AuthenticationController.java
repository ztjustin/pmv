package com.pmv.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pmv.service.PlatformService;
import com.pmv.service.UserService;


@Controller
public class AuthenticationController {
	
	
	private static final Log LOG = LogFactory.getLog(AuthenticationController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	
	@GetMapping("/")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout",required=false) String logout){
		
		LOG.info("METHOD: showLoginForm() -- PARAMS: error="+error+",logout:"+logout);
		
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		LOG.info("Returning to login view");
		return "login";
	}
	
	/*En este controller debe de ir toda la logica de logeos, autentificacion y redirecciones*/

	
	@GetMapping({"/admin/index"})
    public ModelAndView index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("platforms");
		model.addObject("username",user.getUsername());
		model.addObject("platforms",platformServiceImpl.getAll());
		LOG.info(platformServiceImpl.getAll().toString());
		return model;
    }
	
	
	@GetMapping("/admin/logout")
	public ModelAndView logout(){
		SecurityContextHolder.getContext().setAuthentication(null);
		return new ModelAndView(new RedirectView("/"));
	}
	
	
	
	
	
	

	
}