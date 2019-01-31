package com.pmv.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pmv.entity.Platform;
import com.pmv.entity.PlatformDetail;
import com.pmv.service.PchService;
import com.pmv.service.PlatformDetailService;
import com.pmv.service.PlatformService;

@Controller
public class PlatformController {
	
	private static final Log LOG = LogFactory.getLog(PlatformController.class);
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@Autowired
	@Qualifier("platformDetailServiceImpl")
	private PlatformDetailService platformDetailServiceImpl;
	
	@Autowired
	@Qualifier("pchServiceImpl")
	private PchService pchServiceImpl;
	
	@GetMapping({"/admin/platformAdd"})
    public ModelAndView AddPlatformView() {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("AddPlatform");
		model.addObject("username",user.getUsername());
		LOG.info("Formulary to add new platform");
		return model;
		
    }
	
	
	@PostMapping({"/admin/platform/addNewPlatform"})
    public String addNewPlatform(@ModelAttribute(name="platform") Platform platform,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
		
			platformServiceImpl.addOne(platform);
			Date localDate = new Date();
			PlatformDetail newDetailPlatform = new PlatformDetail();
			newDetailPlatform.setLastUpdate(localDate);
			newDetailPlatform.setPlatform(platform);
			platformDetailServiceImpl.addOne(newDetailPlatform);
			model.addAttribute("success","success");
			return "AddPlatform";
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "AddPlatform";
		}

    }
	
	
	@GetMapping({"/admin/platform/updatePlatform"})
    public String updatePlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  platformServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/index";	
		}else {
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
		}

		return "updatePlatform";
    }
	
	
	@PostMapping({"/admin/platform/updatePlatformDetail"})
    public String updatePlatformDetail(@ModelAttribute(name="platform") Platform platform,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			platformServiceImpl.addOne(platform);
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platform.getPlatformId());
			LOG.info(newDetailPlatform.toString());
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			platformDetailServiceImpl.addOne(newDetailPlatform);
			model.addAttribute("success","success");
			
			return "updatePlatform";
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "updatePlatform";
		}

    }
	
	
	@PostMapping({"/admin/platform/updatePlatformPch"})
    public String updatePlatformDetaiPch(@RequestParam(name="platformId",required = false) Long platformId,
    		@RequestParam(name="pchVisualId",required = false) Long pchVisualId,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("pchs",pchServiceImpl.getAll());
			
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId);
			newDetailPlatform.setPch(pchServiceImpl.getOne(pchVisualId));
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			platformDetailServiceImpl.addOne(newDetailPlatform);
			model.addAttribute("success","success");
			model.addAttribute("pchs",pchServiceImpl.getAll());
			return "AddPch";
			
		}catch(DataIntegrityViolationException ex) {
			
			model.addAttribute("duplicate","The pch is located in the platform " + pchServiceImpl.getOne(pchVisualId).getPlatformDetail().getPlatform().getName());
			LOG.info(ex.toString());
			return "AddPch";
		}

    }
	
	
	
	
	
	
}
