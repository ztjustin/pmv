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

import com.pmv.service.HardDiskService;

@Controller
public class HardDiskController {
	
	private static final Log LOG = LogFactory.getLog(HardDiskController.class);
	
	@Autowired
	@Qualifier("hardDiskServiceImpl")
	private HardDiskService hardDiskServiceImpl;
	
	@GetMapping({"/admin/hardDisk"})
    public ModelAndView index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("hardDisks");
		model.addObject("username",user.getUsername());
		model.addObject("hardDisks",hardDiskServiceImpl.getAll());
		LOG.info("Esta es el detalle de los Hard Disks " + hardDiskServiceImpl.getAll().toString());
		return model;
    }

}
