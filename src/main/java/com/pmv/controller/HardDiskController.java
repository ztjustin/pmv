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

import com.pmv.service.HardDiskService;
import com.pmv.service.PlatformService;

@Controller
public class HardDiskController {
	
	private static final Log LOG = LogFactory.getLog(HardDiskController.class);
	
	@Autowired
	@Qualifier("hardDiskServiceImpl")
	private HardDiskService hardDiskServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@GetMapping({"/admin/hardDisk"})
    public ModelAndView index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("hardDisks");
		model.addObject("username",user.getUsername());
		model.addObject("hardDisks",hardDiskServiceImpl.getAll());
		LOG.info("Esta es el detalle de los Hard Disks " + hardDiskServiceImpl.getAll().toString());
		return model;
    }
	
	
	@GetMapping({"/admin/addHardDiskToPlatform"})
    public String addHardDiskToPlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  hardDiskServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/hardDisk";	
		}else {
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("hardDisks",hardDiskServiceImpl.getHardDisksByNullPlatform());

		}

		return "AddHardDisk";
    }
	
	

}
