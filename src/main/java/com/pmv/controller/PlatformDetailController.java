package com.pmv.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pmv.service.PlatformDetailService;
import com.pmv.service.UserService;

@Controller
public class PlatformDetailController {
	
	private static final Log LOG = LogFactory.getLog(AuthenticationController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("platformDetailServiceImpl")
	private PlatformDetailService platformDetailServiceImpl;
	
	@GetMapping({"/admin/platformDetail"})
    public ModelAndView index(@RequestParam(name="platformId",required = true) int platformId) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("detailplatform");
		model.addObject("username",user.getUsername());
		model.addObject("platform",platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId));
		LOG.info("Esta es el detalle de la plataforma " + platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId).toString());
		return model;
    }

}
