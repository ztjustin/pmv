package com.pmv.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pmv.service.PlatformService;

@Controller
public class PlatformController {
	
	private static final Log LOG = LogFactory.getLog(PlatformController.class);
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@GetMapping({"/admin/platformAdd"})
    public ModelAndView AddPlatformView() {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("AddPlatform");
		model.addObject("username",user.getUsername());
		LOG.info("Formulary to add new platform");
		return model;
		
    }
	
	
	

}
